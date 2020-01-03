package com.example.exercise5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import my.edu.tarc.exercise5.CountViewModel

class MainActivity : AppCompatActivity() {

    private var like : String = ""
    private var dislike : String = ""

    lateinit var countViewModel: CountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java);

        imageViewLike.setOnClickListener {
            countViewModel.countLike++
            textViewLike.text = countViewModel.countLike.toString()
        }

        imageViewDislike.setOnClickListener {
            countViewModel.countDislike++
            textViewDislike.text = countViewModel.countDislike.toString()
        }
    }

    override fun onPause() {
        super.onPause()

        like = countViewModel.returnLike().toString()
        dislike = countViewModel.returnDislike().toString()

        var sharedPreferences = getSharedPreferences("com.example.exercise5", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()){
            putString("like", like)
            putString("dislike", dislike)
            apply()
        }
    }

    override fun onResume() {
        super.onResume()

        var sharedPreferences = getSharedPreferences("com.example.exercise5", Context.MODE_PRIVATE)

        var getLike = sharedPreferences.getString("like", like)
        var getDislike = sharedPreferences.getString("dislike", dislike)

        if(getLike.equals("") && getDislike.equals(""))
        {
            getLike = "0"
            getDislike = "0"
        }

        textViewLike.text = "" + getLike
        textViewDislike.text = "" + getDislike
        countViewModel.setLike(getLike.toString().toInt())
        countViewModel.setDislike(getDislike.toString().toInt())
    }

    override fun onStop() {
        Log.d("MainActivity" , "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity" , "onDestroy")
        super.onDestroy()
    }
}

