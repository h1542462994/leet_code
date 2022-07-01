package org.tty.leet_code

import kotlin.math.absoluteValue

/**
 * 535: Encode and Decode TinyURL
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * Implement the Solution class:
 * Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 *
 * **Solution: **
 * - use hashCode to storage the recorded urls if conflicted, find it by inner index.
 * - hashCode is encoded to base62 shortString, + and / is not included.
 *
 * **Result: **
 * - time 200ms 100.00%
 * - memory 35.6MB 50.00%
 * - at 2022/6/29
 */
class Codec() {
    private val urlMap: MutableMap<Int, MutableList<String>> = mutableMapOf()
    private val bitEncodeC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    private val bitEncodeLength = bitEncodeC.length
    private val urlPrefix = "https://xiaoxin.ink/redirect/"

    private fun encodeInt(value: Int): String {
        var v = value
        val bits = StringBuilder()
        while (v > 0) {
            val next = v % bitEncodeLength
            bits.append(bitEncodeC[next])
            v /= bitEncodeLength
        }
        return bits.reverse().toString()
    }

    private fun charIndex(char: Char): Int {
        return when (char) {
            in '0'..'9' -> {
                (char - '0')
            }
            in 'A'..'Z' -> {
                (char - 'A') + 10
            }
            in 'a'..'z' -> {
                (char - 'a') + 36
            }
            else -> {
                0
            }
        }
    }

    private fun decodeString(value: String): Int {
        var v = 0
        for (bit in value.toCharArray()) {
            v = v * bitEncodeLength + charIndex(bit)
        }
        return v
    }

    private fun stringHash(longUrl: String): Int {
        return longUrl.hashCode().absoluteValue
    }

    fun encode(longUrl: String): String {
        val hash = stringHash(longUrl)
        val urls = urlMap.getOrPut(hash) { mutableListOf() }
        var index = urls.indexOfFirst { it == longUrl }
        if (index == -1) {
            index = urls.size
            urls.add(longUrl)
        }

        val urlBuilder = StringBuilder()
        urlBuilder.append(urlPrefix)
        urlBuilder.append(encodeInt(hash))
        if (index != 0) {
            urlBuilder.append("_")
            urlBuilder.append(encodeInt(index))
        }
        return urlBuilder.toString()
    }

    fun decode(shortUrl: String): String {
        if(!shortUrl.startsWith(urlPrefix)) {
            return "about:blank"
        }

        val follow = shortUrl
            .substring(urlPrefix.length until shortUrl.length)
            .split("_")

        val urlHash = decodeString(follow[0])
        var index = 0
        if (follow.size > 1) {
            index = decodeString(follow[1])
        }

        return urlMap[urlHash]?.get(index) ?: "about:blank"
    }
}