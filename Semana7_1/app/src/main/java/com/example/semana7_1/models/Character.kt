package models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "characters"
)
class Character(
    @PrimaryKey
    @SerializedName("id")
    var id: Int=0,

    @SerializedName("name")
    var name: String,

    @SerializedName("img")
    var img: String,

    @SerializedName("birth_year")
    var birth_year: String,

    @SerializedName("gender")
    var gender: String
    ): Serializable

