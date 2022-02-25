package com.rmg.tasks.controllers

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.rmg.tasks.R
import com.rmg.tasks.apiworkers.TasksApiWorker
import com.rmg.tasks.dtos.response.TasksListResponseDto
import com.rmg.tasks.utils.GlobalVariables
import com.rmg.tasks.views.MainActivity

class MainActivityController (
    private var mainActivity: MainActivity
) {
    private lateinit var tasksApiWorker: TasksApiWorker

    private lateinit var recyclerViewActivityMain: RecyclerView
    private lateinit var buttonActivityMainLoadTasksList: Button

    fun initialize(){
        tasksApiWorker = TasksApiWorker()

        recyclerViewActivityMain = mainActivity.findViewById(R.id.recyclerViewActivityMain)

        buttonActivityMainLoadTasksList =
            mainActivity.findViewById(R.id.buttonActivityMainLoadData)

        buttonActivityMainLoadTasksList.setOnClickListener {
            loadTasksList()
        }
    }

    fun loadTasksList(){
        tasksApiWorker.getAll(::updateTextViewData)
    }

    private fun updateTextViewData(data: String) {
        var tasksResponseDto = Gson().fromJson(data, TasksListResponseDto::class.java)

        recyclerViewActivityMain.layoutManager =
            LinearLayoutManager(mainActivity.applicationContext)

        recyclerViewActivityMain.adapter = TvAdapterMainActivity(tasksResponseDto.tasksList)
    }
}