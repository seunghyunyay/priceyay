package com.baek.priceyay

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.baek.priceyay.ui.PriceYayApp
import com.baek.priceyay.ui.navigation.PriceYayDestination
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PriceYayNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // TestNavHostController 인스턴스를 참조하여 앱이 이동 작업을 실행할 때 탐색 호스트의 탐색 경로를 확인해야 합니다.
    private lateinit var navController: TestNavHostController

    // UI 테스트에 사용할 컴포저블 지정
    @Before
    fun setupCupcakeNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            PriceYayApp(navController)
        }
    }

    @Test
    fun priceYayNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(PriceYayDestination.HomeDestination.route)
    }

    // thingUnderTest_TriggerOfTest_ResultOfTest.
    // PriceYayNavHost를 테스트하는 것이며 바텀앱바의 서치아이콘을 클릭하면 서치화면으로 이동할 것이다.
    @Test
    fun priceYayNavHost_clickSearchBottomIcon_navigatesToSearchScreen() {
        composeTestRule.onNodeWithContentDescription(PriceYayDestination.SearchDestination.route).performClick()
        navController.assertCurrentRouteName(PriceYayDestination.SearchDestination.route)
    }

    @Test
    fun priceYayNavHost_clickBookmarkBottomIcon_navigatesToBookmarkScreen() {
        composeTestRule.onNodeWithContentDescription(PriceYayDestination.BookmarkDestination.route).performClick()
        navController.assertCurrentRouteName(PriceYayDestination.BookmarkDestination.route)
    }
}

// 문자열 리소스로 UI 구성요소를 찾을 때 작성하는 코드의 양을 줄일 수 있습니다.
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}

