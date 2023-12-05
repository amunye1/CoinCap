package com.tc.coincap.ui.coinrate

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.coincap.data.model.DataModel
import com.tc.coincap.data.model.RateItemModel
import com.tc.coincap.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinRateViewModel @Inject constructor(private val repository: Repository):ViewModel (){

    private val _coin= MutableStateFlow<RateItemModel>(RateItemModel())

    val coin : StateFlow<RateItemModel?> = _coin



    init {
        getCoin() // Fetch data when ViewModel is created
    }
   fun getCoin(){
       viewModelScope.launch {
           val response = repository.getCoinCurrency()

           _coin.value = response


       }
   }


}