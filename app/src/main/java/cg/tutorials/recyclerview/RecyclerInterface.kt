package cg.tutorials.recyclerview

import android.widget.TextView

interface RecyclerInterface {
    fun update(position:Int)
    fun delete(position: Int)
}