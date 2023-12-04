package com.tc.coincap.data.model


import com.google.gson.annotations.SerializedName

data class RateItemModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)