package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinRepository

class GetCoinInfoListUseCase(
    private val coinRepository: CoinRepository
) {
    operator fun invoke() = coinRepository.getCoinList()
}