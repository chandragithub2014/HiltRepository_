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
        someEmptyFunc()

    }

    private fun  someEmptyFunc(){
        println("SonarQube Info")
        println("http://androidhubb.blogspot.com/2019/04/sonarqube-android-how-to-use-sonarqube.html")
        println("gradlew sonarqube  -Dsonar.host.url=http://localhost:9000/")
        println("https://rules.sonarsource.com/kotlin")
        println("http://localhost:9000/profiles")
        println("Detekt......")
        println("https://medium.com/@heri.sulis/integrating-kotlin-detekt-cli-on-android-gradle-task-a02ca0378dcc")
        println("https://medium.com/@abdullahbalta/improving-kotlin-quality-fc59df802ba8")
        println("gradlew check")
    }

    private fun empty(){

    }


    private fun anotherEmpty(){

    }


}


