package org.tty.leet_code

import kotlin.math.abs
import kotlin.math.min

class Solution530 {

    class Last(
        var value: Int? = null,
        var minDiff: Int? = null
    ) {
        fun update(value: Int) {
            if (this.value != null) {
                val diff = abs(value - this.value!!)
                minDiff = if (minDiff == null) {
                    diff
                } else {
                    min(minDiff!!, diff)
                }
            }
            this.value = value
        }
    }

    fun getMinimumDifference(root: TreeNode?): Int {
        val last = Last()
        visit(root!!, last)
        return last.minDiff!!
    }

    fun visit(root: TreeNode, last: Last) {
        if (root.left != null) {
            visit(root.left!!, last)
        }
        last.update(root.`val`)
        if (root.right != null) {
            visit(root.right!!, last)
        }
    }
}