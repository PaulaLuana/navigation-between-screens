package com.example.navigation.dao

import com.example.navigation.model.User

class UserDAO {
    fun new_user_id(): Int {
        val len = userList.size
        return len+1
    }

    fun add(user: User){
        userList.add(user)
    }

    fun myUsers(): MutableList<User> {
        return userList
    }

    fun emailExists(email: String): Boolean {
        for (user in userList){
            if (user.email == email){
                return true
            }
        }
        return false
    }

    fun validId(id: Int): Boolean {
        for (user in userList){
            if(user.id == id){
                return true
            }
        }
        return false
    }

    fun getUser(id: Int): User? {
        for(user in userList){
            if (user.id == id){
                return user
            }
        }
        return null
    }

    fun alterUser(id: Int, name: String, email: String){
        for(user in userList){
            if (user.id == id){
                user.nome = name
                user.email = email
            }
        }
    }
    companion object {
        val userList: MutableList<User> = mutableListOf()
    }
}