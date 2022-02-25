package com.rmg.tasks.controllers

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.rmg.tasks.R
import com.rmg.tasks.apiworkers.TasksApiWorker
import com.rmg.tasks.dtos.response.TaskResponseDto
import com.rmg.tasks.utils.GlobalVariables
import com.rmg.tasks.views.DetailsActivity
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivityController(private var detailsActivity: DetailsActivity) {
    private lateinit var tasksApiWorker: TasksApiWorker

    private lateinit var task: TaskResponseDto

    private lateinit var buttonActivityDetailsBack: Button
    private lateinit var textViewActivityDetailsTitle: TextView
    private lateinit var textViewActivityDetailsCompleted: TextView
    private lateinit var textViewActivityDetailsPriority: TextView
    private lateinit var textViewActivityDetailsDateTime: TextView
    private lateinit var buttonActivityDetailsDelete: Button


    fun initialize() {
        var globalVariables = GlobalVariables.instance

        tasksApiWorker = TasksApiWorker()


        task = globalVariables.currentTask

        textViewActivityDetailsTitle =
            detailsActivity.findViewById(R.id.textViewActivityDetailsTitle)
        textViewActivityDetailsCompleted =
            detailsActivity.findViewById(R.id.textViewActivityDetailsCompleted)
        textViewActivityDetailsPriority = detailsActivity.findViewById(R.id.textViewActivityDetailsPriority)
        textViewActivityDetailsDateTime =
            detailsActivity.findViewById(R.id.textViewActivityDetailsDateTime)

        buttonActivityDetailsBack = detailsActivity.findViewById(R.id.buttonActivityDetailsBack)
        buttonActivityDetailsDelete = detailsActivity.findViewById(R.id.buttonActivityDetailsDelete)

        textViewActivityDetailsTitle.text = task.title
        textViewActivityDetailsCompleted.text = task.completed.toString()
        textViewActivityDetailsPriority.text = task.priority.toString()

        val dateFormatter = SimpleDateFormat("dd.MM.yyyy")
        val date = Date(task.unixDateTime)

        textViewActivityDetailsDateTime.text = dateFormatter.format(date)

        buttonActivityDetailsBack.setOnClickListener {
            detailsActivity.finish()
        }

        buttonActivityDetailsDelete.setOnClickListener {
            tasksApiWorker.deleteById(task.id) {
                Toast.makeText(
                    globalVariables.applicationContext,
                    "Delete success",
                    Toast.LENGTH_LONG
                ).show()

                //detailsActivity.finish()
            }
        }
    }
}