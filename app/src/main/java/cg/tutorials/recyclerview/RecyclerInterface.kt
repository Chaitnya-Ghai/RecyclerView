package cg.tutorials.recyclerview

import android.widget.TextView

interface RecyclerInterface {
    fun update(position:Int,view: TextView)
    fun delete(position: Int)
}