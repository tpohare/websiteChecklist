package info.hobocore.websiteChecklist.gzip

import exceptions.SiteParameterMissing
import info.hobocore.websiteChecklist.gzip.entities.GzipReport
import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall

class GzipApi(call: ApplicationCall) : Controller(call) {
    suspend fun check() {
        val url = call.request.queryParameters["site"] ?: throw SiteParameterMissing()

        respondWithJson(GzipReport(url))
    }
}