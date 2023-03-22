package cudia.jovic.lakbaybaliuag

import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cudia.jovic.lakbaybaliuag.ui.theme.Green
import cudia.jovic.lakbaybaliuag.ui.theme.LakbayBaliuagTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun Screen(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Surface(
        color = Green,
        modifier = modifier,
        onClick = onClick,
    ) {
        AnimatedContent(
            targetState = image,
            transitionSpec = {
                slideInHorizontally { height -> height } + fadeIn() with
                        slideOutHorizontally { height -> -height } + fadeOut()

            }
        ) { targetImage ->
            Image(
                painter = painterResource(id = targetImage),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    LakbayBaliuagTheme {
        Screen(image = R.drawable.artboard_1, modifier = Modifier.fillMaxSize())
    }
}