package info.hobocore.websiteChecklist.api

import info.hobocore.websiteChecklist.homepage.entities.OgTagReport
import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall

class TagChecker(call: ApplicationCall) : Controller(call) {
    suspend fun index(url:String) {
        respondWithJson(OgTagReport(url))
    }
}