package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Example: 24. Swap Nodes in Pairs (https://leetcode.com/problems/swap-nodes-in-pairs/submissions/1308674425/)
 *
 * Given the head of a linked list, swap every pair of nodes.
 *
 * For example, given a linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6,
 *
 * return a linked list 2 -> 1 -> 4 -> 3 -> 6 -> 5.
 */
class LinkedListSwapNodesInPairs : Problem {
    override fun execute() {
        scenario4()
    }

    private fun scenario1() {
        // List with a cycle
        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)
        val node4 = ListNode3(4)
        val node5 = ListNode3(5)
        val node6 = ListNode3(6)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6

        // Print List
        val head = node1
        printLinkedList3(head)
        //swapNodesInPairs(head)
        val newHead = swapPairs(head)
        printLinkedList3(newHead)
    }

    private fun scenario2() {
        // List with a cycle
        val node1 = ListNode3(1)
        node1.next = null

        // Print List
        val head = node1
        printLinkedList3(head)
        //swapNodesInPairs(head)
        val newHead = swapPairs(head)
        printLinkedList3(newHead)
    }

    private fun scenario3() {
        // List with a cycle
        val node1 = ListNode3(1)
        val node2 = ListNode3(2)

        node1.next = node2
        node2.next = null

        // Print List
        val head = node1
        printLinkedList3(head)
        //swapNodesInPairs(head)

        val newHead = swapPairs(head)
        println("New Head: ${newHead?.`val`}")
        printLinkedList3(newHead)
    }

    private fun scenario4() {
        // List with a cycle
        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)
        val node4 = ListNode3(4)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = null

        // Print List
        val head = node1
        printLinkedList3(head)
        //swapNodesInPairs(head)
        val newHead = swapPairs(head)
        printLinkedList3(newHead)
    }

//    fun swapNodesInPairs(head: ListNode?) : ListNode? {
//        var current : ListNode? = head
//        var prev : ListNode? = null
//
//        while (current != null) {
//            if (prev != null) { // We swap the values, not the pointers
//                val prevValue = prev.value
//                prev.value = current.value
//                current.value = prevValue
//                prev = null
//            } else {
//                prev = current
//            }
//            current = current.next
//        }
//        return head
//    }

    fun swapPairs(head: ListNode3?): ListNode3? {
        var current : ListNode3? = head
        var newHead : ListNode3? = null
        var lastSecondElement : ListNode3? = null

        // Traverse all the items per pairs
        while (current != null) {

            // Identify elements
            val firstElement = current
            val secondElement = current?.next
            val upcomingElement = secondElement?.next

            println("1st: ${firstElement.`val`} 2nd: ${secondElement?.`val`} 3rd: ${upcomingElement?.`val`} lastSecond: ${lastSecondElement?.`val`}")

            // Update pointers
            firstElement?.next = upcomingElement
            secondElement?.next = firstElement
            // Make sure you pay attention to ´?.´ operator
            lastSecondElement?.next = if (secondElement == null) {
                firstElement
            } else {
                secondElement
            }

            // Fix the next element for the last pointer from the previous iteration
            println("-> ${firstElement?.`val`}->.next: ${firstElement?.next?.`val`}"
                    + " ${secondElement?.`val`}->.next: ${secondElement?.next?.`val`}"
                    + " prev: ${lastSecondElement?.`val`}"
                    + " upcoming: ${upcomingElement?.`val`}")

            // Set the new head if this wasn't set before
            if (newHead == null) {
                newHead = if (secondElement == null) {
                    firstElement
                } else {
                    secondElement
                }
            }

            // Current IS updated to cur?.next?.next
            current = upcomingElement

            // Update the reference to the last
            lastSecondElement = firstElement

            println("-> lastSecondElement: ${lastSecondElement?.`val`}")
        }

        return newHead
    }
}