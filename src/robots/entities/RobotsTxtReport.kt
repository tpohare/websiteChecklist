package robots.entities

data class RobotsTxtReport(val url: String) {
    private var homepageAccessible: Boolean

    init {
        val checker = RobotsTxtRules()
        checker.parseURL(url)
        homepageAccessible = checker.canTheHomepageBeIndexed()
    }
}