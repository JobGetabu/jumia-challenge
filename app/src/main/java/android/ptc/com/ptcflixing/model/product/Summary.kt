package android.ptc.com.ptcflixing.model.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Summary(
    @SerialName("description")
    val description: String,
    @SerialName("short_description")
    val shortDescription: String
)