package com.example.kotlincoroutineswithretrofitapplication.interfaces

import com.example.kotlincoroutineswithretrofitapplication.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/v1/employees")
    suspend fun getEmployee(): Response<DataModel>
}