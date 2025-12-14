package org.tty.leet_code

class Solution129 {
    data class Sum(var value: Int)

    fun sumNumbers(root: TreeNode?): Int {
        val sum = Sum(0)
        iter(root, 0, sum)
        return sum.value
    }

    private fun iter(node: TreeNode?, value: Int, sum: Sum) {
        if (node == null) {
            return
        }

        val cur = value * 10 + node.`val`

        if (node.left == null && node.right == null) {
            sum.value += cur
        } else {
            iter(node.left, cur, sum)
            iter(node.right, cur, sum)
        }

    }

}