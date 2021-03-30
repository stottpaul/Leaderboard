package tddmicroexercises.leaderboard

import java.lang.IllegalArgumentException

class Race(private val name: String, vararg results: Driver) {
    val results: List<Driver> = arrayListOf(*results)

    private fun position(driver: Driver): Int {
        return this.results.indexOf(driver)
    }

    fun points(driver: Driver): Int {
        return PositionalPoints.point(position(driver))
    }

    override fun toString(): String {
        return name
    }
}

object PositionalPoints {

    private val positionMap = mapOf(0 to 25, 1 to 18, 2 to 15)

    fun point(position: Int) =
        positionMap.get(position) ?: throw IllegalArgumentException("No such position: $position")

}
