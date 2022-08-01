package android.ptc.com.ptcflixing.model.configurations

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(

    @Embedded
    val currency: Currency,
    @Embedded
    val support: Support
)