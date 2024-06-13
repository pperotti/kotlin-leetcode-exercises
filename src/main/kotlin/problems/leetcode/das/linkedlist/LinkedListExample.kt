package problems.leetcode.das.linkedlist

import problems.Problem

class LinkedListExample : Problem {
    override fun execute() {
        val one = ListNode(1)
        val two = ListNode(2)
        val three = ListNode(3)
        one.next = two
        two.next = three
        val head = one

        println(head.value)
        println(head.next?.value ?: 0)
        println(head.next?.next?.value ?: 0)
    }
}
