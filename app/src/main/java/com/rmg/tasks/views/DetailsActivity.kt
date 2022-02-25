package com.rmg.tasks.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rmg.tasks.R
import com.rmg.tasks.controllers.DetailsActivityController

class DetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var detailsActivityController = DetailsActivityController(this)
        detailsActivityController.initialize()
    }
}