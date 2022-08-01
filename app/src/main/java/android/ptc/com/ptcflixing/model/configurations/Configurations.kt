package android.ptc.com.ptcflixing.model.configurations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.ptc.com.ptcflixing.util.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = Constants.CONFIGURATIONS_TABLE)
@Serializable
data class Configurations(

    @PrimaryKey(autoGenerate = true)
    var iid: Int? = null,
    @SerialName("success")
    var success: Boolean,
    @Embedded
    var session: Session,
    @Embedded
    var metadata: Metadata
)
