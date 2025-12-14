package org.tty.leet_code

class Solution17 {
    fun letterCombinations(digits: String): List<String> {
        val letterMap = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        val resultList = mutableListOf("")
        for (c in digits) {
            val length = resultList.size

            for (i in 0 until length) {
                val cur = resultList.removeFirst()
                val letters = letterMap[c]!!
                for (l in letters) {
                    resultList.add(cur + l)
                }
            }
        }
        return resultList
    }
}