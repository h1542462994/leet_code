package org.tty.leet_code

import java.util.Stack

class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val stack = Stack<Char>()
        val symbols = mutableListOf<Char>()
        val receiver = mutableListOf<String>()

        place(n, n, stack, symbols, receiver)

        return receiver
    }


    fun place(
        left: Int,
        right: Int,
        stack: Stack<Char>,
        symbols: MutableList<Char>,
        receiver: MutableList<String>
    ) {
        if (left == 0) { // 左括号已用完
            receiver.add(symbols.joinToString("") + ")".repeat(right))
            return
        }

        // left > 0.
        symbols.add('(')
        stack.add('(')
        place(left - 1, right, stack, symbols, receiver)
        symbols.removeLast()
        stack.removeLast()

        // can right.
        if (stack.isNotEmpty() && stack.last() == '(') {
            symbols.add(')')
            stack.removeLast()
            place(left, right - 1, stack, symbols, receiver)
            symbols.removeLast()
            stack.add('(')
        }
    }


}