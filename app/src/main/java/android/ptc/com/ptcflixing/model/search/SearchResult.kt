package android.ptc.com.ptcflixing.model.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("metadata")
    val metadata: Metadata,
    @SerialName("success")
    val success: Boolean

)