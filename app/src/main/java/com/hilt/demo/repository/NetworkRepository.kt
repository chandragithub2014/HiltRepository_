package com.hilt.demo.repository

import com.hilt.demo.di.NetworkAPIService
import com.hilt.demo.model.PostModel
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: NetworkAPIService){

    suspend fun fetchEmps(): Response<List<PostModel>> = apiService.fetchEmps()

}
