package problems.leetcode.das.linkedlist

/**
 * This is a place where helper class are located for LinkedIn-related classes
 */
class ListNode(value: Int) {
    var value: Int = value
    var next: ListNode? = null
}

fun printLinkedList(head: ListNode?) {
    var current: ListNode? = head
    println("List Items:")
    while (current?.next != null) {
        println("-> val: ${current.value}")
        current = current.next
    }
}