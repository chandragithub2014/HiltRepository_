package com.hilt.demo.repository

import kotlinx.coroutines.Dispatchers

class CoroutineHelper {
    fun fetchCoroutineDispatcher()  = Dispatchers.IO
}