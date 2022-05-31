package com.example.cryptoapp.domain


data class CoinInfo(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: Long?,
    val highDay: String?,
    val low2Day: String?,
    val lastMarket: String?,
    val imageUrl: String?
) {

}
