package com.example.cleanarchitecturemyapplication.domain.repository

import com.example.cleanarchitecturemyapplication.domain.models.SaveUsernameParam
import com.example.cleanarchitecturemyapplication.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUsernameParam): Boolean

    fun getName(): UserName
}