package org.tty.leet_code.structs

class BigInt {

    /// sign, positive is "1", negative is "-1"
    private val sign: Int

    /// units split by 10^3, from lower bits to higher bits
    private val units: List<Int>

    constructor(value: String)  {
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
    }

}