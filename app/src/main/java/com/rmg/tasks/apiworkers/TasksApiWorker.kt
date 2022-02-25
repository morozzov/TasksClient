package com.rmg.tasks.apiworkers

import com.android.volley.Request
import com.rmg.tasks.utils.GlobalVariables

class TasksApiWorker {
    fun getById(id: Int, callbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://194.58.123.204:8090/tasks/getById/$id"
        val httpWorker = GlobalVariables.instance.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            callbackFunction
        )
    }

    fun getAll(callbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://194.58.123.204:8090/tasks/getAll"
        val httpWorker = GlobalVariables.instance.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            callbackFunction
        )
    }

    fun deleteById(id: Int, callbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.DELETE
        val url = "http://194.58.123.204:8090/tasks/deleteById/$id"
        val httpWorker = GlobalVariables.instance.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            callbackFunction
        )
    }
}