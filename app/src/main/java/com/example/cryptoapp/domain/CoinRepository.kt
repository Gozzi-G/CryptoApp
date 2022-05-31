package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CoinRepository {

    fun getCoinList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}