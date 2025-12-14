package org.tty.leet_code

class Solution433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val visits = BooleanArray(bank.size) { false }


        fun generateGenes(gene: String): List<String> {
            val result = mutableListOf<String>()
            for (i in 0 until gene.length) {
                for (s in "ACGT") {
                    if (s != gene[i]) {
                        val newGene = gene.replaceRange(i .. i, s.toString())

                        val index = bank.indexOf(newGene)
                        if (index != -1 && !visits[index]) {
                            visits[index] = true
                            result.add(newGene)
                        }
                    }
                }
            }
            return result
        }

        val list = mutableListOf(startGene)
        var step = 0
        while (true) {
            val length = list.size

            if (length == 0) {
                return -1
            }

            step++
            for (i in 0 until length) {
                val cur = list.removeFirst()

                if (cur == endGene) {
                    return step - 1
                }

                list.addAll(generateGenes(cur))
            }
        }
    }
}