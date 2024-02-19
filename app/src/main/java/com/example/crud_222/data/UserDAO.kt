package com.example.crud_222.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.crud_222.model.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query( value = "SELECT * FROM `user-table` ORDER BY id ASC" )
    fun readAllData(): LiveData<List<User>>

}