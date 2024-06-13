package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Example 1: Given the head of a linked list with
 * an odd number of nodes head, return the value
 * of the node in the middle.
 *
 * For example, given a linked list that represents
 * 1 -> 2 -> 3 -> 4 -> 5, return 3.
 */
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
            prev?.next = item
            prev = item
        }

        // Print List
        printLinkedList(head)
        println("Middle: ${getMiddle(head!!)}")
    }

    private fun getMiddle(head: ListNode): Int {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow?.value ?: -1
    }
}
