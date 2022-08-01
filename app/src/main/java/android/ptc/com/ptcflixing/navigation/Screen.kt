package android.ptc.com.ptcflixing.navigation


const val SEARCH_ARGUMENT_KEY = "search";
const val SKU_ARGUMENT_KEY = "sku";
const val ROUTE_SPLASH = "splash_screen"
const val ROUTE_SEARCH = "search_screen"
const val ROUTE_RESULTS = "result_screen"
const val ROUTE_DETAILS = "details_screen"

sealed class Screen(
    val route: String)
{
    object Splash: Screen(route = ROUTE_SPLASH)
    object Search: Screen(route = ROUTE_SEARCH)
    object Results: Screen(route = "$ROUTE_RESULTS/{$SEARCH_ARGUMENT_KEY}"){
        fun searchQuery(search: String): String{
            return this.route.replace(oldValue = "{$SEARCH_ARGUMENT_KEY}", newValue = search)
        }
    }
    object Details: Screen("$ROUTE_DETAILS/{$SKU_ARGUMENT_KEY}"){
        fun skuQuery(sku: String): String{
            return this.route.replace(oldValue = "{$SKU_ARGUMENT_KEY}", newValue = sku)
        }
    }
}
