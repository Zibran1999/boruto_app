package com.zibran.brutoapp.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zibran.brutoapp.ui.theme.SMALL_PADDING
import com.zibran.brutoapp.ui.theme.titleColor

@Composable
fun OrderedList(
    title: String, items: List<String>, textColor: Color
) {

    Column() {

        Text(
            modifier = Modifier.padding(bottom = SMALL_PADDING),
            text = title,
            color = textColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
        items.forEachIndexed { index, item ->
            Text(
                modifier = Modifier.alpha(0.5f),
                text = "${index + 1}. $item",
                color = textColor,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OrderListPreview() {
    OrderedList(
        title = "Family",
        items = listOf("Minato", "Kushito"),
        textColor = MaterialTheme.colorScheme.titleColor
    )

}
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OrderListDarkPreview() {
    OrderedList(
        title = "Family",
        items = listOf("Minato", "Kushito"),
        textColor = MaterialTheme.colorScheme.titleColor
    )

}