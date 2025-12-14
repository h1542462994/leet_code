package org.tty.leet_code

import kotlin.math.max

class Solution104 {
    fun maxDepth(root: TreeNode?): Int {
        return computeDepth(root, 0)
    }

    fun computeDepth(node: TreeNode?, depth: Int): Int {
        return if (node == null) {
            depth
        } else if (node.left == null && node.right == null) {
            depth + 1
        } else {
            max(computeDepth(node.left, depth + 1), computeDepth(node.right, depth + 1))
        }

    }
}