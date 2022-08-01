
package android.ptc.com.ptcflixing.navigation

import androidx.navigation.NavHostController

class RouterImpl(
    private val navHostController: NavHostController,
    private val startDestination: String = ROUTE_SEARCH
) : Router {

    override fun goDetails(arg: Any?) {
        navigate(Screen.Details)
    }
    override fun goResults(arg: Any?) {
        navigate(Screen.Search)
    }

    override fun goSearch() {
        navigate(Screen.Search, removeFromHistory = true, singleTop = true)
    }

    override fun goBack() {
        navHostController.apply {
            navigateUp()
            navigate(startDestination) {
                launchSingleTop = true
                restoreState = true
            }
        }
    }



    override fun goSplash() {
        navigate(Screen.Splash, true)
    }


    private fun navigate(
        screen: Screen,
        removeFromHistory: Boolean = false,
        singleTop: Boolean = false
    ) {
        navHostController.apply {
            navigate(screen.route) {
                if (removeFromHistory) {
                    if (singleTop) {
                        popUpTo(Screen.Search.route)
                    } else {
                        popUpTo(0) {
                            saveState = false
                        }
                    }

                } else {
                    restoreState = true
                }
                launchSingleTop = singleTop
            }
        }
    }


}