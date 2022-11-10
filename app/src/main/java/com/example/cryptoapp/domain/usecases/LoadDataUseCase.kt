package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke() = coinRepository.loadData()
}