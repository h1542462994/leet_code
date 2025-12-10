package org.tty.leet_code

import java.util.Stack

class Solution71 {
    fun simplifyPath(path: String): String {
        val proceeding = StringBuilder()
        val components = Stack<String>()

        fun submit() {
            when (proceeding.toString()) {
                ".", "" -> {
                }
                ".." -> {
                    if (components.isNotEmpty()) {
                        components.pop()
                    }
                }
                else -> {
                    components.add(proceeding.toString())
                }
            }
            proceeding.clear()
        }
        for (char in path) {
            if (char == '/') {
                submit()
            } else {
                proceeding.append(char)
            }
        }
        submit()


        if (components.empty()) {
            return "/"
        } else {
            val builder = StringBuilder()
            for (comp in components) {
                builder.append("/").append(comp)
            }
            return builder.toString()
        }
    }
}