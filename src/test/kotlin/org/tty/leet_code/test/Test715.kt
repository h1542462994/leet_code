package org.tty.leet_code.test

import org.tty.leet_code.RangeModule
import kotlin.test.Test

class Test715 {
    @Test
    fun test715() {
        val rangeModule = RangeModule()

//        rangeModule.addRange(10, 14)
//        println(rangeModule)
//        rangeModule.addRange(16, 20)
//        println(rangeModule)
//        rangeModule.removeRange(5, 29)
//        println(rangeModule)
//        rangeModule.addRange(10, 20)
//        println(rangeModule)
//        rangeModule.removeRange(14, 16)
//        println(rangeModule)
//
//        println(rangeModule.queryRange(10, 14))
//        println(rangeModule.queryRange(13, 15))
//        println(rangeModule.queryRange(16, 17))
//
//        rangeModule.addRange(5, 8)
//        rangeModule.removeRange(5, 6)
//        rangeModule.removeRange(3, 6)
//        rangeModule.addRange(1, 3)
//        rangeModule.addRange(4, 8)
//        println(rangeModule)
//        println(rangeModule.queryRange(2,3))

        rangeModule.addRange(14, 100)
        rangeModule.removeRange(1, 8)
        rangeModule.removeRange(3, 9)
        rangeModule.removeRange(45, 49)
        rangeModule.removeRange(41, 90)
        rangeModule.addRange(58, 79)
        rangeModule.addRange(4, 83)
        rangeModule.addRange(34, 39)
        println(rangeModule)
    }
}