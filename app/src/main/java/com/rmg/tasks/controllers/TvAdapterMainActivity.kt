package com.rmg.tasks.controllers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmg.tasks.R
import com.rmg.tasks.dtos.response.TaskResponseDto
import com.rmg.tasks.utils.GlobalVariables
import com.rmg.tasks.views.DetailsActivity

class TvAdapterMainActivity: RecyclerView.Adapter<TvAdapterMainActivity.TaskItemHolder> {
    class TaskItemHolder internal constructor(view: View) :
        RecyclerView.ViewHolder(view) {

        var textViewTaskItemTitle: TextView =
            view.findViewById(R.id.textViewTaskItemTitle)
        var textViewTaskItemCompleted: TextView = view.findViewById(R.id.textViewTaskItemCompleted)
        var buttonRecordItemDetails: Button = view.findViewById(R.id.buttonTaskItemDetails)

    }

    private var tasksList: ArrayList<TaskResponseDto>

    constructor(tasksList: ArrayList<TaskResponseDto>) : super() {
        this.tasksList = tasksList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)

        return TaskItemHolder(view)
    }

    override fun onBindViewHolder(holder: TaskItemHolder, position: Int) {

        var globalVariables = GlobalVariables.instance

        var task = tasksList[position]

        holder.textViewTaskItemTitle.text = task.title
        holder.textViewTaskItemCompleted.text = task.completed.toString()

        holder.buttonRecordItemDetails.setOnClickListener {
            globalVariables.currentTask = task

            var intent = Intent(globalVariables.applicationContext, DetailsActivity::class.java)
            globalVariables.applicationContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }
}