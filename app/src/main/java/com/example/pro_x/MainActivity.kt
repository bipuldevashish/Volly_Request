package com.example.pro_x

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pro_x.Data.RequestData
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //Initialization

            //calling the fetchwallpaper to retreive the data from api
            RequestData.fetchWallpaper(applicationContext)


    }

}

