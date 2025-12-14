package org.tty.leet_code

import kotlin.math.max

class Solution124 {
    data class Summary(
        var include: Int,
        var total: Int
    )

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return calcSummary(root)!!.total
    }

    fun calcSummary(node: TreeNode?): Summary? {
        if (node == null) {
            return null
        }

        val value = node.`val`
        if (node.left == null && node.right == null) {
            return Summary(value, value)
        }

        val aSummary: Summary? = calcSummary(node.left)
        val bSummary: Summary? = calcSummary(node.right)

        var sum = value
        if (aSummary != null) {
            sum = max(sum, value + aSummary.include)
        }
        if (bSummary != null) {
            sum = max(sum, value + bSummary.include)
        }


        var total = sum
        if (aSummary != null) {
            total = max(total, aSummary.total)
        }
        if (bSummary != null) {
            total = max(total, bSummary.total)
        }
        if (aSummary != null && bSummary != null) {
            total = max(total, value + aSummary.include + bSummary.include)
        }

        return Summary(sum, total)
    }
}