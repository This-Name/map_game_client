package com.project.mapgames.ui.game

import android.app.Application
import android.content.Context
import android.location.Location
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.here.sdk.core.GeoCoordinates
import com.project.mapgames.model.PlatformPositioningProvider
import com.project.mapgames.model.PlatformPositioningProvider.PlatformLocationListener
import com.project.mapgames.model.Repository
import com.project.mapgames.model.dataGame.Task
import java.util.*
import kotlin.collections.ArrayList


class GameViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var taskList: ArrayList<Task>
    var data: Task? = null

    fun setTaskList(list: ArrayList<Task>) {
        taskList = list
    }

    fun getNextTask(id: Int?): Task? {
        var test: Task? = Task()
        if (id == null && data == null) {
            test = taskList.first()
            data = test
            taskList.remove(test)
        } else if(taskList.size > 0){
            taskList.forEach {
                if (it.id == id) {
                    test = it
                }
            }
            data = test
            taskList.remove(test)
        }
        if(checkNotNull(test) == Task()){
            test = null
        }
        return test
    }
    suspend fun completeTask(codeGame: String, userName: String){
        Repository().completeTask(codeGame, userName)
    }
}
