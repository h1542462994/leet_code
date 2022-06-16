package org.tty.leet_code.test

object Inputs {
    fun intArray(value: String): IntArray {
        val length = value.length
        return value
            .slice(1 until length - 1)
            .split(",")
            .map { it.toInt() }
            .toIntArray()
    }
}