package org.tty.leet_code

import kotlin.math.max

/**
 * 513:: Find Largest Values in Each Tree Row.
 *
 * Given the `root` of a binary tree, return `an array of the largest value in each row` of the tree **(0 - indexed)**
 *
 * **Constraint:**
 * - The number of nodes in the tree will be in the range `[0, 10^4]`.
 * - `-2^31 <= Node.val <= 2^31 - 1`
 *
 * **Solution:**
 * 1. use bfs to iter the tree, and record the maxvalue.
 *
 * **Result:**
 * - time: 216ms 58.33%
 * - memory: 36.9MB 8.33%
 * - at 2022/6/24
 */
class Solution515 {
    data class TreeNodeDepth(
        val node: TreeNode,
        val depth: Int
    )

    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }

        // record
        val results = mutableListOf<Int>()

        // use bfs to iter the nodes.
        val queue = ArrayDeque<TreeNodeDepth>()
        queue.addLast(TreeNodeDepth(root, 1))

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            val curDepth = cur.depth
            val curNode = cur.node

            // if depth added, then create a result
            if (curDepth > results.size) {
                results.add(cur.node.`val`)
            } else {
                results[curDepth - 1] = max(results[curDepth - 1], cur.node.`val`)
            }

            // add sub nodes
            if (curNode.left != null) {
                queue.addLast(TreeNodeDepth(curNode.left!!, curDepth + 1))
            }
            if (curNode.right != null) {
                queue.addLast(TreeNodeDepth(curNode.right!!, curDepth + 1))
            }

        }
        return results
    }
}

