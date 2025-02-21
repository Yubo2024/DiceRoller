package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           //呼叫Toast。makeText()即可简历内含文字的“Dice Rolled”的Toast
            Toast.makeText(this,"Dice rolled!",Toast.LENGTH_SHORT).show()
            rollDice()//执行滚动功能
        }

    }

    private fun rollDice() {
        //建立新的Dice 物件执行个体
        val dice = Dice(6)
        val  diceRoll = dice.roll()
        val resultTextView:TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val luckyTextView:TextView=findViewById(R.id.textView2)
        val luckyNumber =6
        if(luckyNumber == diceRoll) {
            luckyTextView.text = getString(R.string.luckyNumber)
        }else{
         luckyTextView.text = ""
        }

        val diceImage:ImageView= findViewById(R.id.imageView)
  /*      if(diceRoll == 1){
            diceImage.setImageResource(R.drawable.dice_1)
        }else if(diceRoll == 2){
            diceImage.setImageResource(R.drawable.dice_2)
        }*/
      val drawableResource =  when(diceRoll){
            1 -> R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}
/*
筛子蓝图：class Dice
具有滚动功能：fun roll()

 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return(1..numSides).random()
    }

}
