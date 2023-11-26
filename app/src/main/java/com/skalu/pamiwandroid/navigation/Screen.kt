package com.skalu.pamiwandroid.navigation

sealed class Screen {
    data object BooksList : Screen()
    data object BookDetails: Screen()
}