package cg.tutorials.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private val TAG = "RecyclerAdapter"
class RecyclerAdapter(private var data: Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: $data")
        return data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    // Method to update data
    fun updateData(newData: Int) {
        data = newData
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}
