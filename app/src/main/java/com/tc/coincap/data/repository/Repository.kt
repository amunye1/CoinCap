package com.tc.coincap.data.repository

import com.tc.coincap.data.model.DataModel
import com.tc.coincap.data.model.RateItemModel

interface Repository {
    suspend fun getCoinCurrency() : RateItemModel

    suspend fun getCoinCurrencyId(id:String) : DataModel?
}