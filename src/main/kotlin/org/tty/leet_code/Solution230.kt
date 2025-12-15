package org.tty.leet_code

class Solution230 {
    class Receiver(
        val k: Int,
        var count: Int = 0,
        var result: Int = 0
    )

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val receiver = Receiver(k)
        visit(root!!, receiver)
        return receiver.result
    }

    fun visit(root: TreeNode, receiver: Receiver) {
        if (root.left != null) {
            visit(root.left!!, receiver)
        }

        receiver.count++
        if (receiver.count == receiver.k) {
            receiver.result = root.`val`
            // 剪枝
            return
        }

        if (root.right != null) {
            visit(root.right!!, receiver)
        }

    }
}