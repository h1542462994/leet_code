package org.tty.leet_code

import java.util.Stack

class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c)
            } else if (stack.empty()) {
                return false
            } else {
                val top = stack.peek()
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
        return stack.empty()
    }
}