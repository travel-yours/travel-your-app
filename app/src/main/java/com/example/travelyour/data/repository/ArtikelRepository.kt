package com.example.travelyour.data.repository

import com.example.travelyour.data.response.Artikel
import com.example.travelyour.data.source.local.ArtikelDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class ArtikelRepository {
    private val artikel = mutableListOf<Artikel>()
    fun getAllArtikel(): Flow<List<Artikel>>{
        artikel.addAll(ArtikelDataSource.dummyArtikel)
        return flowOf(artikel)
    }

   companion object{
       @Volatile
       private var instance:ArtikelRepository? = null
       fun getInstance(): ArtikelRepository =
           instance ?: synchronized(this){
               ArtikelRepository().apply {
                   instance = this
               }
           }
   }
}

