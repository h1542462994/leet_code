package org.tty.leet_code

/**
 * 532:: K-diff Pairs in an Array (Normal)
 *
 * Given an array of integer `nums` and an integer `k`, return the numbers of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair `(nums[i], nums[j])`, where the following are true:
 *
 * - 0 <= i, j < nums.length
 * - i != j
 * - nums[i] - nums[j] == k
 *
 * **Notice** that `|val|` denotes the absolute value of `val`.
 *
 * constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^7 <= nums[i] <= 10^7
 * - 0 <= k <= 10^7
 *
 * **Solution**
 *
 * Keyword: Hashtable
 *
 * when k > 0
 * 1. create compList :intArray which elements are :nums + k
 * 2. sourceValues = hash(numList), targetValues = hash(compList)
 * 3. foreach hashKey in sourceValues, compare with the targetValues.
 *
 *  when k == 0
 * 1. calculate the elements occurs more than 1 times.
 * 2. use hash, which is same as condition k > 0.
 *
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 *
 * **Result**
 * - time: 312ms 100%,
 * - memory: 43.3MB 100%,
 * - at 2022/6/16
 */
class Solution532V1 {
    companion object {
        const val limitD = -10000000
        const val limitU = 10000000
        const val hashRange = 10000
    }

    /**
     * calculate :num + k.
     * O(n)
     */
    private fun arrayOffset(nums: List<Int>, k: Int): List<Int> {
        return nums
            .map { num -> num + k }
            .filter { num -> num in limitD..limitU }
    }

    /**
     * calculate hashes.
     * O(n)
     */
    private fun List<Int>.toHashes(): Map<Int, List<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        this.forEach { num ->
            // calculate the hash value range to hashRange
            val hashValue = num.hashCode().rem(hashRange)
            // put the value
            val list = map.getOrPut(hashValue) { mutableListOf() }
            list.add(num)
        }
        return map
    }

    private fun calculateNum(sourceValue: List<Int>, targetValue: List<Int>): Int {
        return if (sourceValue.isEmpty() || targetValue.isEmpty()) {
            0
        } else {
            var value = 0
            sourceValue.forEach {
                if (targetValue.contains(it)) {
                    value += 1
                }
            }
            value
        }
    }

    private fun calculateNumSingle(sourceValue: List<Int>): Int {
        return if (sourceValue.isEmpty() || sourceValue.size == 1) {
            0
        } else {
            // value - count
            val map = mutableMapOf<Int, Int>()
            sourceValue.forEach { value ->
                val count = map.getOrDefault(value, 0)
                map[value] = count + 1
            }
            map
                .filter { it.value > 1 }
                .count()
        }
    }

    fun findPairs(nums: IntArray, k: Int): Int {
        var value = 0
        if (k > 0) {
            val numList = nums.toList().distinct()
            val sourceHashes = numList.toHashes()
            val compareHashes = arrayOffset(numList, k).toHashes()
            value = sourceHashes.map {
                val sourceValue = it.value
                val targetValue = compareHashes.getOrDefault(it.key, listOf())
                return@map calculateNum(sourceValue, targetValue)
            }.sum()
        } else if (k == 0) {
            val numList = nums.toList()
            val sourceHashes = numList.toHashes()
            value = sourceHashes.map {
                return@map calculateNumSingle(it.value)
            }.sum()
        }

        return value
    }
}

/**
 * v2 version.
 *
 * compared with upper, the hash value could just use the raw value. (because it is int value.)
 *
 * just use mark, instead of element comparison. (if element is visited more than 1 time, then mark it.)
 *
 *  **Result**
 * - time: 248ms 100%,
 * - memory: 37.4MB 100%,
 * - at 2022/6/16
 */
class Solution532V2 {
    private fun Iterable<Int>.toHashes(): MutableMap<Int, Int> {
        val hash = mutableMapOf<Int, Int>()
        this.forEach { value ->
            val count = hash.getOrDefault(value, 0)
            hash[value] = count + 1
        }
        return hash
    }

    fun findPairs(nums: IntArray, k: Int): Int {
        // create hash element - count (o(n))
        val numHash = nums.asIterable().toHashes()
        // o(n)
        return if (k > 0) {
            nums
                .count { num ->
                    // if exists return true
                    val result = (num + k) in numHash
                    // if visited, remove.
                    if (result) {
                        numHash.remove(num + k)
                    }
                    return@count result
                }
        } else {
            // return elements occurs more than 1 times.
            numHash.count { it.value > 1 }
        }
    }
}