package com.example.travelyour.domain.usecase

import com.example.travelyour.domain.UserPreferenceRepository
import com.example.travelyour.domain.contract.GetUserUseCaseContract
import com.example.travelyour.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class GetUserUseCase (private val userPreferenceRepository: UserPreferenceRepository):
 GetUserUseCaseContract{

    override fun invoke(): Flow<UserEntity> = userPreferenceRepository.userData

}