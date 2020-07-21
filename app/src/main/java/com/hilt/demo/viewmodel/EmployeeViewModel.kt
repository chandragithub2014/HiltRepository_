package com.hilt.demo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hilt.demo.model.Data
import com.hilt.demo.model.EmpInfo
import com.hilt.demo.model.PostModel
import com.hilt.demo.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel @ViewModelInject constructor(private val networkRepository: NetworkRepository) :
    ViewModel(),LifecycleObserver {

    var loading : MutableLiveData<Boolean> = MutableLiveData()
    private val errorOnAPI = MutableLiveData<String>()
    var empListMutableLiveData  = MutableLiveData<List<PostModel>>()


      fun fetchEmpInfo() {

          viewModelScope.launch(Dispatchers.IO) {
              try{
                  val response = networkRepository.fetchEmps()
                  if(response.isSuccessful){
                      empListMutableLiveData.postValue(response.body())
                      loading.postValue(false)
                  }else{
                      loading.postValue(false)
                      errorOnAPI.postValue("Something went wrong::${response.message()}")
                  }
              }catch (e : Exception){
                  e.printStackTrace()
                  loading.postValue(false)
                  errorOnAPI.postValue("Something went wrong::${e.localizedMessage}")

              }
          }
      }

    fun fetchError(): LiveData<String> = errorOnAPI
    fun fetchLoadStatus(): LiveData<Boolean> = loading
    fun fetchUsersLiveData(): LiveData<List<PostModel>> = empListMutableLiveData



}