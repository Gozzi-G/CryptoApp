package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.App
import com.example.cryptoapp.presentation.CoinDetailActivity
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class,
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(activity: CoinDetailActivity)

    fun inject(application: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}