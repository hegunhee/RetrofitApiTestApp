package com.hegunhee.retrofitapitestapp

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/subway/sample/json/realtimeStationArrival/1/5/강남")
    suspend fun getData() : Response<RealtimeArrival>
}