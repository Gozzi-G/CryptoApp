package com.example.cryptoapp.data.network.workers

import android.content.Context
import androidx.work.*
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

class RefreshDataWorker (
    context: Context,
    workerParameters: WorkerParameters,
    private val coinInfoDao: CoinInfoDao,
    private val mapper: CoinMapper,
    private val apiService: ApiService,
) : CoroutineWorker(context, workerParameters) {


    companion object {
        const val name = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSym = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSym)
                val coinInfoListDto = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoListDto.map {
                    mapper.mapDtoToDbModel(it)
                }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (_: Exception) {

            }
            delay(1000)
        }
    }

    class Factory @Inject constructor(
        private val coinInfoDao: CoinInfoDao,
        private val mapper: CoinMapper,
        private val apiService: ApiService,
    ) : ChildWorkerFactory {

        override fun create(
            context: Context,
            workerParameters: WorkerParameters,

            ): ListenableWorker {
            return RefreshDataWorker(
                context,
                workerParameters,
                coinInfoDao,
                mapper,
                apiService
            )
        }
    }
}

//test