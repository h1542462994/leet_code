package org.tty.leet_code

class Solution383 {
    class CharHash() {
        val charHash = mutableMapOf<Char, Int>()

        fun isSubOf(other: CharHash): Boolean {
            for (pair in charHash) {
                val otherValue = other.charHash[pair.key] ?: 0
                if (pair.value > otherValue) {
                    return false
                }
            }
            return true
        }

        companion object {
            fun fromString(value: String): CharHash {
                val hash = CharHash()
                for (char in value) {
                    hash.charHash[char] = (hash.charHash[char] ?: 0) + 1
                }
                return hash
            }
        }
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hash1 = CharHash.fromString(ransomNote)
        val hash2 = CharHash.fromString(magazine)
        return hash1.isSubOf(hash2)
    }
}