package org.tty.leet_code

class Solution108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return build(nums, 0, nums.size)
    }

    fun build(nums: IntArray, a: Int, b: Int): TreeNode? {
        if (a == b) {
            return null
        } else if (a + 1 == b) {
            return TreeNode(nums[a])
        }

        val mid = (a + b) / 2
        val node = TreeNode(nums[mid])

        node.left = build(nums, a, mid)
        node.right = build(nums, mid + 1, b)
        return node
    }
}