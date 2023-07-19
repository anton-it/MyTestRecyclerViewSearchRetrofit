package com.ak87.mytestrecyclerviewsearchretrofit.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ak87.mytestrecyclerviewsearchretrofit.R
import com.ak87.mytestrecyclerviewsearchretrofit.presentations.fragments.MainFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, MainFragment.newInstance())
            .commit()


    }
}