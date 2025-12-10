package org.tty.leet_code

import java.util.Stack

class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val numStack = Stack<Int>()
        for (token in tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                val b = numStack.pop()
                val a = numStack.pop()

                val result: Int = when(token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> 0
                }
                numStack.add(result)
            } else {
                numStack.add(token.toInt())
            }
        }

        return numStack.peek()
    }
}