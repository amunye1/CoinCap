package com.tc.coincap.data.repository

import com.tc.coincap.data.model.DataModel
import com.tc.coincap.data.remote.ApiEndpoint
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiRequest: ApiEndpoint) :Repository{
    override suspend fun getCoinCurrency() : DataModel{
        return apiRequest.getCoinCurrency()
    }

    override suspend fun getCoinCurrencyId(id:String) : DataModel{
        return apiRequest.getCoinCurrencyId(id)
    }
}