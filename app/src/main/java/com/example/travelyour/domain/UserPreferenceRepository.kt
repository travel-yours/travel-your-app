package com.example.travelyour.domain

import com.example.travelyour.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserPreferenceRepository {
    val userData: Flow<UserEntity>

    suspend fun saveUser(userEntity: UserEntity)

    suspend fun clearUser()
    val isLoggedIn: Flow<Boolean>
}