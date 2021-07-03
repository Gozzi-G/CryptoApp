package com.example.cryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.pojo.CoinPriceInfo
import retrofit2.http.GET
import java.text.DateFormatSymbols

@Dao
interface CoinPriceInfoDAO {

    @Query("SELECT * FROM full_price_list ORDER BY lastupdate")
    fun getPriceList() : LiveData<List<CoinPriceInfo>>

    @Query("SELECT * FROM full_price_list WHERE fromsymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String) : LiveData<CoinPriceInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceList(coinList: List<CoinPriceInfo>)

}