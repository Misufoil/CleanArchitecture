package com.example.cleanarchitecturemyapplication.domain.usecase

import com.example.cleanarchitecturemyapplication.domain.models.SaveUsernameParam
import com.example.cleanarchitecturemyapplication.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUsernameParam): Boolean{
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}