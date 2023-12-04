package com.tc.coincap.data.repository

import com.tc.coincap.data.model.DataModel

interface Repository {
    suspend fun getCoinCurrency() : DataModel

    suspend fun getCoinCurrencyId(id:String) : DataModel
}