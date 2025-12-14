package org.tty.leet_code

class Solution427 {
    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun construct(grid: Array<IntArray>): Node? {
        val n = grid.size

        return build(grid, 0, n, 0, n)
    }

    fun build(grid: Array<IntArray>, r1: Int, r2: Int, c1: Int, c2: Int): Node {
        if (r1 + 1 == r2 && c1 + 1 == c2) { // only 1 cell.
            return Node(grid[r1][c1] == 1, true)
        }

        // split to 4 parts.
        val rMid = (r1 + r2) / 2
        val cMid = (c1 + c2) / 2

        val topLeft = build(grid, r1, rMid, c1, cMid)
        val topRight = build(grid, r1, rMid, cMid, c2)
        val bottomLeft = build(grid, rMid, r2, c1, cMid)
        val bottomRight = build(grid, rMid, r2, cMid, c2)

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.`val` == topRight.`val` && topLeft.`val` == bottomLeft.`val` && topLeft.`val` == bottomRight.`val`) {
                // build a large leaf node.
                return Node(topLeft.`val`, true)
            }
        }

        val node = Node(`val` = false, isLeaf = false)
        node.topLeft = topLeft
        node.topRight = topRight
        node.bottomLeft = bottomLeft
        node.bottomRight = bottomRight

        return node
    }

}