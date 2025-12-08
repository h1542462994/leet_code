package org.tty.leet_code

import java.util.Random


class RandomizedSet() {
    // hash表，键为数，值为recording中的索引
    val numMap = mutableMapOf<Int, Int>()
    // 索引，表示哪些数存在
    val indexRecordings = mutableListOf<Int>()
    val random = Random()

    fun insert(`val`: Int): Boolean {
        if (numMap.contains(`val`)) {
            return false
        }

        numMap[`val`] = indexRecordings.size
        indexRecordings.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!numMap.contains(`val`)) {
            return false
        }

        val index = numMap.remove(`val`)!!

        val value = indexRecordings.removeLast()

        // 最后一个，直接移除！否则用最后一个元素替换空缺的位置，需要注意的，上述移除已经修改了indexRecording.size
        if (index != indexRecordings.size){
            indexRecordings[index] = value
            numMap[value] = index
        }
        return true
    }

    fun getRandom(): Int {
        val randomIndex = random.nextInt(0, indexRecordings.size)
        return indexRecordings[randomIndex]
    }
}