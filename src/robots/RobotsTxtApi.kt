package info.hobocore.websiteChecklist.robots

import info.hobocore.websiteChecklist.http.Controller
import io.ktor.application.ApplicationCall
import robots.entities.RobotsTxtReport

class RobotsTxtApi(call: ApplicationCall) : Controller(call) {
    suspend fun check() {
        val url = queryParameter("site")

        respondWithJson(RobotsTxtReport(url))
    }
}