package org.tty.leet_code.test

object Interact {
    fun readIntArray(value: String): IntArray {
        val length = value.length
        return value
            .slice(1 until length - 1)
            .split(",")
            .map { it.toInt() }
            .toIntArray()
    }

    fun writeIntArray(value: IntArray): String {
        return "[${value.joinToString(", ")}]"
    }
}