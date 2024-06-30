package problems.leetcode.das.linkedlist

import problems.Problem

class ReversingListExample1 : Problem {
    override fun execute() {

        // List with a cycle
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        // Print List
        val head = node1
        printLinkedList(head)
        val tail = reverseList(head)
        printLinkedList(tail)
    }

    private fun reverseList(head: ListNode): ListNode? {
        var tail: ListNode? = head
        var prev: ListNode? = null

        while (tail != null) {
            val oldNext = tail.next
            tail.next = prev
            prev = tail
            tail = oldNext
        }

        return prev // This is the last known item
    }
}