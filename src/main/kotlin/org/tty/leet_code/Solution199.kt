package org.tty.leet_code

class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        val result = mutableListOf<Int>()
        val list = mutableListOf(root)
        while (true) {
            val length = list.size
            if (length == 0) {
                break
            }

            result.add(list.last().`val`)
            for (i in 0 until length) {
                val cur = list.removeFirst()
                if (cur.left != null) {
                    list.add(cur.left!!)
                }
                if (cur.right != null) {
                    list.add(cur.right!!)
                }
            }
        }
        return result
    }
}