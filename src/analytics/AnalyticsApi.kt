package info.hobocore.websiteChecklist.analytics

import info.hobocore.websiteChecklist.analytics.entities.AnalyticsReport
import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall


class AnalyticsApi(call: ApplicationCall) : Controller(call) {
    suspend fun check(url: String) {
        respondWithJson(AnalyticsReport(url))
    }
}