package com.hilt.demo.di

import com.hilt.demo.model.EmpInfo
import com.hilt.demo.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPIService {


    @GET("todos")
    suspend fun  fetchEmps(): Response<List<PostModel>>
}