package com.example.crud_222.repository

import androidx.lifecycle.LiveData
import com.example.crud_222.data.UserDAO
import com.example.crud_222.model.User


class UserRepository(private val userDAO: UserDAO) {

    val readAllData: LiveData<List<User>> = userDAO.readAllData()

    suspend fun addUser(user: User){
        userDAO.addUser(user)
    }

    suspend fun deleteAllUsers() {
        userDAO.deleteAllUsers()
    }
}