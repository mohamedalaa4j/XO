package com.mido.xo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second_activity.*





class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activity)



        tvPlay.setOnClickListener {
            if (et1.text.toString().isEmpty() || et2.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter names",Toast.LENGTH_SHORT).show()
             }else {

                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("player one name", et1.text.toString())
                intent.putExtra("player two name", et2.text.toString())
                startActivity(intent)
                finish()
             }
        }
    }

    fun hideKeyboard(view: View){
        val inputMethodManager : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)

    }
}