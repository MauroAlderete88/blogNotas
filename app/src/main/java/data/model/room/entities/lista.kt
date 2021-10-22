package data.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class lista(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val nombre : String,
    val contenido : String,
    val pathImage : String,
    val backgroundFile : String,
    val pass : String,
    val lastDate : String
)