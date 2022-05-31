package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinRepository

class LoadDataUseCase(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke() = coinRepository.loadData()
}