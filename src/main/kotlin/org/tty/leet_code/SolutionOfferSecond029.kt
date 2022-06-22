package org.tty.leet_code

// File import: Common.kt



/**
 * external iterable function for test.
 */
fun Node?.iterable(): Iterable<Int> {
    return Iterable {
        iterator {
            if (this@iterable != null) {
                val head: Node = this@iterable
                var cur: Node = head
                while (cur.next != head) {
                    yield(cur.`val`)
                    cur = cur.next!!
                }
                yield(cur.`val`)
            }
        }
    }
}

/**
 * OfferSecond029:: insert into a sorted circular linked list.
 *
 * Given a node of **a not decreasing circle link list**, write a functions to insert the element `insertVal`, and maintain the monotonicity of the link list.
 *
 * the given node of the list could be any element in the list.
 *
 * if there are multi insert points, you could select any point to insert, just to maintain the monotonicity.
 *
 * if the list is empty (the node is `null`), you should create a node, otherwise return the raw node by input.
 *
 * **Constraints:**
 * - 0 <= Numbers of Nodes <= 5 * 10^4
 * - -10^6 <= Node.val <= 10^6
 * - -10^6 <= insertVal <= 10^6
 *
 * **Solution:**
 * - just solve it by tips. notice the element could be inserted at end-start point.
 *
 * **Result:**
 * - time: 232ms 16.67%
 * - memory: 34.6MB 96.67%
 * - at 2022/6/20
 */
class SolutionOfferSecond029 {
    private fun doInsert(cur: Node, insertVal: Int) {
        val node = Node(insertVal)
        node.next = cur.next
        cur.next = node
    }

    fun insert(head: Node?, insertVal: Int): Node? {
        // if head is empty, create a circle list
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        } else {
            var cur: Node = head
            while (cur.next != head) {
                if (insertVal >= cur.`val` && insertVal <= cur.next!!.`val`) { // normal point
                    break
                } else if (cur.next!!.`val` < cur.`val`) { // end-start point
                    if (insertVal >= cur.`val` || insertVal <= cur.next!!.`val`) {
                        break
                    }
                }
                cur = cur.next!!
            }
            // else, insert to the tail.
            doInsert(cur, insertVal)
            return head
        }
    }
}
