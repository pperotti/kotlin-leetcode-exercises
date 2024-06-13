package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Example 3: Given the head of a linked list and an integer k, return the
 * k-th node from the end.
 *
 * For example, given the linked list that represents 1 -> 2 -> 3 -> 4 -> 5 and
 * k = 2, return the node with value 4, as it is the 2nd node from the end.
 */
class LinkedListExample3 : Problem {
    override fun execute() {
        val nodeList = NodeList()
        val k = 2

        // List with a cycle
        val node1 = ListNode2(1)
        val node2 = ListNode2(2)
        val node3 = ListNode2(3)
        val node4 = ListNode2(4)
        val node5 = ListNode2(5)

        nodeList.add(node1)
        nodeList.add(node2)
        nodeList.add(node3)
        nodeList.add(node4)
        nodeList.add(node5)

        // Print List
        //printLinkedList2(nodeList.head)
        printLinkedList2Backwards(nodeList.tail)
        println("Item $k -> Elem: ${nodeList.getFromTail(k)?.value}")
    }

}
