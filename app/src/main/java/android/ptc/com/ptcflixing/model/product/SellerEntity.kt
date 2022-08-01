package android.ptc.com.ptcflixing.model.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SellerEntity(
    @SerialName("delivery_time")
    val deliveryTime: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)