package com.zibran.brutoapp.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zibran.brutoapp.R
import com.zibran.brutoapp.ui.theme.topAppBarBackgroundColor
import com.zibran.brutoapp.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSearchClicked: ()->Unit) {
    TopAppBar(
        title = {
            Text(text = "Explore", color = MaterialTheme.colorScheme.topAppBarContentColor)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor),
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = stringResource(R.string.search_icon))
            }
        }
    )
}


@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun HomeTopBarPreviewLight(){
    HomeTopBar {

    }
}