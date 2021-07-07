package com.example.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cryptoapp.api.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()
    private lateinit var viewModel : CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
//        viewModel.priceList.observe(this, Observer {
//            Log.d("test", "Success in activity: $it")
//        })
        viewModel.getDetailInfo("BTC").observe(this, Observer {
            Log.d("test", "Success in activity: $it")
        })
    }
}



