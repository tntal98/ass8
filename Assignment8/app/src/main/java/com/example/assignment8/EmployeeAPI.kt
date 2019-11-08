package com.example.assignment8

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface EmployeeAPI {
    @GET("allemp")
    fun retrieveStudent(): Call<List<Employee>>

    @FormUrlEncoded
    @POST("emp")
    fun insertStd(
        @Field("emp_name") emp_name :String,
        @Field("emp_gender") emp_gender :String,
        @Field("emp_email") emp_email :String,
        @Field("emp_salary") emp_salary :Int) : Call<Employee>
}