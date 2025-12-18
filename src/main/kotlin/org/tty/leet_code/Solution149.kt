package org.tty.leet_code

import kotlin.math.abs
import kotlin.math.max

class Solution149 {
    data class Slope(
        val x: Int, // x上的截距
        val y: Int, // y上的截距
    ) {
        companion object {
            fun fromPoints(point1: IntArray, point2: IntArray): Slope {
                var ax = point1[0] - point2[0]
                var ay = point1[1] - point2[1]

                require(!(ax == 0 && ay == 0))
                if (ax == 0) {
                    return Slope(0, 1)
                } else if (ay == 0) {
                    return Slope(1, 0)
                }

                if (ax < 0) { // 标准化x为正值
                    ax = -ax
                    ay = -ay
                }

                val comp = gcd(abs(ax), abs(ay)) // 求最简整数比
                ax = ax / comp
                ay = ay / comp
                return Slope(ax, ay)
            }

            private fun gcd(a: Int, b: Int): Int {
                if (a < b) {
                    return gcd(b, a)
                }

                if (b == 0) return a
                return gcd(b, a % b)
            }

        }
    }


    fun maxPoints(points: Array<IntArray>): Int {
        var result = 0

        for (i in points.indices) {
            // 经过点i所有的斜率统计
            val slopeMap = mutableMapOf<Slope, Int>()
            for (j in points.indices) {
                if (j != i) {
                    val slope = Slope.fromPoints(points[i], points[j])
                    slopeMap[slope] = (slopeMap[slope] ?: 0) + 1
                }
            }
            result = max(result, (slopeMap.maxOfOrNull { it.value } ?: 0) + 1)
        }
        return result
    }
}