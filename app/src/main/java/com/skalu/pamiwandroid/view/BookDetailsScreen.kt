package com.skalu.pamiwandroid.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.books.Book

@Composable
fun BookDetailsScreen(book: Book?, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val colorScheme = MaterialTheme.colorScheme
        val containerModifier = remember {
            Modifier.background(colorScheme.secondaryContainer)
        }
        TextButton(modifier = Modifier.fillMaxWidth().height(48.dp).background(colorScheme.primaryContainer), onClick = navigateBack) {
            Text("GO BACK TO BOOK LIST")
        }
        Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Center) {
            Text(text = "BookAuthor", containerModifier)
            Text(book?.author ?: "",containerModifier )
        }
        Row(modifier = containerModifier) {
            Text("book name", containerModifier)
            Text(book?.title ?: "", containerModifier)
        }
        Row(modifier = containerModifier) {
            Text("book id", containerModifier)
            Text(book?.id.toString() ?: "", containerModifier)
        }

        repeat(3) {
            Text("addional book info to come : $it", containerModifier)
            Text("blabla $it", containerModifier)
        }
    }
}