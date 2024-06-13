package problems.leetcode.das.linkedlist

import problems.Problem

/**
 * Given the head of a sorted linked list, delete all
 * duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
class LinkedListRemoveDuplicates : Problem {
    override fun execute() {
        var head : ListNode3? = null
        var prev : ListNode3? = null
        //val list = intArrayOf(1,1,2,3,3)
        val list = intArrayOf(1,1,1)
        list.forEach {
            val item = ListNode3(it)
            if (head == null) {
                head = item
            }
            prev?.next = item
            prev = item
        }
        val v = deleteDuplicates(head)
        printLinkedList3(v)
    }

    private fun deleteDuplicates(head: ListNode3?): ListNode3? {
        var curr: ListNode3? = head
        var last: ListNode3? = null

        while (curr != null) {

            println("-> head: $head head.next: ${head?.next}")
            println("----> curr: $curr curr.next: ${curr?.next}")
            println("----> last: $last last.next: ${last?.next}")

            // Skip repeated elements
            if (curr.`val` == last?.`val`) {
                last.next = curr.next
                println("bypassed!")
            }

            // Update pointers
            last = curr
            curr = curr.next
        }

        return head
    }

}