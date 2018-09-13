package info.hobocore.websiteChecklist.http

import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respondText

open class Controller(private var call: ApplicationCall) {
    suspend fun respond(body:String) {
        call.respondText(body, ContentType.Text.Html, HttpStatusCode.OK)
    }
}