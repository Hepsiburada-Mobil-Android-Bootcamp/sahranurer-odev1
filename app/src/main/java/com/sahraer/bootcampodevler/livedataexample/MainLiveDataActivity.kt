package com.sahraer.bootcampodevler.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sahraer.bootcampodevler.R

class MainLiveDataActivity : AppCompatActivity() {

    private val btn_button by lazy { findViewById<Button>(R.id.btn_button) }
    private val textView by lazy { findViewById<TextView>(R.id.textView) }
    private val booleantextView by lazy { findViewById<TextView>(R.id.booleantextView) }
    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_live_data)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)//bağlama işlemi

        //gözlemci
        viewModel.currentNumber.observe(this, Observer {
            textView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            booleantextView.text = it.toString()
        })


        incrementText()

    }

    private fun incrementText(){
        btn_button.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number // arttırma işlemi
            viewModel.currentBoolean.value = viewModel.number % 2 == 0 // tek sayılara false çift sayılara true işlemi

        }
    }



}