package com.example.cleanarchitecturemyapplication.domain.usecase

import com.example.cleanarchitecturemyapplication.domain.models.UserName
import com.example.cleanarchitecturemyapplication.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}