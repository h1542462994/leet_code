package org.tty.leet_code

class Solution236 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        if (root == p || root == q) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        return if (left != null && right != null) {
            root
        } else if (left != null) {
            left
        } else {
            right
        }

    }
}