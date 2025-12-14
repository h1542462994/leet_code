package org.tty.leet_code

import java.util.Stack

class Solution105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val indexMap = mutableMapOf<Int, Int>()
        for (i in inorder.indices) {
            indexMap[inorder[i]] = i
        }

        fun isLeft(a: Int, b: Int): Boolean {
            return indexMap[a]!! < indexMap[b]!!
        }

        val stack = Stack<TreeNode>()

        var head: TreeNode? = null

        var index = 0
        for (num in preorder) {
            val cur = TreeNode(num)
            if (head == null) {
                head = cur
            }

            if (stack.isEmpty()) {
                stack.add(cur)
                continue
            }

            var top = stack.peek()
            if (isLeft(num, top.`val`)) {
                top.left = cur
                stack.add(cur)
            } else {
                // 用于找到用于插入的节点
                var his = top
                while (inorder[index] == top.`val`) {
                    // 指向最近被移除的元素
                    his = stack.pop()
                    // 移除，指向下一个节点，或空节点
                    if (stack.isNotEmpty())  {
                        top = stack.peek()
                    }
                    index++
                }
                his.right = cur
                stack.add(cur)
            }
        }
        return head
    }
}