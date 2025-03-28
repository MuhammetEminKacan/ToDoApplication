package com.mek.todoapplication.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mek.todoapplication.di.Repository
import com.mek.todoapplication.model.Priority
import com.mek.todoapplication.model.ToDoModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application : Application,private val repository : Repository
) : AndroidViewModel(application){

    val toDoList = repository.localdatasource.getAllToDo().asLiveData()

    fun updateToDo(toDoModel : ToDoModel){
        val updatedModel = toDoModel.copy(isChecked = toDoModel.isChecked?.not())
        viewModelScope.launch {
            repository.localdatasource.updateToDo(updatedModel)
        }
    }
}