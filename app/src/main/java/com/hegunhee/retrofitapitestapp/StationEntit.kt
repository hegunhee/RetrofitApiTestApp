package com.hegunhee.retrofitapitestapp


import com.google.gson.annotations.SerializedName

data class StationEntit(
    @SerializedName("errorMessage")
    val errorMessage: ErrorMessage?,
    @SerializedName("realtimeArrivalList")
    val realtimeArrivalList: List<RealtimeArrival>?
)