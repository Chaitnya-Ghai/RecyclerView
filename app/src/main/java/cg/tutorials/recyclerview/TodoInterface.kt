package cg.tutorials.recyclerview

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TodoInterface {

    @Insert
    fun insertTodo(todoEntity: TodoEntity)
}