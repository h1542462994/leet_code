package org.tty.leet_code.test

import org.tty.leet_code.Solution71
import kotlin.test.Test

class Test71 {
    @Test
    fun test71() {
        val solution = Solution71()
//        println(solution.simplifyPath("/home/"))
//        println(solution.simplifyPath("/home//foo/"))
//        println(solution.simplifyPath("/home/user/Documents/../Pictures"))
//        println(solution.simplifyPath("/../"))
//        println(solution.simplifyPath("/.../a/../b/c/../d/./"))
        println(solution.simplifyPath("/a//b////c/d//././/.."))
    }
}