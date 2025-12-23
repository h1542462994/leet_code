package org.tty.leet_code.structs

import kotlin.math.cos
import kotlin.math.sin

data class Complex(var re: Double, var im: Double) {
    operator fun plus(other: Complex) = Complex(re + other.re, im + other.im)
    operator fun minus(other: Complex) = Complex(re - other.re, im - other.im)
    operator fun times(other: Complex) = Complex(re * other.re - im * other.im, re * other.im + im * other.re)

    operator fun plus(other: Double) = Complex(re + other, im)
    operator fun minus(other: Double) = Complex(re - other, im)
    operator fun times(other: Double) = Complex(re * other, im * other)

    companion object {
        val ZERO = Complex(0.0, 0.0)
    }
}

class BigInt {

    /// sign, positive is "1", negative is "-1"
    private val sign: Int

    /// units split by 10^3, from lower bits to higher bits
    private val units: List<Int>

    private constructor(sign: Int, units: List<Int>) {
        this.sign = sign
        this.units = units
    }

    constructor(value: String) {
        val comp = parseString(value)
        this.sign = comp.first
        this.units = comp.second
    }

    constructor(value: Int) {
        val comp = parseString(value.toString())
        this.sign = comp.first
        this.units = comp.second
    }

    constructor(value: Long) {
        val comp = parseString(value.toString())
        this.sign = comp.first
        this.units = comp.second
    }

    operator fun times(other: BigInt): BigInt {
        // zero check.
        if (this == ZERO || other == ZERO) {
            return ZERO
        }

        val a = this.units
        val b = other.units

        val resultUnits = fftMultiply(a, b)
        return BigInt(sign = this.sign * other.sign, units = normalize(resultUnits))
    }

    override fun toString(): String {
        if (units.size == 1 && units[0] == 0) {
            return "0"
        }

        val sb = StringBuilder()

        if (sign < 0) {
            sb.append('-')
        }

        // highest unit (no leading zeros)
        sb.append(units.last())

        // remaining units (pad with zeros)
        for (i in units.size - 2 downTo 0) {
            sb.append(units[i].toString().padStart(3, '0'))
        }

        return sb.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BigInt) return false

        if (sign != other.sign) return false
        if (units.size != other.units.size) return false

        for (i in units.indices) {
            if (units[i] != other.units[i]) return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = sign
        for (u in units) {
            result = 31 * result + u
        }
        return result
    }

    companion object {
        private const val BASE = 1000
        private const val BASE_DIGITS = 3

        val ZERO = BigInt(0)

        private fun parseString(value: String): Pair<Int, List<Int>> {
            var s = value.trim()
            require(s.isNotEmpty()) { "Empty input" }

            // ---------- Step 1: sign ----------
            val sign = when {
                s[0] == '-' -> {
                    s = s.substring(1)
                    -1
                }

                s[0] == '+' -> {
                    s = s.substring(1)
                    1
                }

                else -> 1
            }
            val units: List<Int>

            // ---------- Step 2: expand scientific notation ----------
            s = expandScientific(s)

            // ---------- Step 3: validate integer ----------
            require(s.all { it.isDigit() }) { "Not a valid integer: $value" }

            // ---------- Step 4: remove leading zeros ----------
            s = s.trimStart('0')
            if (s.isEmpty()) {
                units = listOf(0)
            } else {
                // ---------- Step 5: split into base-1000 units ----------
                val tmp = mutableListOf<Int>()
                var i = s.length
                while (i > 0) {
                    val start = maxOf(0, i - BASE_DIGITS)
                    tmp.add(s.substring(start, i).toInt())
                    i = start
                }
                units = tmp
            }
            return sign to units
        }

        private fun expandScientific(s: String): String {
            if (!s.contains('e', true)) return s

            val parts = s.lowercase().split('e')
            require(parts.size == 2) { "Invalid scientific notation: $s" }

            val mantissa = parts[0]
            val exponent = parts[1].toIntOrNull()
                ?: throw IllegalArgumentException("Invalid exponent: $s")

            val dotIndex = mantissa.indexOf('.')

            val digits: String
            val fracLen: Int

            if (dotIndex >= 0) {
                digits = mantissa.removeSuffix("").replace(".", "")
                fracLen = mantissa.length - dotIndex - 1
            } else {
                digits = mantissa
                fracLen = 0
            }

            val shift = exponent - fracLen

            return when {
                shift >= 0 -> digits + "0".repeat(shift)
                else -> {
                    // decimal point would move left → fractional result
                    throw IllegalArgumentException("Not an integer: $s")
                }
            }
        }

        private fun fftMultiplyComplex(a: List<Int>, b: List<Int>): LongArray {
            var n = 1
            while (n < a.size + b.size) n = n shl 1

            val fa = Array(n) { Complex.ZERO }
            for (i in a.indices) fa[i].re = a[i].toDouble()
            for (i in b.indices) fa[i].im = b[i].toDouble()

            fft(fa, false)

            val fb = Array(n) { Complex.ZERO }
            fb[0] = Complex(fa[0].re * fa[0].im, 0.0)

            for (i in 1 .. (n - 1) / 2) {
                val j = (n - i) and (n - 1)

                val a1 = Complex(fa[i].re + fa[j].re, fa[i].im - fa[j].im) * 0.5
                val b1 = Complex(fa[i].im + fa[j].im, fa[j].re - fa[i].re) * 0.5
                val a2 = Complex(fa[j].re + fa[i].re, fa[j].im - fa[i].im) * 0.5
                val b2 = Complex(fa[j].im + fa[i].im, fa[i].re - fa[j].re) * 0.5

                fb[i] = a1 * b1 + a1.re * b2.im + a1.im * b2.re
                fb[j] = a2 * b2 + a2.re * b1.im + a2.im * b1.re
            }

            fft(fb, true)

            val result = LongArray(n)
            for (i in result.indices) {
                result[i] = (fb[i].re + 0.5).toLong()
            }
            return result
        }

        private fun fftMultiply(a: List<Int>, b: List<Int>): LongArray {
            var n = 1
            while (n < a.size + b.size) n = n shl 1

            val fa = Array(n) { Complex.ZERO }
            val fb = Array(n) { Complex.ZERO }

            for (i in a.indices) fa[i].re = a[i].toDouble()
            for (i in b.indices) fb[i].re = b[i].toDouble()

            fft(fa, false)
            fft(fb, false)

            for (i in 0 until n) {
                fa[i] = fa[i] * fb[i]
            }

            fft(fa, true)

            val result = LongArray(n)
            for (i in 0 until n) {
                result[i] = (fa[i].re + 0.5).toLong()
            }

            return result
        }

        private fun normalize(raw: LongArray): List<Int> {
            val result = mutableListOf<Int>()
            var carry = 0L

            for(i in raw.indices) {
                val value = raw[i] + carry
                result.add((value % BASE).toInt())
                carry = value / BASE
            }

            while (carry > 0) {
                result.add((carry % BASE).toInt())
                carry /= BASE
            }

            while (result.size > 1 && result.last() == 0) {
                result.removeAt(result.lastIndex)
            }

            return result
        }

        private fun fft(a: Array<Complex>, invert: Boolean) {
            val n = a.size
            var j = 0
            for (i in 1 until n) {
                var bit = n shr 1
                while (j and bit != 0) {
                    j = j xor bit
                    bit = bit shr 1
                }
                j = j or bit
                if (i < j) {
                    val temp = a[i]
                    a[i] = a[j]
                    a[j] = temp
                }
            }

            var len = 2
            while (len <= n) {
                val ang = 2 * Math.PI / len * if (invert) - 1 else 1
                val wlen = Complex(cos(ang), sin(ang))

                for (i in 0 until n step len) {
                    var w = Complex(1.0, 0.0)
                    for (j2 in 0 until len / 2) {
                        val u = a[i + j2]
                        val v = a[i + j2 + len / 2] * w

                        a[i + j2] = u + v
                        a[i + j2 + len / 2] = u - v

                        w *= wlen
                    }
                }
                len = len shl 1
            }

            if (invert) {
                for (i in 0 until n) {
                    a[i].re / n
                    a[i].im / n
                }
            }
        }
    }

}