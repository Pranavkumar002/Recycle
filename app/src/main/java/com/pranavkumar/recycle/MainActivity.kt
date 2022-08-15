package com.pranavkumar.recycle

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pranavkumar.recycle.databinding.ActivityMainBinding
import com.pranavkumar.recycle.databinding.ItemAddDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerClass
    lateinit var LinearLayoutManager: LinearLayoutManager
    var array :ArrayList<StudentInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RecyclerClass(array)
        LinearLayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = LinearLayoutManager
        binding.recycler.adapter = adapter
        array.add(StudentInfo(1,"Pranav","0123456987"))
        array.add(StudentInfo(2,"Subal","01234655587"))
        array.add(StudentInfo(3,"Ayush","012345852987"))


        binding.fabAdd.setOnClickListener {
            var dialogBinding = ItemAddDialogBinding.inflate(layoutInflater)
            var dialog = Dialog(requireContext())
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etEnterid.text.toString().isNullOrEmpty()) {
                    dialogBinding.etEnterid.setError("Enter ID")
                }
                else if (dialogBinding.etEntername.text.toString().isNullOrEmpty())
                    dialogBinding.etEntername.setError("Enter Name")
                else if (dialogBinding.etEnterphone.text.toString().isNullOrEmpty())
                    dialogBinding.etEnterphone.setError("Enter Phone")
                else
                {

                    dialog.dismiss()
                }

            }
            dialog.show()
        }


    }


}