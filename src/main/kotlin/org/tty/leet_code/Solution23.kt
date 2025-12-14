package org.tty.leet_code

/**
 * 分治+归并。
 * 如果不想要递归的话，可以使用双向队列，取两个队列，排序后在放入队列，直到队列个数<=1
 */
class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return merge(lists, 0, lists.size)
    }

    fun merge(lists: Array<ListNode?>, a: Int, b: Int): ListNode? {
        if (a == b) {
            return null
        } else if (a + 1 == b) {
            return lists[a]
        }

        val list1: ListNode?
        val list2: ListNode?

        if (a + 2 == b) {
            list1 = lists[a]
            list2 = lists[a + 1]
        } else {

            val mid = (a + b) / 2

            list1 = merge(lists, a, mid)
            list2 = merge(lists, mid, b)
        }

        // 合并两条列表
        val dummyNode = ListNode(0)
        var cur = dummyNode

        var p = list1
        var q = list2
        while (p != null || q != null) {
            if (p != null && (q == null || (p.`val` <= q.`val`))) {
                cur.next = p
                cur = p
                p = p.next
            } else if (q != null) {
                cur.next = q
                cur = q
                q = q.next
            }
        }
        return dummyNode.next
    }
}