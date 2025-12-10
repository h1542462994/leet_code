package org.tty.leet_code

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(var `val`: Int) {
    var next: Node? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * external iterable function for test.
 */
fun Node?.listIterable(): Iterable<Int> {
    return Iterable {
        iterator {
            if (this@listIterable != null) {
                val head: Node? = this@listIterable
                var cur: Node? = head
                while (cur != null && cur.next != head) {
                    yield(cur.`val`)
                    cur = cur.next
                }
                if (cur != null) {
                    yield(cur.`val`)
                }
            }
        }
    }
}

/**
 * external iterable function for test.
 */
fun ListNode?.listIterable(): Iterable<Int> {
    return Iterable {
        iterator {
            if (this@listIterable != null) {
                val head: ListNode = this@listIterable
                var cur: ListNode? = head
                while (cur != null && cur.next != head) {
                    yield(cur.`val`)
                    cur = cur.next
                }
                if (cur != null) {
                    yield(cur.`val`)
                }
            }
        }
    }
}