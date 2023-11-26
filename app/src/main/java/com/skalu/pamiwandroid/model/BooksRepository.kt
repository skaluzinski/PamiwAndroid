package model.books

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

private const val API_ENDPOINT = "http://10.0.2.2:8080"

@Singleton
class BooksRepository @Inject constructor() {
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    private suspend fun httpResponse(path: String): HttpResponse {
        println("### $path")
        val response: HttpResponse = client.get(API_ENDPOINT) {
            url {
                protocol = URLProtocol.HTTP
                host = "10.0.2.2"
                port = 8080
                path("/api/$path")
            }
        }

        println("### #${response.call.request.url}")
        return response
    }

    fun getBooksByAuthorOrNull(author: String): Book? {

        return null
    }

    suspend fun getAllBooks(): List<Book> {
        try {
            val response: HttpResponse = httpResponse("books")
            return response.body()
        } catch (e: Exception) {
            println("### $e")
            println("### excception${e.cause?.message}")
        }
        return emptyList()
    }

    fun addBook(book: Book) {

    }

    fun deleteBook(id: Int) {

    }
}