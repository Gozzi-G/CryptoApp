package com.example.cryptoapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoDtoList: List<CoinInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinInfoViewHolder(binding)
    }

    override fun getItemCount() = coinInfoDtoList.size


    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val symbolsTemplate = context.resources.getString(R.string.symbols_template)
        val lastUpdateSymbols = context.resources.getString(R.string.last_update_template)
        val coin = coinInfoDtoList[position]
        holder.binding.tvSymbols.text =
            String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
        holder.binding.tvPrice.text = coin.price
        holder.binding.tvUpDate.text = String.format(lastUpdateSymbols, coin.lastUpdate)
        Picasso.get().load(coin.imageUrl).into(holder.binding.ivLogoCoin)
        holder.binding.root.setOnClickListener {
            onCoinClickListener?.onCoinClick(coin)
        }
    }


    class CoinInfoViewHolder(val binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnCoinClickListener {
        fun onCoinClick(coinInfoDto: CoinInfo)
    }


}