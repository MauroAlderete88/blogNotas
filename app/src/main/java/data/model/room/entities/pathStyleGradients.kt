package data.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class pathStyleGradients (
        @PrimaryKey (autoGenerate = true)
        val id : Int,
        val pathStyleGradient :String
        )