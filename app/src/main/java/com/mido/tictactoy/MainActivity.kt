package com.mido.tictactoy

import android.app.Dialog
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom.*


class MainActivity : AppCompatActivity() {

    lateinit var play_one_name: String
    lateinit var play_two_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        play_one_name = intent.getStringExtra("player one name").toString()
        play_two_name = intent.getStringExtra("player two name").toString()

        tvPlayerOne.text = play_one_name
        tvPlayerTwo.text = play_two_name
        tvPlayerOne.setTypeface(tvPlayerOne.typeface, Typeface.BOLD)

        buExit.setOnClickListener { customDialogFunction() }


    }

    fun buSelect(view: View) {
        val buChoise = view as Button
        var cellId = 0

        when (buChoise.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        Log.d("cellId ", cellId.toString())
        playGame(cellId, buChoise)
        buAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("player one name", play_one_name)
            intent.putExtra("player two name", play_two_name)
            startActivity(intent)


        }


    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellId: Int, buChoise: Button) {

        if (activePlayer == 1) {
            buChoise.text = "X"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
        } else {
            buChoise.text = "O"
            buChoise.setBackgroundResource(R.color.red)
            player2.add(cellId)
            activePlayer = 1
        }
        buChoise.isEnabled = false

        if (activePlayer == 1){
            tvPlayerOne.setTypeface(null, Typeface.BOLD)
            tvPlayerTwo.setTypeface(null, Typeface.NORMAL)
        }
        else if (activePlayer == 2){
            tvPlayerTwo.setTypeface(null, Typeface.BOLD)
            tvPlayerOne.setTypeface(null, Typeface.NORMAL)

        }

        checkWinner()
    }


    fun checkWinner() {
        var winner = 0


        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //x9
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //x7
        if (player1.contains(7) && player1.contains(5) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(5) && player2.contains(3)) {
            winner = 2
        }




        if (winner == 1) {
            tvWinner.text = "$play_one_name Wins"
            llPlayersNames.visibility = View.INVISIBLE
        }
        if (winner == 2) {
            tvWinner.text = "$play_two_name Wins"
            llPlayersNames.visibility = View.INVISIBLE

        }
        if (winner == 1 || winner == 2) {
            bu1.isEnabled = false
            bu2.isEnabled = false
            bu3.isEnabled = false
            bu4.isEnabled = false
            bu5.isEnabled = false
            bu6.isEnabled = false
            bu7.isEnabled = false
            bu8.isEnabled = false
            bu9.isEnabled = false
            buAgain.visibility = View.VISIBLE

        }

        if (
            bu1.isEnabled == false &&
            bu2.isEnabled == false &&
            bu3.isEnabled == false &&
            bu4.isEnabled == false &&
            bu5.isEnabled == false &&
            bu6.isEnabled == false &&
            bu7.isEnabled == false &&
            bu8.isEnabled == false &&
            bu9.isEnabled == false

        )
        {
            buAgain.visibility = View.VISIBLE
            llPlayersNames.visibility = View.INVISIBLE
            if (winner == 0) {
                tvWinner.text = "Draw!"
            }

        }


    }


    fun customDialogFunction(){

        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom)

        customDialog.tv_submit.setOnClickListener{
            val intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
            customDialog.dismiss()
            finish()
        }

        customDialog.tv_cancel.setOnClickListener{
            customDialog.dismiss()

        }

        customDialog.show()

    }


}

