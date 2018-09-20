package info.hobocore.websiteChecklist.analytics.entities

import analytics.entities.AnalyticsTags

data class AnalyticsReport(val url: String) {
    private var analyticsEnabled: Boolean
    private var tagManagerEnabled: Boolean

    init {
        val checker = AnalyticsTags()
        analyticsEnabled = checker.checkForAnalytics(url)
        tagManagerEnabled = checker.checkForGoogleTagManager(url)
    }
}