package problems.leetcode.das.linkedlist

import problems.Problem

class LinkedListMiddleElement : Problem {
    override fun execute() {
        var head : ListNode3? = null
        var prev : ListNode3? = null
        //val list = intArrayOf(1,2,3,4,5)
        val list = intArrayOf(1,2,3,4,5,6)
        list.forEach {
            val item = ListNode3(it)
            if (head == null) {
                head = item
            }
            prev?.next = item
            prev = item
        }
        //printLinkedList(head)
        println("Middle Node: ${middleNodeOptimized(head)?.`val`}")
    }

    private fun middleNodeOptimized(head: ListNode3?): ListNode3? {
        var slow: ListNode3? = head
        var fast: ListNode3? = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    private fun middleNode(head: ListNode3?): ListNode3? {
        var elemsToSkip = 0

        var slow: ListNode3? = head
        var fast: ListNode3? = head

        while (fast?.next != null) {
            // Get the size of the list
            elemsToSkip++

            // Update pointers
            slow = slow?.next
            fast = fast.next?.next
        }

        // Reset pointers
        slow = head

        // Skip the first 'elemsToSkip'
        (0 until elemsToSkip).forEach { _ ->
            slow = slow?.next
        }

        return slow
    }
}