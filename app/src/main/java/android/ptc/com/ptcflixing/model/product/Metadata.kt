package android.ptc.com.ptcflixing.model.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Metadata(
    @SerialName("brand")
    val brand: String,
    @SerialName("image_list")
    val imageList: List<String>,
    @SerialName("max_saving_percentage")
    val maxSavingPercentage: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    val rating: Rating,
    @SerialName("seller_entity")
    val sellerEntity: SellerEntity,
    @SerialName("sku")
    val sku: String,
    @SerialName("special_price")
    val specialPrice: Int,
    val summary: Summary
)