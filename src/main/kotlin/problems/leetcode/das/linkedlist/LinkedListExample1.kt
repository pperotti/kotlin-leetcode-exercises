package problems.leetcode.das.linkedlist

import problems.Problem

class LinkedListExample1 : Problem {
    override fun execute() {
        var head : ListNode? = null
        var prev : ListNode? = null
        val list = intArrayOf(1,2,3,4,5)
        list.forEach {
            val item = ListNode(it)
            if (head == null) {
                head = item
            }
            if (prev != null) {
                prev?.next = item
            }
            prev = item
        }

        // Print List
        printLinkedList(head)
    }

    private fun getMiddle(head: ListNode): Int {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow?.value ?: -1
    }
}
