package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Codec

class Test535 {
    @Test
    fun test535() {
        val sourceUrl = "https://xiaoxin.ink/dailyset/docs/"
        val solution = Codec()
        val shortUrl = solution.encode(sourceUrl)
        println(shortUrl)
        val longUrl = solution.decode(shortUrl)
        println(longUrl)

        val shortUrl2 = solution.encode(sourceUrl)
        println(shortUrl2)

    }

}