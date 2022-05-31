package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinRepository

class GetCoinInfoUseCase(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = coinRepository.getCoinInfo(fromSymbol)
}