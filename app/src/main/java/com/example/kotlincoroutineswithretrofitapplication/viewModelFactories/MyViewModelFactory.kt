package com.example.kotlincoroutineswithretrofitapplication.viewModelFactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutineswithretrofitapplication.repositories.EmployeeRepository
import com.example.kotlincoroutineswithretrofitapplication.viewModels.MainViewModel
import javax.inject.Inject

class MyViewModelFactory constructor(private val repository: EmployeeRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}