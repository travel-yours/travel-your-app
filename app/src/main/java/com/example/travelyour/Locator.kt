package com.example.travelyour

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.travelyour.data.repository.AuthRepositoryImpl
import com.example.travelyour.data.repository.UserPreferenceImpl
import com.example.travelyour.data.source.network.RetrofitBuilder
import com.example.travelyour.domain.AuthRepository
import com.example.travelyour.domain.UserPreferenceRepository
import com.example.travelyour.domain.usecase.GetUserUseCase
import com.example.travelyour.domain.usecase.SignInUseCase
import com.example.travelyour.domain.usecase.SignUpUseCase
import com.example.travelyour.presentation.auth.signin.SignInViewModel
import com.example.travelyour.presentation.auth.signup.SignUpViewModel
import com.example.travelyour.presentation.homepage.artikel.ArtikelViewModel
import com.example.travelyour.presentation.splash.SplashViewModel

object Locator {

    private var application: Application?= null

    private inline val requireApplication
    get() = application ?: error("Missing call: initWith(application")

    fun initWith(application: Application){
        this.application = application

    }
    // Data Store
    private val Context.dataStore by preferencesDataStore(name = "user_preferences")

    //ViewModelFactory
    val signUpViewModelFactory
        get() = SignUpViewModel.Factory(
            signUpUseCase = signUpUseCase
        )
    val signInViewModelFactory
    get() = SignInViewModel.Factory(
        signInUseCase = signInUseCase
    )
    val splashViewModelFactory
    get() = SplashViewModel.Factory(
        getUserUseCase = getUserUseCase
    )

    //UseCaseInjection
    private val signUpUseCase get() = SignUpUseCase(authRepository)
    private val signInUseCase get() = SignInUseCase(userPreferenceRepository, authRepository)
    private val getUserUseCase get() = GetUserUseCase(userPreferenceRepository)

    //Repository Injection
    private val authRepository by lazy {
        AuthRepositoryImpl(RetrofitBuilder(requireApplication.dataStore).apiservice)
    }

    private val userPreferenceRepository by lazy {
        UserPreferenceImpl(requireApplication.dataStore)
    }
}