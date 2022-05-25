package com.mido.tictactoy

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.dialog_custom.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        tvMultiplayer.setOnClickListener {

            startActivity(Intent(this, SecondActivity::class.java))
        }

        tvStart.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        tvExit.setOnClickListener{
            customDialogFunction()
        }
    }

    fun customDialogFunction(){

        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom2)

        customDialog.tv_submit.setOnClickListener{
         customDialog.dismiss()
            finishAffinity()
        }

        customDialog.tv_cancel.setOnClickListener{
            customDialog.dismiss()

        }

        customDialog.show()

    }
}