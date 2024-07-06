package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *   var next: ListNode? = null
 * }
 */
class ReverseLinkedListII : Problem {
    override fun execute() {
        //scenario1()
        //scenario2()
        //scenario3()
        //scenario4()
        scenario5()
    }

    private fun scenario1() {

        var head : ListNode3? = null

        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)
        val node4 = ListNode3(4)
        val node5 = ListNode3(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        head = node1

        println("Scenario 1: [1,2,3,4,5] left: 2 right: 4")
        printLinkedList3(head)
        val newHead = reverseBetween(head, 2, 4)
        printLinkedList3(newHead)
    }

    private fun scenario2() {

        var head : ListNode3? = null

        val node1 = ListNode3(3)
        val node2 = ListNode3(5)

        node1.next = node2
        node2.next = null

        head = node1

        println("Scenario 2: [3,5] left: 1 right: 2")
        printLinkedList3(head)
        val newHead = reverseBetween(head, 1, 2)
        printLinkedList3(newHead)
    }

    private fun scenario3() {

        var head : ListNode3? = null

        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)

        node1.next = node2
        node2.next = node3
        node3.next = null

        head = node1
        println("Scenario 3: [1,2,3] left: 1 right: 2")
        printLinkedList3(head)
        val newHead = reverseBetween(head, 1, 2)
        printLinkedList3(newHead)
    }

    private fun scenario4() {

        var head : ListNode3? = null

        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)
        val node4 = ListNode3(4)
        val node5 = ListNode3(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        head = node1

        println("Scenario 4: [1,2,3,4,5] left: 1 right: 4")
        printLinkedList3(head)
        val newHead = reverseBetween(head, 1, 4)
        printLinkedList3(newHead)
    }

    private fun scenario5() {
        /**
         * [1,2,3]
         * 1
         * 3
         */
        var head : ListNode3? = null

        val node1 = ListNode3(1)
        val node2 = ListNode3(2)
        val node3 = ListNode3(3)

        node1.next = node2
        node2.next = node3
        node3.next = null

        head = node1

        println("Scenario 5: [1,2,3] left: 1 right: 3")
        printLinkedList3(head)
        val newHead = reverseBetween(head, 1, 3)
        printLinkedList3(newHead)
    }

    private fun reverseBetween(head: ListNode3?, left: Int, right: Int): ListNode3? {
        var current : ListNode3? = head
        var leftNode : ListNode3? = null
        var leftPrevNode : ListNode3? = head
        var rightNode : ListNode3? = null
        var rightNextNode : ListNode3? = null
        var count = 1

        // Identify left, right nodes
        while (current != null) {

            //println("pos: $count current: ${current.`val`} left: $left right: $right")

            // Identify left node and its previous element
            if (leftNode == null) { // We process this only if once
                // If current element is equals 'left', we are on the left edge
                if (left == 1) {
                    leftNode = current
                    leftPrevNode = head
                } else if (left == count + 1) {
                    leftNode = current.next
                    leftPrevNode = current
                }
            }

            // Identify right element
            if (rightNode == null && right == count) {
                rightNode = current
                rightNextNode = current.next
            }

            // Next element
            current = current.next

            if (leftNode != null && rightNode != null) {
                // We break the while node once we identified key nodes
                println("-> leftNode: ${leftNode.`val`} "
                        + " leftPrevNode: ${leftPrevNode?.`val`} "
                        + " rightNode: ${rightNode.`val`}"
                        + " rightNodeNext: ${rightNextNode?.`val`}"
                )
                break
            }

            count++
        }

        // Check we have the right data to continue
        if (leftNode == null || rightNode == null) {
            return head
        }

        // Reverse the sublist (fix pointers in between left and right)
        println("------------ REVERSING ELEMENTS ....")
        current = leftNode
        var roundNextNode : ListNode3? = rightNextNode

        count = 1
        while (current != null) {
            println("-> #: $count - current: ${current?.`val`} current.next: ${current?.next?.`val`} - roundNextNode: ${roundNextNode?.`val`}")
            // Get Next
            val nextNode = if (current==rightNode) {
                null
            } else {
                current.next
            }
            val nextNodeNext = if (current==rightNode) {
                null
            } else {
                current.next?.next
            }

            println("-----> current: ${current.`val`} - nextNode: ${nextNode?.`val`} - nextNodeNext: ${nextNodeNext?.`val`}")

            // Invert pointers
            current.next = roundNextNode
            nextNode?.next = current

            println("-----> c: ${current.`val`} c.next: ${current.next?.`val`} "
                    + " - n: ${nextNode?.`val`} n.next: ${nextNode?.next?.`val`}"
                    + " - nn: ${nextNodeNext?.`val`}"
            )

            // Update pointers. We move 2 by 2
            current = if (current == rightNode || nextNode == rightNode) {
                null // No more iterations
            } else {
                nextNodeNext
            }
            roundNextNode = nextNode

            count++
            println("-----> roundNextNode: ${roundNextNode?.`val`} new current: ${nextNodeNext?.`val`}")
        }

        // Fix pointers in the extremes
        leftPrevNode?.next = rightNode
        leftNode?.next = rightNextNode

        return if (left == 1) {
            rightNode
        } else {
            head
        }
    }
}