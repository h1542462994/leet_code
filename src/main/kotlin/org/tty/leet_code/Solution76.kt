package org.tty.leet_code

import kotlin.collections.set

class Solution76 {
    class Counted(val table: MutableMap<Char, Int>) {
        fun covers(other: Counted): Boolean {
            for (pair in other.table) {
                val cur = table[pair.key] ?: 0
                if (cur < pair.value) {
                    return false
                }
            }
            return true
        }

        fun apply(c: Char) {
            val cur = table[c] ?: 0
            table[c] = cur + 1
        }

        fun remove(c: Char) {
            val cur = table[c]!!
            table[c] = cur - 1
        }

        companion object {
            fun fromString(s: String): Counted {
                val table: MutableMap<Char, Int> = mutableMapOf()
                for (c in s) {
                    if (!table.containsKey(c)) {
                        table[c] = 1
                    } else {
                        table[c] = table[c]!! + 1
                    }
                }
                return Counted(table)
            }

        }
    }

    fun minWindow(s: String, t: String): String {
        val tCounted = Counted.fromString(t)

        if (s.length < t.length) {
            return ""
        }

        var l = 0
        var r = t.length
        val sCounted = Counted.fromString(s.substring(l, r))

        var minValue: Int? = null
        var minResult: String = ""

        // 迭代所有滑动窗口
        while (r <= s.length) {
            if (sCounted.covers(tCounted)) { // 如果匹配，并更新答案
                val length = r - l
                if (minValue == null || length < minValue) {
                    minValue = length
                    minResult = s.substring(l, r)
                }

                sCounted.remove(s[l])
                l++
            } else { // 否则，扩展右窗
                if (r < s.length) {
                    sCounted.apply(s[r])
                }
                r++
            }
        }

        return minResult
    }
}