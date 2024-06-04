package com.emreozcan.rickandmorty.network.http

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Created by @Emre Özcan on 4.06.2024
 */
class AppHttpClientBuilder {

    private val protocol: URLProtocol = URLProtocol.HTTPS
    private lateinit var host: String

    fun host(host: String) = apply {
        this.host = host
    }

    fun build(): HttpClient {
        return HttpClient(CIO) {
            expectSuccess = true

            engine {
                endpoint {
                    keepAliveTime = 5000
                    connectTimeout = 5000
                    connectAttempts = 3
                }
            }

            defaultRequest {
                url {
                    protocol = this@AppHttpClientBuilder.protocol
                    host = this@AppHttpClientBuilder.host
                }
                header(HttpHeaders.ContentType, "application/json")
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            //Api does not have an authentication method
            /*install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens("", "")
                    }
                }
            }*/

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}