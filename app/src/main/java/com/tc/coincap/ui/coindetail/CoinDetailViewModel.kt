package com.tc.coincap.ui.coindetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.coincap.data.model.DataModel
import com.tc.coincap.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class CoinDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _coinDetails = MutableStateFlow<DataModel?>(null)
    val coinDetails: StateFlow<DataModel?> = _coinDetails

    fun getCoinDetails(id: String) {
        viewModelScope.launch {
            // Log to check the ID being requested
            Log.d("CoinDetailViewModel", "Fetching for ID: $id")
            _coinDetails.value = repository.getCoinCurrencyId(id)
            // Log to confirm what data is being received
            Log.d("CoinDetailViewModel", "Received data: ${_coinDetails.value}")
        }
    }
}