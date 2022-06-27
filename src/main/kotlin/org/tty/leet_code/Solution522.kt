package org.tty.leet_code

import kotlin.math.max

/**
 * 522::Longest Uncommon Subsequence II
 *
 * Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.
 *
 * An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
 *
 * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
 * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 *
 * **Solution:**
 * 1. iter the substring (from max to 2) and check. (hack)
 * 2. *if a is substring of b (a != b), so if a is a LUS string, then b is a LUS string. which mean the substring of any str in strs will not be the LUS string.*
 *
 * (Solution522V2) is a proper solution.
 *
 * - time complexity: O(n^2 * l)
 * - storage complexity: O(u)
 *
 * **Result:**
 * - time 172ms 66.67%
 * - memory 35.2MB 33.33%
 */
class Solution522 {
    fun findLUSlength(strs: Array<String>): Int {
        fun removeAtToNewString(str: String, index: Int): String {
            return when (index) {
                0 -> {
                    str.substring(1 until str.length)
                }
                str.length - 1 -> {
                    str.substring(0 until str.length - 1)
                }
                else -> {
                    str.substring(0 until index) + str.substring(index + 1 until str.length)
                }
            }
        }

        // initialize
        val storage = mutableListOf<MutableList<String>>()
        var startLength = 0
        strs.forEach { if (it.length > startLength) { startLength = it.length } }

        strs.forEach {
            val list = mutableListOf<String>()
            list.add(it)
            storage.add(list)
        }

        fun isSubOf(value: String, comp: String): Boolean {
            if (value.length > comp.length) {
                return false
            } else if (value.length == comp.length) {
                return value == comp
            }

            var i = 0
            var j = 0
            while (i < comp.length && j < value.length) {
                if (comp[i] == value[j]) {
                    i++
                    j++
                } else {
                    i++
                }
            }
            return j == value.length
        }

        fun checkSingle(value: String, exceptIndex: Int): Boolean {
            for (i in strs.indices) {
                if (i == exceptIndex) { continue }
                if (isSubOf(value, strs[i])) { return false }
            }
            return true
        }

        var i = startLength
        // scan
        while (i >= 1) {
            if (storage.all { it.isEmpty() }) { return -1 }
            for (j in strs.indices) {
                if (strs[j].length == i) {
                    while (storage[j].first().length == i) {
                        val value = storage[j].removeAt(0)

                        if (checkSingle(value, j)) { return value.length }

                        // add all
                        for (k in value.indices) {
                            val s = removeAtToNewString(value, k)
                            if (s !in storage[j]) {
                                storage[j].add(s)
                            }
                        }
                    }
                }
            }
            i--
        }

        return -1
    }
}

/**
 * **Solution:**
 * 1. for str in strs, if str is a LUS string, record it length
 * 2. use double pointer to check the substring.
 * 3. return the maxLength
 *
 * **Result:**
 * - time 128ms 100%
 * - memory 32.9MB 100%
 */
class Solution522V2 {
    fun findLUSlength(strs: Array<String>): Int {


        fun isSubOf(value: String, comp: String): Boolean {
            if (value.length > comp.length) {
                return false
            } else if (value.length == comp.length) {
                return value == comp
            }

            var i = 0
            var j = 0
            while (i < comp.length && j < value.length) {
                if (comp[i] == value[j]) {
                    i++
                    j++
                } else {
                    i++
                }
            }
            return j == value.length
        }

        fun checkSingle(value: String, exceptIndex: Int): Boolean {
            for (i in strs.indices) {
                if (i == exceptIndex) { continue }
                if (isSubOf(value, strs[i])) { return false }
            }
            return true
        }


        var maxLength = -1
        for (i in strs.indices) {
            val str = strs[i]
            if (checkSingle(str, i)) { maxLength = max(maxLength, str.length) }
        }

        return maxLength
    }
}