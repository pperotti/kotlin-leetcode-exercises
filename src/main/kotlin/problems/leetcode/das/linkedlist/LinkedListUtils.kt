package problems.leetcode.das.linkedlist

/**
 * This is a place where helper class are located for LinkedIn-related classes
 */
class ListNode(inValue: Int) {
    val value = inValue
    var next: ListNode? = null
}

// This version of ListNode can be extended
class ListNode2(inValue: Int) {
    val value = inValue
    var next: ListNode2? = null
    var prev: ListNode2? = null
}

class ListNode3(var `val`: Int) {
    var next: ListNode3? = null
}

/**
 * List class with certain methods
 */
class NodeList {
    var head: ListNode2? = null
    var tail: ListNode2? = null

    fun add(node: ListNode2) {
        if (head == null) {
            head = node
            tail = node
        } else if (tail != null) {
            tail?.next = node
            node.prev = tail
            tail = node
        }
    }

    fun getFromHead(index: Int): ListNode2? {
        var selectedNode: ListNode2? = null
        (0 until index).forEach {
            selectedNode = selectedNode?.next
        }
        return selectedNode
    }

    fun getFromTail(index: Int): ListNode2? {
        var selectedNode: ListNode2? = tail
        println("getFromTail!!!")
        (0 until index-1).forEach {
            println("-> Val: ${selectedNode?.value} Prev: ${selectedNode?.prev?.value}")
            selectedNode = selectedNode?.prev
        }
        return selectedNode
    }
}

fun printLinkedList(head: ListNode?) {
    var current: ListNode? = head
    println("List Items:")
    while (current != null) {
        println("-> val: ${current.value}")
        current = current.next
    }
}

fun printLinkedList2(head: ListNode2?) {
    var current: ListNode2? = head
    println("List Items:")
    while (current != null) {
        println("-> Val: ${current.value} Prev: ${current?.prev?.value}")
        current = current.next
    }
}

fun printLinkedList2Backwards(tail: ListNode2?) {
    var current: ListNode2? = tail
    println("List Items:")
    while (current != null) {
        println("-> Val: ${current.value} Next: ${current?.next?.value} Prev: ${current?.prev?.value}")
        current = current.prev
    }
}