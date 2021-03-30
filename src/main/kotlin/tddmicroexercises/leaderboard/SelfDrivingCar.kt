package tddmicroexercises.leaderboard

class SelfDrivingCar(val algorithmVersion: String, company: String) : Driver(algorithmVersion, company) {
    override val name: String
        get() = "Self Driving Car - $country $algorithmVersion"
}
