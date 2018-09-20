package info.hobocore.websiteChecklist

import info.hobocore.websiteChecklist.analytics.AnalyticsApi
import info.hobocore.websiteChecklist.exceptions.AuthenticationFailed
import info.hobocore.websiteChecklist.exceptions.AuthorizationFailed
import info.hobocore.websiteChecklist.homepage.Homepage
import info.hobocore.websiteChecklist.persistence.UserSession
import info.hobocore.websiteChecklist.tags.TagsApi
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.jetty.Jetty
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.locations.Locations
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.netty.DevelopmentEngine
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import org.slf4j.event.Level
import kotlin.collections.set

fun main(args: Array<String>): Unit = DevelopmentEngine.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    //region Boot
    install(Locations) {
    }

    install(Sessions) {
        cookie<UserSession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    install(ConditionalHeaders)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(ContentNegotiation) {
        gson {
            // Configure Gson here
        }
    }

    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }

    val client = HttpClient(Jetty) {
    }
    //endregion

    routing {
        get("/") {
            Homepage(call).index()
        }

        get("/tags") {
            val url = call.request.queryParameters["site"] ?: "https://www.fusio.net/"
            TagsApi(call).check(url)
        }

        get("/analytics") {
            val url = call.request.queryParameters["site"] ?: "https://www.theverge.com/"
            AnalyticsApi(call).check(url)
        }

        //region static files
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }
        //endregion

        //region Errors
        install(StatusPages) {
            exception<AuthenticationFailed> {  cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationFailed> {  cause ->
                call.respond(HttpStatusCode.Forbidden)
            }

        }
        //endregion
    }
}
