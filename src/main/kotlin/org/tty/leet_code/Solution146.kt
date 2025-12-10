package org.tty.leet_code

import java.util.LinkedList

class LRUCache(val capacity: Int) {


    val storage = mutableMapOf<Int, Int>()
    var indexList = LinkedList<Int>()

    fun get(key: Int): Int {
        if (storage.contains(key)) {
            updateKey(key)
            return storage[key]!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (storage.contains(key)) {
            storage[key] = value
            updateKey(key)
            return
        }

        if (indexList.size >= capacity) {
            val key = indexList.removeFirst()
            storage.remove(key)
        }
        storage[key] = value
        indexList.add(key)
    }

    private fun updateKey(key: Int) {
        indexList.remove(key)
        indexList.add(key)
    }


}