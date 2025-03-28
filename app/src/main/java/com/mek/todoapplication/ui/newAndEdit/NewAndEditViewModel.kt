package com.mek.todoapplication.ui.newAndEdit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mek.todoapplication.di.Repository
import com.mek.todoapplication.model.Priority
import com.mek.todoapplication.model.ToDoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewAndEditViewModel @Inject constructor(application: Application,
                          private val repository: Repository)
    : AndroidViewModel(application)
{

         val toDoModel = MutableLiveData<ToDoModel>()


        fun insertToDo(title : String,description : String,isCheck : Boolean,priority: Priority){
            viewModelScope.launch {
                repository.localdatasource.insertToDo(todoModel = ToDoModel(
                    title = title,
                    description = description,
                    isChecked = isCheck,
                    priority = priority
                ))
            }
        }

        fun getToDo(ToDoId : Int){
            viewModelScope.launch {
                val ToDo = repository.localdatasource.getToDo(ToDoId)
                toDoModel.value = ToDo
            }
        }

    fun updateToDo(title : String,description : String,isCheck : Boolean,priority: Priority){
        viewModelScope.launch {
            repository.localdatasource.updateToDo(todoModel = ToDoModel(
                id = toDoModel.value?.id ?: 0,
                title = title,
                description = description,
                isChecked = isCheck,
                priority = priority
            ))
        }
    }

    fun deleteToDo(){
        viewModelScope.launch {
            toDoModel.value?.let {
                repository.localdatasource.deleteToDo(it)
            }
        }
    }
}