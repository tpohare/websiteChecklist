package robots.entities

data class RobotsTxtReport(val url: String) {
    private var homepageAccessible: Boolean

    init {
        val checker = RobotsTxtChecker()
        checker.parseURL(url)
        homepageAccessible = checker.canTheHomepageBeIndexed()
    }
}