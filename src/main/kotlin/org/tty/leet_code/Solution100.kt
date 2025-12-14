package org.tty.leet_code

class Solution100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        } else if (p == null || q == null) {
            return false
        } else {
            // or not null.
            if (p.`val` != q.`val`) {
                return false
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }


}