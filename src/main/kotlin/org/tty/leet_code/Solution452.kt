package org.tty.leet_code

class Solution452 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var sum = 0
        var range: IntArray? = null

        points.sortWith { a, b ->
            if (a[0] != b[0]) {
                a[0].compareTo(b[0])
            } else {
                a[1].compareTo(b[1])
            }
        }
        for (point in points) {
            if (range == null || point[0] > range[1]) {
                sum += 1
                range = point
            } else if (point[1] < range[1]) {
                range[1] = point[1]
            }
        }
        return sum
    }
}