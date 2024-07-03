package cg.tutorials.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var array: ArrayList<String>, val recyclerInterface: RecyclerInterface) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val TAG = "RecyclerAdapter"

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvNo : TextView = view.findViewById(R.id.tvFirst)
        var icon : ImageButton = view.findViewById(R.id.icon)
        var btn : Button = view.findViewById(R.id.btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: $")
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNo.text =(array[position])
        holder.icon.setOnClickListener{
            recyclerInterface.delete(position)
        }
        holder.btn.setOnClickListener {
            recyclerInterface.update(position,holder.tvNo)
        }
    }
}
