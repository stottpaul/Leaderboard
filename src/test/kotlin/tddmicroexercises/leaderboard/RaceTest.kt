package tddmicroexercises.leaderboard

import org.junit.Assert
import org.junit.Test

class RaceTest {

    @Test
    fun isShouldCalculateDriverPoints() {
        // setup
        val driver1 = Driver("Nico Rosberg", "DE")
        val driver2 = Driver("Lewis Hamilton", "UK")
        val driver3 = Driver("Sebastian Vettel", "DE")

        val race1 = Race("Australian Grand Prix", driver1, driver2, driver3)

        // act

        // verify
        Assert.assertEquals(25, race1.points(driver1))
        Assert.assertEquals(18, race1.points(driver2))
        Assert.assertEquals(15, race1.points(driver3))
    }

}
