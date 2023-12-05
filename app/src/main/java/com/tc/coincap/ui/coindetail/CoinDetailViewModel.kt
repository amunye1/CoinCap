package com.tc.coincap.ui.coindetail

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
            _coinDetails.value = repository.getCoinCurrencyId(id)
        }
    }
}
