package android.ptc.com.ptcflixing.model.product
import android.ptc.com.ptcflixing.model.product.Metadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val metadata: Metadata? = null,
    @SerialName("success")
    val success: Boolean
)