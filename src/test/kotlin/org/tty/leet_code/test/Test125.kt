package org.tty.leet_code.test

import org.tty.leet_code.Solution125
import kotlin.test.Test

class Test125 {
    @Test
    fun test125() {
        val s = "A man, a plan, a canal: Panama"
        val solution = Solution125()
        println(solution.isPalindrome(s))
    }
}