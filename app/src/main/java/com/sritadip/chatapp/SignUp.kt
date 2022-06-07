package com.sritadip.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()

        edtName=findViewById(R.id.edt_name)
        edtEmail=findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btnSignUp=findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()

            signUp(email,password)
        }
    }

    private fun signUp(email:String,password:String){
        //logic of creating new user

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code for jumping to home

                    val intent=Intent(this@SignUp,MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignUp,"Some error occured",Toast.LENGTH_LONG).show()

                }
            }
    }



}