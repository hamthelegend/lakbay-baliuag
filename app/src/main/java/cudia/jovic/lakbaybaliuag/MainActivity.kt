package cudia.jovic.lakbaybaliuag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import cudia.jovic.lakbaybaliuag.ui.theme.Green
import cudia.jovic.lakbaybaliuag.ui.theme.LakbayBaliuagTheme

val screens = listOf(
    R.drawable.artboard_1,
    R.drawable.artboard_2,
    R.drawable.artboard_3,
    R.drawable.artboard_4,
    R.drawable.artboard_5,
    R.drawable.artboard_6,
    R.drawable.artboard_7,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(
                color = Green
            )

            LakbayBaliuagTheme {
                var screenIndex by rememberSaveable { mutableStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(
                        image = screens[screenIndex],
                        onClick = {
                            if (screenIndex < screens.lastIndex) {
                                screenIndex++
                            } else {
                                screenIndex = 0
                            }
                        }
                    )
                }
            }
        }
    }
}