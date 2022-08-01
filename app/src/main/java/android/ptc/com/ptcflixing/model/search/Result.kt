package android.ptc.com.ptcflixing.model.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("brand")
    val brand: String,
    @SerialName("image")
    val image: String,
    @SerialName("max_saving_percentage")
    val maxSavingPercentage: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("sku")
    val sku: String,
    @SerialName("special_price")
    val specialPrice: Int,

    @SerialName("rating_average")
    val ratingAverage: Int? = 0,

)