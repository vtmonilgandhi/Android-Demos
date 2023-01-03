package com.example.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demo.helper.DBHelper
import com.example.demo.models.Error
import java.util.regex.Pattern


class MainActivity : BaseActivity() {

    // get reference to all views
    private lateinit var etEmailId: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnReset: Button
    private lateinit var btnSubmit: Button
    var error = ""
    private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private val age = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmailId = findViewById(R.id.et_user_name)
        etPassword = findViewById(R.id.et_password)
        btnReset = findViewById(R.id.btn_reset)
        btnSubmit = findViewById(R.id.btn_submit)

        //Field Demo
        getAge()

        // Triple
        val (x, y, z) = Triple(1, "Triple Demo", 2.0)
        println(x)
        println(y)
        println(z)

        btnReset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            etEmailId.setText("")
            etPassword.setText("")
        }

        // set on-click listener
        btnSubmit.setOnClickListener {
            val email = etEmailId.text
            val password = etPassword.text

            if (validateDetails(email.toString(), password.toString()))
            {
                // SharedPreference Demo
                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.putString("password",password.toString())
                editor.commit()

                var pass = sharedPreference.getString("password","defaultName")
                Toast.makeText(this,  "$pass fetched from sharedPreference", Toast.LENGTH_LONG).show()

                // SQLite Demo
                val db = DBHelper(this, null)
                db.addEmail(email.toString())
                Toast.makeText(this, " $email added to database", Toast.LENGTH_LONG).show()

                val cursor = db.getEmail()

                var email = ""
                if (cursor!!.moveToFirst()) {
                    while (!cursor.isAfterLast) {
                        val gc = cursor.getColumnIndex(DBHelper.EMAIL_COl)
                        if (gc >= 0) {
                            email = cursor.getString(gc)
                        }
                        cursor.moveToNext()
                    }
                }
                Toast.makeText(this,  "$email fetched from database", Toast.LENGTH_LONG).show()


                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MovieListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getAge(): Int {
        val var1 = "Age is: $age"
        println(var1)
        return age
    }

    private fun validateDetails(emailText:String, passwordText: String) = when {
        emailText.isEmpty() -> {
            error="Email " + Error.NULL_FIELD.toString()
            false
        }
        emailText.isBlank() -> {
            error="Email " + Error.BLANK_FIELD.toString()
            false
        }
        !isValidString(emailText) -> {
            error="Email is invalid"
            false
        }
        passwordText.isEmpty() -> {
            error="Password " + Error.NULL_FIELD.toString()
            false
        }
        passwordText.isBlank() -> {
            error="Password " + Error.BLANK_FIELD.toString()
            false
        }

        else -> true
    }

    private fun isValidString(str: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }
}