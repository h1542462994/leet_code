package org.tty.leet_code.test

import org.tty.leet_code.RandomizedSet
import kotlin.test.Test

class Test380 {
    @Test
    fun test380() {
        val randomizedSet = RandomizedSet()
        println(randomizedSet.insert(1))

        println(randomizedSet.remove(2))
        println(randomizedSet.insert(2))
        println(randomizedSet.getRandom())
        println(randomizedSet.remove(1))
        println(randomizedSet.insert(2))
        println(randomizedSet.getRandom())
    }
}