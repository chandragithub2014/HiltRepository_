package com.hilt.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hilt.demo.util.replaceFragmentWithNoHistory
import com.hilt.demo.view.EmployeeFragment
import com.hilt.demo.view.EmployeeSwipeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_main)
        replaceFragmentWithNoHistory(EmployeeSwipeFragment(), R.id.container_fragment)

    }
}


