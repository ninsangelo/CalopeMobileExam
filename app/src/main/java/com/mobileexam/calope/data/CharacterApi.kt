package com.mobileexam.calope.network

import com.mobileexam.calope.data.CharacterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/"

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}

object CharacterApi {
    val retrofitService: CharacterApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }
}
