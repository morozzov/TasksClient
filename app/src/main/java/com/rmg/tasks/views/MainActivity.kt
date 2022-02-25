package com.rmg.tasks.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rmg.tasks.R
import com.rmg.tasks.controllers.MainActivityController
import com.rmg.tasks.utils.GlobalVariables
import com.rmg.tasks.utils.HttpWorker

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityController: MainActivityController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var globalVariables = GlobalVariables.instance
        globalVariables.applicationContext = applicationContext
        globalVariables.httpWorker = HttpWorker(applicationContext)

        var mainActivityController = MainActivityController(this)
        mainActivityController.initialize()
    }

    override fun onStart() {
        super.onStart()
        mainActivityController.loadTasksList()
    }
}