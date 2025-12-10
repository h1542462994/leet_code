package org.tty.leet_code

class Solution49 {
    class Count(s: String) {
        private val charHash = IntArray(26) { 0 }

        init {
            for (c in s) {
                charHash[c - 'a'] += 1
            }
        }

        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Count) {
                return false
            }

            for (i in 0 until 26) {
                if (charHash[i] != other.charHash[i]) {
                    return false
                }
            }
            return true
        }

        override fun hashCode(): Int {
            var result = 0
            for (i in 0 until 26) {
                result = result * 31 + charHash[i]
            }
            return result
        }
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val resultMap = mutableMapOf<Count, MutableList<String>>()

        for (str in strs) {
            val count = Count(str)
            if (resultMap.containsKey(count)) {
                resultMap[count]!!.add(str)
            } else {
                resultMap[count] = mutableListOf(str)
            }
        }

        return resultMap.values.toList()
    }
}