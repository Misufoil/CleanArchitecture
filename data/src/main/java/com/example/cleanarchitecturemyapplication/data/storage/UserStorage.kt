package com.example.cleanarchitecturemyapplication.data.storage

import com.example.cleanarchitecturemyapplication.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}