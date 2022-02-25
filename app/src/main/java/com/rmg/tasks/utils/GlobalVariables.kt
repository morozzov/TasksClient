package com.rmg.tasks.utils

import android.content.Context
import com.rmg.tasks.dtos.response.TaskResponseDto

class GlobalVariables {
    companion object {
        val instance = GlobalVariables()
    }

    lateinit var applicationContext: Context
    lateinit var httpWorker: HttpWorker
    lateinit var currentTask: TaskResponseDto
}