package homepage.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage

class AnalyticsChecker {
    fun checkForAnalytics(url: String): Boolean {
        val pageSource:String = Webpage(url).unGzipped()
        val analyticsRegex = """UA-\d{4,9}-\d{1,4}""".toRegex()

        return analyticsRegex.containsMatchIn(pageSource)
    }
}
