package com.example.kotlincoroutineswithretrofitapplication.repositories

import com.example.kotlincoroutineswithretrofitapplication.interfaces.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class EmployeeRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getAllMovies() = apiInterface.getEmployee()
}