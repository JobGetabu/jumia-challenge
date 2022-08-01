package android.ptc.com.ptcflixing.model.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Rating(
    @SerialName("average")
    val average: Int,
    @SerialName("ratings_total")
    val ratingsTotal: Int
)