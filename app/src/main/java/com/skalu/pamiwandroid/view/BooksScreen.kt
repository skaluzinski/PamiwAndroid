package com.skalu.pamiwandroid.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skalu.pamiwandroid.viewmodel.BooksViewModel
import model.books.Book

@Composable
fun BooksScreen(
    booksViewModel: BooksViewModel,
    navigateToBookDetails: (Book) -> Unit,
) {
    val allBooks by booksViewModel.books.collectAsState()
    Column {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            BooksList(books = allBooks, onBookClick = navigateToBookDetails)
        }
    }
}

@Composable
private fun BooksList(books: List<Book>, onBookClick: (Book) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.wrapContentSize().verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        books.forEach { book ->
            BookCard(
                book = book,
                onClick = { onBookClick(book) }
            )
        }
    }
}

@Composable
private fun BookCard(book: Book, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(vertical = 16.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text("Book Name:")
                Text(book.title)
            }
            Row {
                Text("Book Author:")
                Text(book.author)
            }
        }
    }
}