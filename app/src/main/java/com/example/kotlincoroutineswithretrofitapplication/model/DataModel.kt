package com.example.kotlincoroutineswithretrofitapplication.model

import com.google.gson.annotations.SerializedName

class DataModel{

    @SerializedName("status")
    var status: String? = null
    @SerializedName("data")
    var dataList: List<Data>? = null
    @SerializedName("message")
    var message : String? = null

    class Data{
        @SerializedName("id")
        var id = 0
        @SerializedName("employee_name")
        var employee_name: String? = null
        @SerializedName("employee_salary")
        var employee_salary = 0
        @SerializedName("employee_age")
        var employee_age = 0
        @SerializedName("profile_image")
        var profile_image: String? = null

    }
}
