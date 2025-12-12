package org.tty.leet_code

class Solution112 {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        return iter(root, 0, targetSum)
    }

    fun iter(node: TreeNode, sum: Int, target: Int): Boolean {
        val current = sum + node.`val`
        return if (node.left == null && node.right == null) {
            current == target
        } else {
            (if (node.left == null) false else iter(node.left!!, current, target))
                    || (if (node.right == null) false else iter(node.right!!, current, target))
        }
    }
}