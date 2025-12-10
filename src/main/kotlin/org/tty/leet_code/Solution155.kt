package org.tty.leet_code

class MinStack() {

    val container = mutableListOf<Int>()
    var minIndex: Int = -1

    fun push(`val`: Int) {
        container.add(`val`)
        if (minIndex == -1 || `val` < container[minIndex]) {
            minIndex = container.size - 1
        }
    }

    fun pop() {
        if (container.isEmpty()) {
            return
        }

        val cur = container.removeLast()
        if (container.isEmpty()) {
            minIndex = -1
        } else if (minIndex == container.size) {
            // recompute the minIndex.
            var minValue: Int? = null
            var minIndex = -1
            for (i in container.indices) {
                if (minValue == null || container[i] < minValue) {
                    minValue = container[i]
                    minIndex = i
                }
            }
            this.minIndex = minIndex
        }
    }

    fun top(): Int {
        if (container.isEmpty()) {
            throw IllegalStateException("empty!")
        }
        return container.last()
    }

    fun getMin(): Int {
        if (container.isEmpty()) {
            throw IllegalStateException("empty!")
        }
        return container[minIndex]
    }

}