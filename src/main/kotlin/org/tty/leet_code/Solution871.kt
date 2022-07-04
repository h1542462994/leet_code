package org.tty.leet_code

import java.util.PriorityQueue

/**
 * 871:: Minimum Number of Refueling Stops.
 *
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 *
 * There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
 *
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 *
 * Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
 *
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 * **Solution:**
 * 1. use cupidity algorithm (strategy), use a priority queue to manage available stations.
 * 2. if target <= fuel, mean has no fuel, return 0
 * 3. select the max fuel station for each iter, then update the available stations by current fuel. repeat 3 until current fuel >= target or all station is used.
 *
 * - time complexity: O(n)
 * - space complexity: O(n)
 *
 * **Result:**
 * - time: 208ms 96.43%
 * - memory: 38.6MB 10.71%
 */
class Solution871 {
    data class Station(
        val at: Int,
        val fuel: Int
    )

    /**
     * select the station which has max fuel first.
     */
    private val stationComparator = Comparator<Station> { a, b ->
        b.fuel - a.fuel
    }

    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val priorityQueue = PriorityQueue(stationComparator)
        if (startFuel >= target) {
             return 0
        }

        var currentMaxFuel = startFuel
        var destinationsCount = 0
        var i = 0
        while (currentMaxFuel < target) {
            // add the station to priority queue
            while (i < stations.size) {
                val station = Station(stations[i][0], stations[i][1])
                if (station.at <= currentMaxFuel) {
                    priorityQueue.add(station)
                    i++
                } else {
                    break
                }
            }

            val peek = priorityQueue.poll() ?: break
            destinationsCount++
            currentMaxFuel += peek.fuel
        }

        return if (currentMaxFuel >= target) {
            destinationsCount
        } else {
            -1
        }

    }
}