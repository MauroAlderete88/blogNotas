package data.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class pathImage(
        @PrimaryKey (autoGenerate = true)
        val id : Int,
        val nombreAnimal : String,
        val pathImagen : String
)