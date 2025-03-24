package com.mek.todoapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mek.todoapplication.model.ToDoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM to_do_table")
    fun getAllToDo() : Flow<List<ToDoModel>>

    @Query("SELECT * FROM to_do_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchToDo(searchQuery : String) : Flow<List<ToDoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(todoModel: ToDoModel)

    @Update
    suspend fun updateToDo(todoModel : ToDoModel)

    @Query("SELECT * FROM to_do_table WHERE id = :todoId")
    suspend fun getToDo(todoId : Int) : ToDoModel

    @Delete
    suspend fun deleteToDo(todoModel: ToDoModel)
}