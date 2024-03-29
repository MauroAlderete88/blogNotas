package data.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class listaDeListas(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombreLista: String,
    val pathImage: Int,
    val background_path_gradient: Int,
)