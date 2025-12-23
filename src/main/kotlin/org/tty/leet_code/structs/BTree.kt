package org.tty.leet_code.structs

private class BTreeNode<T>(
    var isLeaf: Boolean = true,
    val nodes: MutableList<T> = mutableListOf(),
    val children: MutableList<BTreeNode<T>> = mutableListOf()
) {
    val elementCount get() = nodes.size
}

private data class BTreeFindResult<T>(
    val node: BTreeNode<T>,
    val findIndex: Int,
    val isFind: Boolean,
)

private data class BTreeSplitResult<T>(
    val promotedKey: T,
    val rightNode: BTreeNode<T>
)

class BTree<T : Comparable<T>>(
    val order: Int = 5,
    var comparator: Comparator<T>
) {
    private var root = BTreeNode<T>()

    init {
        require(order >= 3) { "BTree order must be >= 3" }
    }

    constructor(order: Int = 5) : this(order, comparator = Comparator.naturalOrder<T>())

    /**
     * insert value to btree.
     * @return value insert success.
     */
    fun insert(value: T): Boolean {
        val inserted = insertNode(root, value)
        if (!inserted) return false

        if (root.nodes.size >= order) {
            val split = splitNode(root)
            val newRoot = BTreeNode<T>(isLeaf = false)
            newRoot.nodes.add(split.promotedKey)
            newRoot.children.add(root)
            newRoot.children.add(split.rightNode)
            root = newRoot
        }
        return true
    }

    /**
     * insert the value into node
     * @return true means insert value exists.
     */
    private fun insertNode(node: BTreeNode<T>, value: T): Boolean {
        val (index, found) = findKeyIndex(node.nodes, value)
        if (found) return false

        if (node.isLeaf) {
            node.nodes.add(index, value)
            return true
        }

        // recursive.
        val child = node.children[index]
        val inserted = insertNode(child, value)
        if (!inserted) return false

        // after insertion, check child overflow.
        if (child.nodes.size >= order) {
            val split = splitNode(child)
            node.nodes.add(index, split.promotedKey)
            node.children.add(index + 1, split.rightNode)
        }
        return true
    }


    private fun findValue(value: T): BTreeFindResult<T> {
        var current = root
        while (true) {
            val (index, found) = findKeyIndex(current.nodes, value)

            if (found) {
                return BTreeFindResult(node = current, findIndex = index, isFind = true)
            }

            if (current.isLeaf) {
                return BTreeFindResult(node = current, findIndex = index, isFind = false)
            }
            current = current.children[index]
        }
    }

    private fun findKeyIndex(keys: List<T>, value: T): Pair<Int, Boolean> {
        var left = 0
        var right = keys.size

        while (left < right) {
            val mid = (left + right) ushr 1
            val cmp = comparator.compare(value, keys[mid])

            when {
                cmp == 0 -> return mid to true
                cmp < 0 -> right = mid
                else -> left = mid + 1
            }
        }

        return left to false
    }

    private fun splitNode(node: BTreeNode<T>): BTreeSplitResult<T> {
        val mid = node.nodes.size / 2
        val promotedKey = node.nodes[mid]

        val rightNode = BTreeNode<T>(
            isLeaf = node.isLeaf
        )

        // move keys.
        rightNode.nodes.addAll(node.nodes.subList(mid + 1, node.nodes.size))
        node.nodes.subList(mid, node.nodes.size).clear()

        // move children
        if (!node.isLeaf) {
            rightNode.children.addAll(node.children.subList(mid + 1, node.children.size))
            node.children.subList(mid + 1, node.children.size).clear()
        }
        return BTreeSplitResult(promotedKey, rightNode)
    }

    fun remove(value: T): Boolean {
        if (!preRemove(value)) {
            return false
        }

        removeNode(root, value)

        if (!root.isLeaf && root.nodes.isEmpty()) {
            root = root.children.first()
        }
        return true
    }


    private fun removeNode(node: BTreeNode<T>, value: T) {
        val (index, found) = findKeyIndex(node.nodes, value)

        // Case 1: leaf node → remove directly
        if (node.isLeaf) {
            if (found) {
                node.nodes.removeAt(index)
                return
            }
            error("Invariant broken: value not found in leaf")
        }

        // Case 2: internal node → recurse into child
        val childIndex = index
        val child = node.children[childIndex]

        removeNode(child, value)

        // After recursion, repair child if underflow
        if (child.nodes.size < minKeys) {
            repairChild(node, childIndex)
        }
    }

    private fun repairChild(parent: BTreeNode<T>, idx: Int) {

        // Try borrow from left sibling
        if (idx > 0 && parent.children[idx - 1].nodes.size > minKeys) {
            borrowFromLeft(parent, idx)
            return
        }

        // Try borrow from right sibling
        if (idx < parent.children.lastIndex &&
            parent.children[idx + 1].nodes.size > minKeys
        ) {
            borrowFromRight(parent, idx)
            return
        }

        // Otherwise, must merge
        if (idx < parent.children.lastIndex) {
            mergeChildren(parent, idx)
        } else {
            mergeChildren(parent, idx - 1)
        }
    }

    private fun borrowFromLeft(parent: BTreeNode<T>, idx: Int) {
        val child = parent.children[idx]
        val left = parent.children[idx - 1]

        child.nodes.add(0, parent.nodes[idx - 1])
        parent.nodes[idx - 1] = left.nodes.removeLast()

        if (!left.isLeaf) {
            child.children.add(0, left.children.removeLast())
        }
    }

    private fun mergeChildren(parent: BTreeNode<T>, idx: Int) {
        val left = parent.children[idx]
        val right = parent.children[idx + 1]

        left.nodes.add(parent.nodes.removeAt(idx))
        left.nodes.addAll(right.nodes)

        if (!left.isLeaf) {
            left.children.addAll(right.children)
        }

        parent.children.removeAt(idx + 1)
    }

    private fun borrowFromRight(parent: BTreeNode<T>, idx: Int) {
        val child = parent.children[idx]
        val right = parent.children[idx + 1]

        child.nodes.add(parent.nodes[idx])
        parent.nodes[idx] = right.nodes.removeAt(0)

        if (!right.isLeaf) {
            child.children.add(right.children.removeAt(0))
        }
    }

    /**
     * pre move.
     * @return whether value exists in tree.
     */
    private fun preRemove(value: T): Boolean {
        var node = root
        while (true) {
            val (index, find) = findKeyIndex(node.nodes, value)
            if (find) {
                // Case 1: leaf → delete directly
                if (node.isLeaf) {
                    return true
                }

                // Case 2: internal → swap with predecessor or successor
                val leftChild = node.children[index]
                val rightChild = node.children[index + 1]
                if (leftChild.nodes.size >= rightChild.nodes.size) {
                    node.nodes[index] = updatePredecessor(leftChild, value)
                } else {
                    node.nodes[index] = updateSuccessor(rightChild, value)
                }
                return true
            }

            if (node.isLeaf) return false
            node = node.children[index]
        }
    }

    private fun updatePredecessor(node: BTreeNode<T>, value: T): T {
        var cur = node
        while (!cur.isLeaf) {
            cur = cur.children.last()
        }
        val replaced = cur.nodes.last()
        cur.nodes[cur.nodes.size - 1] = value
        return replaced
    }

    private fun updateSuccessor(node: BTreeNode<T>, value: T): T {
        var cur = node
        while (!cur.isLeaf) {
            cur = cur.children.first()
        }
        val replaced = cur.nodes.first()
        cur.nodes[0] = value
        return replaced
    }

    private val minKeys = (order + 1) / 2 - 1

    companion object {

    }

}