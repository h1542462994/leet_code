package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution30V2

class Test30 {
    @Test
    fun test30() {
        val solution = Solution30V2()
        val s = "barfoothefoobarman"
        val words = arrayOf("foo", "bar")
        println(solution.findSubstring(s, words))

        val s2 = "wordgoodgoodgoodbestword"
        val words2 = arrayOf("word", "good", "best", "word")
        println(solution.findSubstring(s2, words2))

        val s3 = "barfoofoobarthefoobarman"
        val words3 = arrayOf("bar", "foo", "the")
        println(solution.findSubstring(s3, words3))
    }
}