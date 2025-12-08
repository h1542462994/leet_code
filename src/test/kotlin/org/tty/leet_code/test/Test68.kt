package org.tty.leet_code.test

import org.tty.leet_code.Solution68
import kotlin.test.Test

class Test68 {
    @Test
    fun test68() {
        val words = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
        val solution = Solution68()
        println(solution.fullJustify(words, 16))

        val words2 = arrayOf("What","must","be","acknowledgment","shall","be")
        println(solution.fullJustify(words2, 16))
    }
}