package android.ptc.com.ptcflixing.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    @SerialName("results")
    val results: List<Result>,
    @SerialName("sort")
    val sort: String,
    @SerialName("title")
    val title: String,
    @SerialName("total_products")
    val totalProducts: Int
)