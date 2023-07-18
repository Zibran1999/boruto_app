package com.zibran.brutoapp.presentation.screens.welocome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.zibran.brutoapp.R
import com.zibran.brutoapp.domain.model.OnBoardingPage
import com.zibran.brutoapp.navigation.Screen
import com.zibran.brutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.zibran.brutoapp.ui.theme.PAGING_INDICATOR_SPACING
import com.zibran.brutoapp.ui.theme.PAGING_INDICATOR_WITH
import com.zibran.brutoapp.ui.theme.SMALL_PADDING
import com.zibran.brutoapp.ui.theme.activeIndicatorColor
import com.zibran.brutoapp.ui.theme.buttonColor
import com.zibran.brutoapp.ui.theme.descriptionColor
import com.zibran.brutoapp.ui.theme.inActiveIndicatorColor
import com.zibran.brutoapp.ui.theme.titleColor
import com.zibran.brutoapp.ui.theme.welcomeScreenBackgroundColor
import com.zibran.brutoapp.utils.Constants.LAST_ON_BOARDING_PAGE
import com.zibran.brutoapp.utils.Constants.ON_BOARDING_COUNT_PAGE

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navHostController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(pageCount = { ON_BOARDING_COUNT_PAGE })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(10f),
            state = pagerState,
            pageSpacing = 0.dp,
            userScrollEnabled = true,
            reverseLayout = false,
            contentPadding = PaddingValues(0.dp),
            beyondBoundsPageCount = 0,
            pageSize = PageSize.Fill,
            flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
            key = null,
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                Orientation.Horizontal
            ),
            pageContent = { page ->
                PagerScreen(onBoardingPage = pages[page])
            }
        )
        HorizontalIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pages = pages,
            pagerState = pagerState,
            activeColor = MaterialTheme.colorScheme.activeIndicatorColor,
            inActiveColor = MaterialTheme.colorScheme.inActiveIndicatorColor,
            indicatorWith = PAGING_INDICATOR_WITH,
            indicatorSpacing = PAGING_INDICATOR_SPACING
        )

        FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(true)
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(modifier: Modifier = Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.buttonColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }

    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.onboarding_image)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING),
            text = onBoardingPage.title,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.titleColor,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colorScheme.descriptionColor,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalIndicator(
    modifier: Modifier = Modifier,
    pages: List<OnBoardingPage>,
    pagerState: PagerState,
    activeColor: Color,
    inActiveColor: Color,
    indicatorWith: Dp,
    indicatorSpacing: Dp
) {
    Row(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pages.size) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) activeColor else inActiveColor
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(indicatorWith)

            )
            Spacer(modifier = Modifier.width(indicatorSpacing))
        }
    }

}

@Composable
@Preview
fun FirstOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Composable
@Preview
fun SecondOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Composable
@Preview
fun ThirdOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}