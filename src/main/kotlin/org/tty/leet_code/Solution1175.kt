package org.tty.leet_code

/**
 * 1175::Prime Arrangements
 *
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * **Solution:**
 * 1. use prime filter to calculate the number of the primes, mark as u.
 * 2. calculate A(u) * A(n - u).
 *
 * **Result: **
 * - time 132ms 100%
 * - memory 32.3MB 100.0%
 */
class Solution1175 {
    companion object {
        const val N_SIZE = 1000000007
    }

    fun numPrimeArrangements(n: Int): Int {
        // use primeFilter to calculate the prime count 埃氏筛
        // 0 .. n
        val primes: BooleanArray = BooleanArray(n + 1) { true }
        for (i in 2 .. n) {
            // if i is prime, then 2 * i, 3 * i, ... k * i is not prime.
            if (primes[i]) {
                var j = 2
                while (true) {
                    if (i * j <= n) {
                        primes[i * j] = false
                        ++j
                    } else {
                        break
                    }
                }
            }
        }
        primes[0] = false
        primes[1] = false
        val primeCount = primes.count { it }

        // then calculates A(u) * A(n - u)
        var a = primeCount
        var b = n - primeCount
        if (a > b) {
            val t = a
            a = b
            b = t
        }
        var result = 1L
        var num = 1L
        for (i in 1 .. b) {
            num = (num * i) % N_SIZE

            if (a == i) {
                result = (result * num) % N_SIZE
            }
            if (b == i) {
                result = (result * num) % N_SIZE
            }
        }

        return result.toInt()
    }
}