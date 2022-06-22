package org.tty.leet_code

import kotlin.math.max

// File Import: Common.kt

/**
 * 508:: Most Frequent Subtree Sum
 * Given the `root` of a binary tree, return the most frequent **subtree sum.** If there is a tie, return all the values with the highest frequency in any order.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 *
 * **Constraints:**
 * - The number of nodes in the tree is in the range [1, 10^4]
 * - -10^5 <= Node.val <=10^5
 *
 * **Solution:**
 * - use a hashmap to store the result of sum and frequency.
 * - use a variance to store the max frequency.
 *
 * **Result:**
 * - time: 236ms 25.00%
 * - memory: 37.9MB 37.50%
 * - at 2022/6/20
 */
class Solution508 {

    data class Visitation(
        val result: MutableMap<Int, Int>,
        var frequency: Int
    )

    private fun iter(root: TreeNode, visitation: Visitation): Int {
        val leftValue = if (root.left != null) {
            iter(root.left!!, visitation)
        } else {
            0
        }

        val rightValue = if (root.right != null) {
            iter(root.right!!, visitation)
        } else {
            0
        }

        val value = leftValue + rightValue + root.`val`
        val f = visitation.result.getOrDefault(value, 0) + 1
        visitation.result[value] = f
        visitation.frequency = max(visitation.frequency, f)
        return value
    }

    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf()
        }
        val visitation = Visitation(
            result = mutableMapOf(),
            frequency = 0
        )

        iter(root, visitation)

        val list = mutableListOf<Int>()
        visitation.result.forEach { (v, f) ->
            if (f == visitation.frequency) {
                list.add(v)
            }
        }

        return list.toIntArray()
    }
}