package android.ptc.com.ptcflixing.model.configurations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Language(
    @SerialName("code")
    val code: String,
    @SerialName("name")
    val name: String,
    @SerialName("default")
    val default: Boolean

)