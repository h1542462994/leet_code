package org.tty.leet_code

/**
 * 30::SubString with Concatenation of All Words
 * You are given a string `s` and an array of strings `words` of **the same length**.
 *
 * Return all starting indices of substring(s) in `s` that is a concatenation of each words in `words` **exactly once, in any order,** and **without any intervening characters.**
 *
 * You can return the answer in **any order.**
 *
 * **Constraints:**
 * - `1 <= s.length <= 10^4`
 * - `s` consists of lower-case English letters.
 * - `1 <= words.length <= 5000`
 * - `1 <= words[i].length <= 30`
 * - `words[i]` consists of lower-case English letters.
 *
 * **Solution:**
 * 1. use bitmap to find index.
 *
 * **Result:**
 * - MLE
 */
class Solution30 {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // store the word and indices.
        class WordIndices(
            // the occurrence
            var occurrence: Int,
            // find indices
            val indices: MutableList<Int>
        )

        // init the word indices.
        require(words.isNotEmpty())
        val wordLength = words[0].length


        val mapStorage = hashMapOf<String, WordIndices>()
        words.forEach {
            val wordIndices = mapStorage.getOrPut(it) {
                WordIndices(0, mutableListOf())
            }

            wordIndices.occurrence += 1
        }

        // scan the string and record the indices.
        @Suppress("IfThenToSafeAccess")
        for (scanIndex in  0 until s.length - wordLength + 1) {
            val wordTake = s.substring(scanIndex until scanIndex + wordLength)
            val wordIndices = mapStorage[wordTake]
            if (wordIndices != null) {
                wordIndices.indices.add(scanIndex)
            }
        }

        // use bitmap to find the index.
        data class WordBitmap(
            val highBitIndex: Int,
            val value: Int
        )

        var bitmaps = mutableListOf<WordBitmap>()
        for (word in words) {
            if (bitmaps.isEmpty()) {
                // if bitmap is empty, create the initial bitmap.
                val wordIndices = mapStorage.getValue(word)
                if (wordIndices.indices.isEmpty()) {
                    return listOf()
                }
                wordIndices.indices.forEach {
                    bitmaps.add(WordBitmap(it, 1))
                }
            } else {
                val newBitmaps = mutableListOf<WordBitmap>()
                val wordIndices = mapStorage.getValue(word)
                if (wordIndices.indices.isEmpty()) {
                    return listOf()
                }
                // create new bitmaps
                wordIndices.indices.forEach { inp ->
                    bitmaps.forEach { bitmap ->
                        val step = (inp - bitmap.highBitIndex) / wordLength
                        val rem = (inp - bitmap.highBitIndex) % wordLength
                        if (rem == 0 && step != 0) {
                            if (step > 0) {
                                // high bit index changed
                                newBitmaps.add(WordBitmap(inp, bitmap.value.shl(step) + 1 ))
                            } else {
                                // high bit index not change
                                newBitmaps.add(WordBitmap(bitmap.highBitIndex, bitmap.value + (1).shl(-step)))
                            }
                        }
                    }
                }
                bitmaps = newBitmaps
            }
        }

        val resultList = mutableListOf<Int>()
        for (bitmap in bitmaps) {
            // bitmap values is 11111..
            if (bitmap.value == (1).shl(words.size) - 1) {
                // translate to the start index.
                resultList.add(bitmap.highBitIndex - wordLength * (words.size - 1))
            }
        }
        return resultList.distinct()
    }
}

/**
 * **Solution:**
 * Window Movement.
 * 1. map words to `[word: frequency]`.
 * 2. use window to slice the string and check it to words.
 *
 * **Result:**
 * - time: 472ms, 57.14%
 * - memory: 39.9MB, 80.95%
 * - at 2022/6/23
 */
class Solution30V2 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // init the word indices.
        require(words.isNotEmpty())
        val wordLength = words[0].length

        val mapStorage = hashMapOf<String, Int>()
        words.forEach {
            mapStorage[it] = mapStorage.getOrDefault(it, 0) + 1
        }

        // traditional check.
        fun checkIt(s: String, scanIndex: Int): Boolean {
            val wordOccurrence = mutableMapOf<String, Int>()
            for (i in words.indices) {
                val startIndex = scanIndex + i * wordLength
                val word = s.substring(startIndex until startIndex + wordLength)
                val wordIndices = mapStorage[word]
                if (wordIndices == null) {
                    return false
                } else {
                    wordOccurrence[word] = wordOccurrence.getOrDefault(word, 0) + 1
                }
            }

            for (wordIndices in mapStorage) {
                if (wordOccurrence.getOrDefault(wordIndices.key, 0) != wordIndices.value) {
                    return false
                }
            }
            return true
        }

        val resultIndex = mutableListOf<Int>()
        // scan the string and check it
        for (scanIndex in 0 until s.length - wordLength * words.size + 1) {
            if (checkIt(s, scanIndex)) {
                resultIndex.add(scanIndex)
            }
        }

        return resultIndex
    }
}
