package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.navigation.dao.UserDAO
import com.example.navigation.databinding.ActivityMain2Binding
import com.example.navigation.model.User

class MainActivity2 : AppCompatActivity() {
    private var userDAO = UserDAO()
    private lateinit var binding: ActivityMain2Binding
    private lateinit var name: EditText
    private lateinit var email: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("id")
        Toast.makeText(this, "novo id é:" + userId, Toast.LENGTH_SHORT).show()
        setUpViews()
        if (userId != null) {
            setUpListeners(userId.toInt())
        }
    }

    private fun setUpViews(){
        name = binding.editName
        email = binding.editEmail
    }

    private fun setUpListeners(userId: Int) {
        val user = userDAO.getUser(userId)
        if (user != null){
            binding.title.setText("Alterar usuário")
            binding.registerButton.setText("alterar")
            name.setText(user?.nome)
            email.setText(user?.email)
        }

        binding.registerButton.setOnClickListener {
            val nome = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            if (check(user, nome, email)){
                val new_user = User(userId, nome, email)
                if (user == null) {
                    userDAO.add(new_user)
                }else{
                    userDAO.alterUser(userId, nome, email)
                }
                finish()
            }else{
                Toast.makeText(this, "Erro ao " + binding.registerButton.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }


    }

    fun check(user: User?, nome: String, email: String): Boolean {
        if(nome == "" || email == ""){
            return false
        }
        if (binding.title.text.toString() == "Alterar usuário"){
            if(user?.email != email){
                val condition = userDAO.emailExists(email)
                if (condition) {
                    return false
                }else{
                    return true
                }
            }else{
                return true
            }
        }
        if(userDAO.emailExists(email)){
            return false
        }
        return true
    }
}