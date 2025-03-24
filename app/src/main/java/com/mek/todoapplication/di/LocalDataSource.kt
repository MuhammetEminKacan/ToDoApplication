package com.mek.todoapplication.di


import com.mek.todoapplication.data.ToDoDao
import com.mek.todoapplication.model.ToDoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource @Inject constructor(private val toDoDao : ToDoDao) {

    fun getAllToDo() : Flow<List<ToDoModel>>{
        return toDoDao.getAllToDo()
    }

    fun searchToDo(searchQuery : String) : Flow<List<ToDoModel>>{
        return toDoDao.searchToDo(searchQuery)
    }

    suspend fun insertToDo(todoModel: ToDoModel){
        toDoDao.insertToDo(todoModel)
    }

    suspend fun updateToDo(todoModel : ToDoModel){
        toDoDao.updateToDo(todoModel)
    }

    suspend fun getToDo(todoId : Int) : ToDoModel {
        return toDoDao.getToDo(todoId)
    }

    suspend fun deleteToDo(todoModel: ToDoModel){
        toDoDao.deleteToDo(todoModel)
    }
}