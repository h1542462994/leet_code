package org.tty.leet_code

/**
 * 241::Different Ways to Add Parentheses
 *
 * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
 *
 * The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
 *
 * **Solution:**
 *
 * it is a classic range dp problem.
 * 1. transfer equation is: `table[i, j] = all(t = i .. j - 1)(table[i, t] ** table[t + 1, j] by operator[t])`
 * 2. time complexity is O(n^3), mean have 3 for blocks.
 *
 * **Result:**
 * - time: 160ms 100%
 * - memory: 34.9MB 100%
 * - at 2022/7/1
 */
class Solution241 {

    data class Expression(
        val numbers: List<Int>,
        val operators: List<Char>
    )

    private fun calculateExpression(expression: String): Expression {
        val numbers = mutableListOf<String>()
        val operators = mutableListOf<Char>()

        var s = ""
        for (token in expression) {
            if (token.isDigit()) {
                s += token
            } else {
                numbers.add(s)
                s = ""
                operators.add(token)
            }
        }
        numbers.add(s)

        return Expression(
            numbers = numbers.map { it.toInt() },
            operators = operators
        )
    }

    /**
     * a ** b by operator
     */
    private fun crossMultiply(left: List<Int>, right: List<Int>, operator: Char): List<Int> {
        val result = mutableListOf<Int>()
        left.forEach { a ->
            right.forEach { b ->
                when (operator) {
                    '-' -> {
                        result.add(a - b)
                    }
                    '+' -> {
                        result.add(a + b)
                    }
                    else -> {
                        result.add(a * b)
                    }
                }
            }
        }
        return result
    }

    /**
     * range dp
     * time complexity O(n^2)
     * space complexity O(n^3)
     */
    fun diffWaysToCompute(expression: String): List<Int> {
        val exp = calculateExpression(expression)
        println(exp)
        val numberCount = exp.numbers.size
        // create a table can be select by table[i][j]
        val tableResult = List<List<MutableList<Int>>>(numberCount) {
            List(numberCount) {
                mutableListOf<Int>()
            }
        }

        // range Dp
        for (gap in 0 until numberCount) {
            for (i in 0 until numberCount - gap) {
                val j = i + gap

                if (i == j) {
                    tableResult[i][j].add(exp.numbers[i])
                } else {
                    for (t in i until j) {
                        tableResult[i][j].addAll(
                            crossMultiply(
                                left = tableResult[i][t],
                                right = tableResult[t + 1][j],
                                operator = exp.operators[t]
                            )
                        )
                    }
                }
            }
        }

        return tableResult[0][numberCount - 1]
    }
}