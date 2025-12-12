package org.tty.leet_code

class Solution106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
       return buildTree2(inorder.toList(), postorder.toList())
    }

    fun buildTree2(inorder: List<Int>, postorder: List<Int>): TreeNode? {
        if (inorder.isEmpty()) {
            return null
        } else if (inorder.size == 1) {
            return TreeNode(inorder.single())
        }

        val node = TreeNode(postorder.last())
        val index = inorder.indexOf(node.`val`)

        val leftA = inorder.slice(0 until index)
        val leftB = postorder.slice(0 until index)

        val leftNode = buildTree2(leftA, leftB)

        val rightA = inorder.slice(index + 1 until inorder.size)
        val rightB = postorder.slice(index until inorder.size - 1)
        val rightNode = buildTree2(rightA, rightB)

        node.left = leftNode
        node.right = rightNode
        return node
    }
}