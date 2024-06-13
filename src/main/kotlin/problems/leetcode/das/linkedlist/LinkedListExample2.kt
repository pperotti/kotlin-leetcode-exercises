package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Example 2: 141. Linked List Cycle
 *
 * Given the head of a linked list, determine if
 * the linked list has a cycle.
 *
 * There is a cycle in a linked list if there is
 * some node in the list that can be reached
 * again by continuously following the next pointer.
 */
class LinkedListExample2 : Problem {
    override fun execute() {
        var head : ListNode? = null

        // List with a cycle
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
//        val node5 = ListNode(5)
//        val node6 = ListNode(6)
//        val node7 = ListNode(7)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node1

        // Set Head
        head = node1

        // Print List
        //printLinkedList(head)
        println("Has a cycle? -> ${hasCycle(head!!)}")
    }

    private fun hasCycle(head: ListNode) : Boolean {
        var slow: ListNode? = head
        var fast: ListNode? = head

        //while (fast?.next != null) { // There is no real different
        do {
            // Do something
            println("Slow Value: ${slow?.value} Fast Value: ${fast?.value}")

            // Update pointers
            slow = slow?.next
            fast = fast?.next?.next

            println("---> New Slow: ${slow?.value} New Fast: ${fast?.value}")
            if (fast == slow) {
                return true
            }
        } while (fast != null) // If this condition is met, then there is no cycle

        return false
    }

}
