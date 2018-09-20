package info.hobocore.websiteChecklist.tags

import info.hobocore.websiteChecklist.http.Controller
import info.hobocore.websiteChecklist.tags.entities.OgTagReport
import io.ktor.application.ApplicationCall

class TagsApi(call: ApplicationCall) : Controller(call) {
    suspend fun check() {
        val url = queryParameter("site")

        respondWithJson(OgTagReport(url))
    }
}