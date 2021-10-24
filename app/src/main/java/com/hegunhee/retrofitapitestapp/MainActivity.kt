package com.hegunhee.retrofitapitestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    val job : Job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logData()
    }

    private fun logData() = launch(Dispatchers.IO) {
            val response = RetrofitUtil.getApi.getData()

            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    Log.d("subwayList", body.subwayList ?: "null")
                }
//            val response = RetrofitUtil.getApi
//            if(response.isS
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}