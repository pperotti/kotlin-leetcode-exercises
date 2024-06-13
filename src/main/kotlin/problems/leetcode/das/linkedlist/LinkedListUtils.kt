package problems.leetcode.das.linkedlist

/**
 * This is a place where helper class are located for LinkedIn-related classes
 */
class ListNode(inValue: Int) {
    val value = inValue
    var next: ListNode? = null
}

fun printLinkedList(head: ListNode?) {
    var current: ListNode? = head
    println("List Items:")
    while (current != null) {
        println("-> val: ${current.value}")
        current = current.next
    }
}