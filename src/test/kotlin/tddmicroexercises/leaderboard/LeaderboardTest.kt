package tddmicroexercises.leaderboard

import org.junit.Assert.assertEquals
import org.junit.Test


class LeaderboardTest {

    @Test
    fun `should sum the points for the given driver`() {
        // setup
        val driver1 = Driver("Nico Rosberg", "DE")
        val driver2 = Driver("Lewis Hamilton", "UK")
        val driver3 = Driver("Sebastian Vettel", "DE")

        val race1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        val race2 = Race("Malaysian Grand Prix", driver3, driver2, driver1)
        val race3 = Race("Chinese Grand Prix", driver2, driver1, driver3)

        val leaderboard = Leaderboard(races = listOf(race1,race2,race3))

        // act
        val results = leaderboard.driverResults()

        // verify
        assertEquals("Nico",25 + 15 + 18, results[driver1])
        assertEquals("Lewis",18 + 18 + 25, results[driver2])
        assertEquals("Sebastian", 15 + 25 + 15, results[driver3])
    }

    @Test
    fun isShouldFindTheWinner() {
        // setup
        val driver1 = Driver("Nico Rosberg", "DE")
        val driver2 = Driver("Lewis Hamilton", "UK")
        val driver3 = Driver("Sebastian Vettel", "DE")

        val race1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        val race2 = Race("Malaysian Grand Prix", driver3, driver2, driver1)
        val race3 = Race("Chinese Grand Prix", driver2, driver1, driver3)

        val leaderboard = Leaderboard(races = listOf(race1,race2,race3))

        // act
        val result = leaderboard.driverRankings()

        // verify
        assertEquals(driver2, result.get(0))
    }

    @Test
    fun itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        val driver1 = Driver("Nico Rosberg", "DE")
        val driver2 = Driver("Lewis Hamilton", "UK")
        val driver3 = Driver("Sebastian Vettel", "DE")

        val winDriver1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        val winDriver2 = Race("Malaysian Grand Prix", driver2, driver1, driver3)

        val exEquoLeaderBoard = Leaderboard(listOf(winDriver1, winDriver2))

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(arrayListOf(driver1, driver2, driver3), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }
}
