package com.example.crud_222.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.crud_222.data.UserDatabase
import com.example.crud_222.repository.UserRepository
import com.example.crud_222.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel (application: Application): AndroidViewModel(application){
    val readAllData: LiveData<List<User>>
    private val repository : UserRepository

    init {
        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDAO)
        readAllData = repository.readAllData
    }

    fun addUser (user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

}