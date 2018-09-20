package info.hobocore.websiteChecklist.tags

import exceptions.SiteParameterMissing
import info.hobocore.websiteChecklist.http.Controller
import info.hobocore.websiteChecklist.tags.entities.OgTagReport
import io.ktor.application.ApplicationCall

class TagsApi(call: ApplicationCall) : Controller(call) {
    suspend fun check() {
        val url = call.request.queryParameters["site"] ?: throw SiteParameterMissing()

        respondWithJson(OgTagReport(url))
    }
}