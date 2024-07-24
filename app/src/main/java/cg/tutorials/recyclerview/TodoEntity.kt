package cg.tutorials.recyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title :String?=null,
    var description :String?=""
)
