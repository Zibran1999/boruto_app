package com.zibran.brutoapp.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zibran.brutoapp.presentation.common.ListContent
import com.zibran.brutoapp.ui.theme.statusBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery = searchViewModel.searchQuery
    val searchHeroes = searchViewModel.searchHeroes.collectAsLazyPagingItems()
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.statusBarColor )

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery.value,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)

                },
                onClosedClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            ListContent(
                modifier = Modifier.padding(it),
                heroes = searchHeroes,
                navController = navController
            )

        }
    )

}