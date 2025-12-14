package org.tty.leet_code

class Solution114 {
    data class WithTail(
        var cur: TreeNode,
        var tail: TreeNode
    )

    fun flatten(root: TreeNode?): Unit {
        if (root != null) {
            insert(root)
        }
    }

    fun insert(node: TreeNode): WithTail {
        if (node.left == null && node.right == null) {
            return WithTail(node, node)
        } else if (node.left != null && node.right == null) {
            val tail = insert(node.left!!)
            node.right = node.left
            node.left = null
            return WithTail(node, tail.tail)
        } else {
            val tail: TreeNode = insert(node.right!!).tail

            if (node.left != null) {
                val tailLeft = insert(node.left!!)
                tailLeft.tail.right = node.right
                node.right = node.left
                node.left = null
            }
            return WithTail(node, tail)
        }
    }
}