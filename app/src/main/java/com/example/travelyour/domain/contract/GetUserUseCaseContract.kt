package com.example.travelyour.domain.contract

import com.example.travelyour.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface GetUserUseCaseContract {
    operator fun invoke(): Flow<UserEntity>
}