package com.example.travelyour.data.di

import com.example.travelyour.data.repository.ArtikelRepository

object Injection {
    fun provideRepository(): ArtikelRepository{
        return ArtikelRepository.getInstance()
    }
}