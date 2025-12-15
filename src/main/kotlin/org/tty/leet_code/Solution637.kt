package org.tty.leet_code

class Solution637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        requireNotNull(root)

        val result = mutableListOf<Double>()
        val queue = mutableListOf(root)
        var sum: Double = 0.0
        var count: Int = 0

        while (true) {
            val length = queue.size
            if (length == 0) {
                break
            }

            for (i in 0 until length) {
                val cur = queue.removeFirst()
                sum += cur.`val`
                count ++
                if (cur.left != null) {
                    queue.add(cur.left!!)
                }
                if (cur.right != null) {
                    queue.add(cur.right!!)
                }
            }

            result.add(sum / count)
            sum = 0.0
            count = 0
        }
        return result.toDoubleArray()
    }
}