package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution241

class Test241 {
    @Test
    fun test241() {
        val solution = Solution241()
        val result = solution.diffWaysToCompute("1*2+3*4*5*6+7*8+9+10+11")
        println(result)
    }
}