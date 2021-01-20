package com.example.assnone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assnone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            toastButton.setOnClickListener {
                toast()
            }
            upButton.setOnClickListener {
                up()
            }
            downButton.setOnClickListener {
                down()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count", binding.countText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.countText.text = savedInstanceState.getString("count")
    }

    private fun toast() {
        Toast.makeText(this, "Current count is ${binding.countText.text}", Toast.LENGTH_SHORT).show()
    }

    private fun up() {
        val count = Integer.parseInt(binding.countText.text.toString()) + 1
        binding.countText.text = count.toString()
    }

    private fun down() {
        val count = Integer.parseInt(binding.countText.text.toString()) - 1
        binding.countText.text = count.toString()
    }


}