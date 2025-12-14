package org.tty.leet_code

class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rowCount = board.size
        val columnCount = board[0].size

        val visited = Array(rowCount) {
            BooleanArray(columnCount) { false }
        }

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                if (board[i][j] == word[0]) {
                    if (bfs(board, visited, word, 0, i, j)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun bfs(board: Array<CharArray>, visited: Array<BooleanArray>, word: String, index: Int, i: Int, j: Int): Boolean {
        val rowCount = board.size
        val columnCount = board[0].size

        if (index == word.length - 1) { // 如果当前为最后一个字符
            return true
        }

        visited[i][j] = true

        val directions = arrayOf(
            -1 to 0,
            1 to 0,
            0 to -1,
            0 to 1
        )

        for (direction in directions) {
            val x = i + direction.first
            val y = j + direction.second

            if ((x in 0 until rowCount) && (y in 0 until columnCount) && !visited[x][y] && board[x][y] == word[index + 1]) {
                visited[x][y] = true
                if (bfs(board, visited, word, index + 1, x, y)) {
                    return true
                }
                visited[x][y] = false
            }
        }

        visited[i][j] = false
        return false

//        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word[index + 1]) {
//            visited[i - 1][j] = true
//            if (bfs(board, visited, word, index + 1, i - 1, j)) {
//                return true
//            }
//
//            visited[i - 1][j] = false
//        }
//        if (i < rowCount - 1 && !visited[i + 1][j] && board[i + 1][j] == word[index + 1]) {
//            visited[i + 1][j] = true
//            if (bfs(board, visited, word, index + 1, i + 1, j)) {
//                return true
//            }
//            visited[i + 1][j] = false
//        }
//        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word[index + 1]) {
//            visited[i][j - 1] = true
//            if (bfs(board, visited, word, index + 1, i, j - 1)) {
//                return true
//            }
//            visited[i][j - 1] = false
//        }
//        if (j < columnCount - 1 && !visited[i][j + 1] && board[i][j + 1] == word[index + 1]) {
//            visited[i][j + 1] = true
//            if (bfs(board, visited, word, index + 1, i, j + 1)) {
//                return true
//            }
//            visited[i][j + 1] = false
//        }
//
//        visited[i][j] = false
//        return false
    }


}