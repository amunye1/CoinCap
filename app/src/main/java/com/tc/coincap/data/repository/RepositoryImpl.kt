package com.tc.coincap.data.repository

import com.tc.coincap.data.model.DataModel
import com.tc.coincap.data.model.RateItemModel
import com.tc.coincap.data.remote.ApiEndpoint
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiRequest: ApiEndpoint) :Repository{
    override suspend fun getCoinCurrency() : RateItemModel {
        return apiRequest.getCoinCurrency()
    }

    override suspend fun getCoinCurrencyId(id: String): DataModel? {
        val rateItemModel = apiRequest.getCoinCurrencyId(id)
        return rateItemModel.data?.find { it?.id == id }
    }
}