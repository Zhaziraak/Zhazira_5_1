package com.example.zhazira_5_1_cw

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zhazira_5_1_cw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
                presenter.checkConditions(presenter.model.count)
            }


            btnDecrement.setOnClickListener {
                presenter.onDecrement()
                presenter.checkConditions(presenter.model.count)
            }
        }
    }


    override fun showResult(count: Int) = with(binding) {
        tvResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }


    override fun onDestroy(){
        presenter.detachContract()
        super.onDestroy()
    }
}