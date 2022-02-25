package com.rmg.tasks.dtos.response

class TaskResponseDto (
    var id: Int,
    var title: String,
    var completed: Boolean,
    var priority: Int,
    var unixDateTime: Long
) {
    fun convertToString(): String
    {
        return "Title = $title \n" +
                "Completed = $completed \n" +
                "Priority = $priority \n" +
                "UnixDateTime = $unixDateTime \n";
    }
}