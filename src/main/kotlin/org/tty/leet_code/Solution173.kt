package org.tty.leet_code

import java.util.Stack

/// 使用栈存储左节点序
class BSTIterator(root: TreeNode?) {
    val cache = mutableListOf<TreeNode>()

    init {
        val dummy = TreeNode(0)
        dummy.right = root
        cache.add(dummy)
    }

    fun next(): Int {
        val node: TreeNode = cache.removeLast()
        // 移除一个节点，然后加入所有左节点，最后栈顶的值就是
        if (node.right != null) {
            var cur: TreeNode? = node.right
            while (cur != null) {
                cache.add(cur)
                cur = cur.left
            }
        }
        return cache.last().`val`
    }

    fun hasNext(): Boolean {
        return !(cache.size == 1 && cache.last().right == null)
    }
}