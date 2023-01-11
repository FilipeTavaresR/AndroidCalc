package com.empresa.calculadera

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ActivityCalculator : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val numbersId = listOf(
            R.id.zero,
            R.id.one,
            R.id.two,
            R.id.three,
            R.id.four,
            R.id.five,
            R.id.six,
            R.id.seven,
            R.id.eight,
            R.id.nine,
            R.id.dot
        )

        val operationsId = listOf(
            R.id.multiply,
            R.id.division,
            R.id.plus,
            R.id.decrease
        )

        val result = R.id.result
        val erase = R.id.erease

        findViewById<Button>(result).setOnClickListener {
            viewModel.result()
        }

        findViewById<Button>(erase).setOnClickListener {
            viewModel.erase()
        }

        numbersId.forEach {
            bindNumbersClick(findViewById(it))
        }

        operationsId.forEach {
            bindOperationsClick(findViewById(it))
        }

        viewModel.resultView.observe(this) {
            findViewById<TextView>(R.id.result_view).text = it
        }

    }

    private fun bindNumbersClick(component: View) {
        component.setOnClickListener {
            viewModel.updateDisplay((it as Button).text.toString())
        }
    }

    private fun bindOperationsClick(component: View) {
        component.setOnClickListener {
            viewModel.operation((it as Button).text.toString())
        }
    }

}