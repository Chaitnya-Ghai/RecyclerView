package cg.tutorials.recyclerview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1, exportSchema = true)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun todoInterface():TodoInterface


//    we have static members and functions of the class
    companion object{
        private var todoDatabase:TodoDatabase?=null

    fun getInstance(context: Context):TodoDatabase{
     if (todoDatabase == null){
         todoDatabase = Room.databaseBuilder(context,
             TodoDatabase::class.java,
             "TodoDatabase")
             .allowMainThreadQueries()
             .build()
     }
        return todoDatabase!!
    }
    }
}