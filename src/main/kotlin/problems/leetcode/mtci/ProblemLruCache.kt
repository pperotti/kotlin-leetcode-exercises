package problems.leetcode.mtci

import problems.Problem
import java.util.LinkedList

class ProblemLruCache : Problem {

    override fun execute() {
        val lruCache = LRUCache(3)
        lruCache.put(1, 100)
        lruCache.put(2, 101)
        lruCache.put(3, 103)
        lruCache.put(4, 104)
        lruCache.put(3, 105)
        println("Elements: ${lruCache.cache}")

        /*
        val cache = LinkedList<Int>()
        cache.addFirst(1)
        cache.addFirst(2)
        cache.addFirst(3)
        cache.addFirst(4)
        println("Contents: $cache")
        val v = cache.removeAt(3)
        println("Removed: $v")
        println("Contents: $cache")
        val w = cache.removeLast()
        println("Removed: $w")
        println("Contents: $cache")
        */
    }
}

// Version #1
class LRUCache(private val capacity: Int) {

    val cache = LinkedList<Int>()
    val map = mutableMapOf<Int, Int>()

    fun get(key: Int): Int {
        // Return immediately if there the cache is empty
        if (cache.isEmpty()) {
            return -1
        }
        // Move the key from the current position of the queue
        // and add it to the beginning of it
        if (cache.remove(key)) {
            cache.addFirst(key)
        }
        // Retrieve the value associated with the key or -1
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {

        // Validation around the capacity value
        if (!map.contains(key) && map.size >= capacity) {
            val keyToRemove = cache.removeLast()
            map.remove(keyToRemove)
        }

        // Remove the key if that exists in the cache
        cache.remove(key)

        // Add the key to the beginning of the cache
        cache.addFirst(key)

        // Add/Update the map with the appropriate value
        map[key] = value
    }
}

// Version #2 - More efficient but does not work
/*class LRUCache(val capacity: Int) {
    val cache = java.util.TreeMap<Int, Int>()

    fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val value = cache[key]!!
            cache.remove(key)
            cache.put(key, value)
            return value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            cache.remove(key)
        } else if (cache.size >= capacity) {
            val firstKey = cache.firstKey()
            cache.remove(firstKey)
        }
        cache.put(key, value)
    }
}
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */