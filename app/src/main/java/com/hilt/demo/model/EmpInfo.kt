package com.hilt.demo.model

data class EmpInfo (
    val status: String,
    val data: List<Data>

)
data class Data(
    val id: String,
    val employee_name: String,
    val employee_salary: String,
    val employee_age: String,
    val profile_image: String

) 

