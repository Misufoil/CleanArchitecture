package com.example.cleanarchitecturemyapplication.data.repository

import com.example.cleanarchitecturemyapplication.data.storage.models.User
import com.example.cleanarchitecturemyapplication.data.storage.UserStorage
import com.example.cleanarchitecturemyapplication.domain.models.SaveUsernameParam
import com.example.cleanarchitecturemyapplication.domain.models.UserName
import com.example.cleanarchitecturemyapplication.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUsernameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
       return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUsernameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

}