package org.tty.leet_code

class Solution54 {
    data class ScanRange(
        val rowRange: IntRange,
        val columnRange: IntRange,
        val direction: Boolean
    ) {
        val isEmpty: Boolean
            get() {
                return rowRange.isEmpty() || columnRange.isEmpty()
            }

        val next: ScanRange
            get() {
                return if (direction) {
                    ScanRange(
                        rowRange.first + 1..rowRange.last,
                        columnRange.first until columnRange.last,
                        false
                    )
                } else {
                    ScanRange(
                        rowRange.first until rowRange.last,
                        columnRange.first + 1..columnRange.last,
                        true
                    )
                }
            }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        val result = mutableListOf<Int>()

        var scanRange = ScanRange(0 until rowCount, 0 until columnCount, true)
        while (!scanRange.isEmpty) {
            if (scanRange.direction) {
                for (i in scanRange.columnRange) {
                    result.add(matrix[scanRange.rowRange.first][i])
                }
                for (i in scanRange.rowRange.first + 1..scanRange.rowRange.last) {
                    result.add(matrix[i][scanRange.columnRange.last])
                }
            } else {
                for (i in scanRange.columnRange.reversed()) {
                    result.add(matrix[scanRange.rowRange.last][i])
                }
                for (i in (scanRange.rowRange.first until scanRange.rowRange.last).reversed()) {
                    result.add(matrix[i][scanRange.columnRange.first])
                }
            }
            scanRange = scanRange.next
        }

        return result
    }
}