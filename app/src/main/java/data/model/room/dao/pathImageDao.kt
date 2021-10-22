package data.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import data.model.room.entities.pathImage

@Dao
interface pathImageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pathImage: pathImage)

}