package tddmicroexercises.leaderboard

class Leaderboard(val races: List<Race>) {
    fun driverResults(): Map<Driver, Int> {
        return races.flatMap { race -> race.results.map { driver -> driver to race.points(driver) } }
            .groupBy { it.first }
            .mapValues { it.value.map { it.second }.sum() }
    }

    fun driverRankings() = driverResults().entries.sortedByDescending { it.value }.map { it.key }
}
