package com.example.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.dao.UserDAO
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.model.User

class MainActivity : AppCompatActivity() {
    private var userDAO = UserDAO()
    private lateinit var users: MutableList<User>
    private lateinit var itemList: RecyclerView

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners(binding.root)
    }

    private fun setUpListeners(view: View) {
        itemList = view.findViewById<RecyclerView>(R.id.listUsers)
        itemList.layoutManager = LinearLayoutManager(view.context)

        binding.addUserButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", userDAO.new_user_id().toString())
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.editButton.setOnClickListener {
            val id = binding.code.text.toString()
            val id_int = id.toInt()

            Toast.makeText(this, "meu id:" + id, Toast.LENGTH_SHORT).show()
            if(userDAO.validId(id_int)){
                val bundle = Bundle()
                bundle.putString("id", id)
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Id não existe", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateRecicleView(){
        users = userDAO.myUsers()
        itemList.adapter = UserAdapter(users)
        itemList.adapter!!.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()

        updateRecicleView()
    }
}