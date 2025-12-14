package org.tty.leet_code

class Trie() {

    class TrieNode(
        val nodes: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isEnd: Boolean = false
    )

    val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for (c in word) {
            if (!cur.nodes.contains(c)) {
                cur.nodes[c] = TrieNode()
            }
            cur = cur.nodes[c]!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        return internalSearch(word) == 2
    }

    fun startsWith(prefix: String): Boolean {
        return internalSearch(prefix) >= 1
    }

    private fun internalSearch(word: String): Int {
        var cur = root
        for (c in word) {
            if (!cur.nodes.contains(c)) {
                return 0
            }
            cur = cur.nodes[c]!!
        }
        return if (cur.isEnd) 2 else 1
    }
}