package org.tty.leet_code

/**
 * 1089:: Duplicate Zeros (Easy)
 *
 * Given a fixed-length integer array `arr`, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * **Note** that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 * **Constraints:**
 * - 1 <= arr.length <= 10^4
 * - 0 <= arr[i] <= 9
 *
 * **Solution:**
 * - use double pointer, the writer locator is the place to write data.
 * - because writing the data immediately will cover the valid data, so rollback the pointer to write data. (2 turn scann.)
 *
 * **Difficultly:**
 * - the boundary of the pointer.
 * - 2 turn scan.
 *
 * **Result:**
 * - time: 200ms 56.00%.
 * - memory 36.5MB 64.00%.
 * - at 2022/6/20
 */
class Solution1089 {
    fun duplicateZeros(arr: IntArray): Unit {
        var indexScanner = 0 // the next scanner pointer
        var indexWriter = 0 // the next writer pointer

        while (indexWriter < arr.size) { // if indexWriter is above the arr.size, the pointer is not need.
            if (arr[indexScanner] == 0) { // the move of the writer pointer
                indexWriter += 2
            } else {
                indexWriter++
            }
            indexScanner++ // the move of the scanner pointer
        }

        indexScanner--
        indexWriter--

        // element @indexWriter will be arr.size - 1 if element is not zero,
        // will be arr.size || arr.size - 1 if element is zero.

        // rollback the pointer, notice the indexWrite maybe out of bound.
        while (indexScanner >= 0) {
            if (arr[indexScanner] == 0) {
                if (indexWriter < arr.size) {
                    arr[indexWriter] = 0
                }
                indexWriter--
            }

            arr[indexWriter] = arr[indexScanner]
            indexWriter--
            indexScanner--
        }

    }
}