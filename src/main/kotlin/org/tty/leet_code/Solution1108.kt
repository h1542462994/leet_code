package org.tty.leet_code

/**
 * 1108:: Defanging an IP Address
 *
 * Given a valid (IPv4) IP `address`, return a defanged version of that IP address.
 *
 * *A defanged IP address* replace every `"."` with `[.]`.
 */
class Solution1108 {

    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }
}