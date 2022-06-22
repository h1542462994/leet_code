package org.tty.leet_code

/**
 * 513: Find Bottom Left Tree Value
 *
 * Given the `root` of a binary tree, return the leftmost value in the last row of the tree.
 *
 * **Constraints:**
 * - The number of nodes in the tree is in the range `[1, 10^4]`
 * - `-2^31 <= Node.val <= 2^31 - 1` (int32)
 *
 * **Solution:**
 * - simple problem about tree dfs and bfs.
 *
 * **Result:**
 * - time: 200ms 75.00%
 * - memory: 36.2MB 87.50%
 * - at 2022/6/22
 */
class Solution513 {
    data class TreeNodeDepth(
        val node: TreeNode,
        val depth: Int
    )

    fun findBottomLeftValue(root: TreeNode?): Int {
        require(root != null) { "error input" }

        // record
        var currentDepth = 1
        var recordNode: TreeNode = root

        // use bfs to iter the nodes.
        val queue = ArrayDeque<TreeNodeDepth>()
        queue.addLast(TreeNodeDepth(root, 1))

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            val curDepth = cur.depth
            val curNode = cur.node

            // if depth added, then record it.
            if (curDepth > currentDepth) {
                currentDepth = curDepth
                recordNode = curNode
            }

            // add sub nodes
            if (curNode.left != null) {
                queue.addLast(TreeNodeDepth(curNode.left!!, curDepth + 1))
            }
            if (curNode.right != null) {
                queue.addLast(TreeNodeDepth(curNode.right!!, curDepth + 1))
            }

        }

        return recordNode.`val`
    }
}