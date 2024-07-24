package cg.tutorials.recyclerview

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import cg.tutorials.recyclerview.databinding.ActivityMainBinding
import cg.tutorials.recyclerview.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity(), RecyclerInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var todoDatabase: TodoDatabase
    var array = arrayListOf<TodoEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerAdapter = RecyclerAdapter(this,array, this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        todoDatabase = TodoDatabase.getInstance(this)
        binding.faBtn.setOnClickListener {
            todoDatabase.todoInterface().insertTodo(TodoEntity(title = "Test",
                description = "test"))
//            array.add("four")
            recyclerAdapter.notifyDataSetChanged()
        }
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = recyclerAdapter
    }

    override fun update(position: Int) {
        var dialogViewBinding = CustomDialogBinding.inflate(layoutInflater)
        var dialog = Dialog(this).apply {
            setContentView(dialogViewBinding.root)
            setCancelable(false)
            window?.setLayout(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )
            show()
        }
        dialogViewBinding.okBtn.setOnClickListener {
            if (dialogViewBinding.edName.text.isEmpty()){
                dialogViewBinding.edName.error ="Enter Valid Name"
            }
            else{
                array[position].title=dialogViewBinding.edName.text.toString()
                recyclerAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
    }

    override fun delete(position: Int) {
         AlertDialog.Builder(this).apply {
            setTitle("delete dialog")
            setCancelable(false)
            setNegativeButton("No"){_,_ ->
                setCancelable(true)
            }
            setPositiveButton("Yes"){_,_->
                array.removeAt(position)
                recyclerAdapter.notifyDataSetChanged()
                setCancelable(true)
            }
            show()
        }
    }
}

