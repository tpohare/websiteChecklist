package analytics.entities

import info.hobocore.websiteChecklist.homepage.entities.Webpage

class AnalyticsTags {
    fun checkForAnalytics(url: String): Boolean {
        val pageSource:String = Webpage(url).unGzipped()
        val analyticsRegex = """UA-\d{4,9}-\d{1,4}""".toRegex()

        return analyticsRegex.containsMatchIn(pageSource)
    }

    fun checkForGoogleTagManager(url: String): Boolean {
        val pageSource: String = Webpage(url).unGzipped()
        val tagManagerRegex = "GTM-\\S+".toRegex()

        return tagManagerRegex.containsMatchIn(pageSource)
    }
}
