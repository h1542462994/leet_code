package org.tty.leet_code

class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val left = invertTree(root.right)
        root.right = invertTree(root.left)
        root.left = left

        return root
    }

}