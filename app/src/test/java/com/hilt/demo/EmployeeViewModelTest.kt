package com.hilt.demo
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hilt.demo.di.NetworkAPIService
import com.hilt.demo.model.PostModel
import com.hilt.demo.repository.NetworkRepository
import com.hilt.demo.viewmodel.EmployeeViewModel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class EmployeeViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var retrofit: Retrofit

    @Mock
    lateinit var apiService: NetworkAPIService

    @Mock
    lateinit var networkRepository: NetworkRepository

    lateinit var employeeViewModel: EmployeeViewModel

   lateinit var  response : Response<List<PostModel>>

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)

    }

    val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun `check employee viewmodel to fetch  data correctly`() = testDispatcher.runBlockingTest{
        var model = PostModel(1,1,"abcDeeee",true)
        var list =  arrayListOf<PostModel>()
        list.add(model)
        response = Response.success(list)
        networkRepository = NetworkRepository(apiService)
        employeeViewModel = EmployeeViewModel(testDispatcher,networkRepository)
        if (retrofit != null) {
             if(networkRepository!=null) {
                 Mockito.`when`(networkRepository.fetchEmps()).thenReturn(response)
             }
        }

        employeeViewModel.fetchEmpInfo()
        Assert.assertEquals(1,employeeViewModel.fetchUsersLiveData().value?.size)

    }
}