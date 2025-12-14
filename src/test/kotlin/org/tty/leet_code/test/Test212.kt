package org.tty.leet_code.test

import org.tty.leet_code.Solution212
import kotlin.test.Test

class Test212 {
    @Test
    fun test212() {
        val solution = Solution212()
//        val board = arrayOf(
//            charArrayOf('o', 'a', 'a', 'n'),
//            charArrayOf('e', 't', 'a', 'e'),
//            charArrayOf('i', 'h', 'k', 'r'),
//            charArrayOf('i', 'f', 'l', 'v')
//        )
//        val words = arrayOf("oath", "pea", "eat", "rain")
//
//        println(solution.findWords(board, words))
        println(solution.findWords(arrayOf(charArrayOf('a', 'a')), arrayOf("aaa")))
    }
}