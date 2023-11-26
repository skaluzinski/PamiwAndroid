package model.books

import kotlinx.serialization.Serializable
import java.util.concurrent.atomic.AtomicInteger

@Serializable
data class Book(val id: Int? = null, var title: String, var author: String)


