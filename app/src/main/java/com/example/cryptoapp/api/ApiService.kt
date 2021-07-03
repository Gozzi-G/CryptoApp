package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinInfoListOfData
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //function which get a short info about Top crypto
    @GET("top/totalvolfull{}")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_APY_KEY) apiKey: String = "0ff5cb1990498ca58d13fbb3c8ddcf574e1836c26cad935387cd49a056cbf1d3",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY

    ): Single<CoinInfoListOfData>


    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_APY_KEY) apiKey: String = "0ff5cb1990498ca58d13fbb3c8ddcf574e1836c26cad935387cd49a056cbf1d3",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_PARAM_APY_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "ftsym"

        private const val CURRENCY = "USD"
    }
}