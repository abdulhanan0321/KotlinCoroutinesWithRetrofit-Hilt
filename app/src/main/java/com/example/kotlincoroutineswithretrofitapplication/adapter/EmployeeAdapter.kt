package com.example.kotlincoroutineswithretrofitapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutineswithretrofitapplication.R
import com.example.kotlincoroutineswithretrofitapplication.model.DataModel
import javax.inject.Inject

class EmployeeAdapter @Inject constructor() : RecyclerView.Adapter<EmployeeAdapter.MainViewHolder>() {


    var employeeList = mutableListOf<DataModel.Data>()

    fun setEmployee(movies: List<DataModel.Data>) {
        this.employeeList = movies.toMutableList()
        notifyItemInserted(employeeList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list_view, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val employee = employeeList[position]
        holder.name.text = employee.employee_name
    }

    override fun getItemCount() = employeeList.size

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
    }
}