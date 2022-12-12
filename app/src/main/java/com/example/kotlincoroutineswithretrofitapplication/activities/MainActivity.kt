package com.example.kotlincoroutineswithretrofitapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutineswithretrofitapplication.*
import com.example.kotlincoroutineswithretrofitapplication.adapter.EmployeeAdapter
import com.example.kotlincoroutineswithretrofitapplication.viewModelFactories.MyViewModelFactory
import com.example.kotlincoroutineswithretrofitapplication.viewModels.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    @Inject
    lateinit var adapter: EmployeeAdapter
//    private val adapter = EmployeeAdapter()
    lateinit var again: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        again = findViewById(R.id.again)
        again.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            viewModel.getAllMovies()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

//        val retrofitService = RetrofitService.getInstance()
//        val mainRepository = EmployeeRepository(retrofitService)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.movieList.observe(this, {
            adapter.setEmployee(it.dataList!!)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()
    }
}