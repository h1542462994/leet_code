package org.tty.leet_code

class WordDictionary() {

    class TrieNode(
        val nodes: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isEnd: Boolean = false
    )

    val root = TrieNode()

    fun addWord(word: String) {
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
        val queue = mutableListOf(root)

        for (c in word) {
            val length = queue.size
            if (length == 0) {
                return false
            }

            for (i in 0 until length) {
                val cur = queue.removeFirst()
                if (c == '.') { // 匹配任意
                    queue.addAll(cur.nodes.values)
                } else if (cur.nodes.contains(c)) {
                    queue.add(cur.nodes[c]!!)
                }
            }
        }

        return queue.any { it.isEnd }
    }

}