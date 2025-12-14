package org.tty.leet_code

class Solution101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric2(root, root)
    }

    fun isSymmetric2(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        } else if (left == null || right == null) {
            return false
        } else {
            if (left.`val` != right.`val`) {
                return false
            }

            return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left)
        }
    }
}