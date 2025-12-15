package org.tty.leet_code

class Solution98 {
    class Receiver(
        var last: Int? = null,
        var result: Boolean = true
    ) {
        fun update(value: Int) {
            if (last != null) {
               if (last!! >= value) {
                   result = false
               }
            }

            last = value
        }
    }

    fun isValidBST(root: TreeNode?): Boolean {
        val receiver = Receiver()
        visit(root!!, receiver)
        return receiver.result
    }

    fun visit(node: TreeNode, receiver: Receiver) {
        if (!receiver.result) {
            return
        }

        if (node.left != null) {
           visit(node.left!!, receiver)
        }

        receiver.update(node.`val`)

        if (node.right != null) {
            visit(node.right!!, receiver)
        }

    }
}