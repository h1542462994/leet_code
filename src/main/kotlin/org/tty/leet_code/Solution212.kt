package org.tty.leet_code

class Solution212 {
    class TrieNode(
        val nodes: MutableMap<Char, TrieNode> = mutableMapOf(),
    )

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val rowCount = board.size
        val columnCount = board[0].size

        val wordLength = words.maxOf { it.length }
        val root = TrieNode()

        // construct trie.
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                dfsBuild(board, root, i, j, wordLength, mutableMapOf())
            }
        }

        val result = mutableListOf<String>()
        for (word in words) {
            if (search(root, word)) {
                result.add(word)
            }
        }
        return result
    }

    private fun dfsBuild(board: Array<CharArray>, node: TrieNode, i: Int, j: Int, depth: Int, visited: MutableMap<Int, MutableList<Int>>) {
        if (depth <= 0) {
            return
        }

        val rowCount = board.size
        val columnCount = board[0].size

        val c = board[i][j]


        if (!node.nodes.contains(c)) {
            node.nodes[c] = TrieNode()
        }

        val newNode = node.nodes[c]!!

        fun v(i: Int, j: Int): Boolean {
            if (!visited.contains(i)) {
                return false
            }

            return visited[i]!!.contains(j)
        }

        // clone the visited.
        val newVisited = mutableMapOf<Int, MutableList<Int>>()
        for (pair in visited) {
            newVisited[pair.key] = mutableListOf()
            newVisited[pair.key]!!.addAll(pair.value)
        }

        if (!newVisited.contains(i)) {
            newVisited[i] = mutableListOf()
        }
        newVisited[i]!!.add(j)

        if (i > 0 && !v(i - 1, j)) {
            dfsBuild(board, newNode,i - 1, j, depth - 1, newVisited)
        }
        if (i < rowCount - 1 && !v(i + 1, j)) {
            dfsBuild(board, newNode, i + 1, j, depth - 1, newVisited)
        }
        if (j > 0 && !v(i, j - 1)) {
            dfsBuild(board, newNode, i, j - 1, depth - 1, newVisited)
        }
        if (j < columnCount - 1 && !v(i, j + 1)) {
            dfsBuild(board, newNode, i, j + 1, depth - 1, newVisited)
        }

    }

    private fun search(root: TrieNode, word: String): Boolean {
        var cur = root
        for (c in word) {
            if (!cur.nodes.contains(c)) {
                return false
            }
            cur = cur.nodes[c]!!
        }
        return true
    }
}