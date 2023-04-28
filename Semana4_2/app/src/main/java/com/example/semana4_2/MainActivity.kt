package com.example.semana4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions:ArrayList<Question>
    var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadQuestion()
        setUpView()

    }

    private fun loadQuestion() {
        questions= ArrayList()
        questions.add(Question("Es buenos aires la capital de Argentina?",true))
        questions.add(Question("Es colombia la capital de Argentina?",false))
        questions.add(Question("Es quitos aires la capital de Ecuador?",true))
        questions.add(Question("Es arequipa es la capital de Peru?",false))
        questions.add(Question("Es buenos aires la capital de Chile?",false))
    }

    private fun setUpView() {
        val btSi=findViewById<Button>(R.id.btSi)
        val btNo=findViewById<Button>(R.id.btNo)
        val btNext=findViewById<Button>(R.id.btNext)
        val tvQuestion=findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.setText(questions[index].sentence)

        btSi.setOnClickListener(){
            if(questions[index].answer){
                Toast.makeText(this,"Respuesta correcta",Toast.LENGTH_SHORT).show()
            }
            if(!questions[index].answer){
                Toast.makeText(this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show()
            }


        }
        btNo.setOnClickListener(){
            if(questions[index].answer){
                Toast.makeText(this,"Respuesta incorrecta",Toast.LENGTH_SHORT).show()
            }
            if(!questions[index].answer){
                Toast.makeText(this,"Respuesta correcta",Toast.LENGTH_SHORT).show()
            }
        }
        btNext.setOnClickListener(){
            if(index<this.questions.size-1){
                this.index++
                tvQuestion.setText(questions[index].sentence)
            }

        }

    }
}