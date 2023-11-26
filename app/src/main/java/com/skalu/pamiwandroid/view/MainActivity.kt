package com.skalu.pamiwandroid.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.skalu.pamiwandroid.viewmodel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint
import model.books.Book
import com.skalu.pamiwandroid.navigation.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(viewmodel)
        }
    }
}

@Composable
fun App(booksViewModel: BooksViewModel) {
    MaterialTheme {
        var screenState: Screen by remember { mutableStateOf(Screen.BooksList) }
        var choosenBook: Book? by remember { mutableStateOf(null) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (screenState) {
                Screen.BooksList -> BooksScreen(
                    booksViewModel = booksViewModel,
                    navigateToBookDetails = {
                        choosenBook = it
                        screenState = Screen.BookDetails
                    },
                )

                Screen.BookDetails -> BookDetailsScreen(
                    book = choosenBook,
                    navigateBack = { screenState = Screen.BooksList }
                )
            }
        }
    }
}
