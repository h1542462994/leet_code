package org.tty.leet_code

class Solution52 {
    class Placing {
        val columns: HashSet<Int> = HashSet()
        val diagonals1: HashSet<Int> = HashSet()
        val diagonals2: HashSet<Int> = HashSet()

        fun canPlace(row: Int, column: Int): Boolean {
            return !columns.contains(column) && !diagonals1.contains(row - column) && !diagonals2.contains(row + column)
        }

        fun place(row: Int, column: Int) {
            columns.add(column)
            diagonals1.add(row - column)
            diagonals2.add(row + column)
        }

        fun unplace(row: Int, column: Int) {
            columns.remove(column)
            diagonals1.remove(row - column)
            diagonals2.remove(row + column)
        }
    }

    fun totalNQueens(n: Int): Int {
        val placing = Placing()
        return place(n, 0, placing)
    }

    fun totalNQueensTable(n: Int): Int {
        val result = intArrayOf(1, 0, 0, 2, 10, 4, 40, 92, 352)
        return result[n - 1]
    }


    fun place(n: Int, k: Int, placing: Placing): Int {
        if (n == k) {
            return 1
        }

        var result = 0
        for (column in 0 until n) {
            if (placing.canPlace(k, column)) {
                placing.place(k, column)
                result += place(n, k + 1, placing)
                placing.unplace(k, column)
            }
        }
        return result
    }


}