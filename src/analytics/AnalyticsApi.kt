package info.hobocore.websiteChecklist.analytics

import exceptions.SiteParameterMissing
import info.hobocore.websiteChecklist.analytics.entities.AnalyticsReport
import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall

class AnalyticsApi(call: ApplicationCall) : Controller(call) {
    suspend fun check() {
        val url = call.request.queryParameters["site"] ?: throw SiteParameterMissing()

        respondWithJson(AnalyticsReport(url))
    }
}