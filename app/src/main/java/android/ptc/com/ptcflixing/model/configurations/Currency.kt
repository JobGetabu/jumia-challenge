package android.ptc.com.ptcflixing.model.configurations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    @SerialName("iso")
    val iso: String,
    @SerialName("currency_symbol")
    val currencySymbol: String,
    @SerialName("position")
    val position: Int,
    @SerialName("decimals")
    val decimals: Int,
    @SerialName("thousands_sep")
    val thousandsSep: String,
    @SerialName("decimals_sep")
    val decimalsSep: String
)