package com.example.cryptoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(private val context: Context): RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount() = coinInfoList.size


    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val symbolsTemplate = context.resources.getString(R.string.symbols_template)
        val lastUpdateSymbols = context.resources.getString(R.string.last_update_template)
        val coin = coinInfoList[position]
        holder.tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
        holder.tvPrice.text = coin.price
        holder.tvUpDate.text = String.format(lastUpdateSymbols, coin.getFormattedTime())
        Picasso.get().load(coin.getFullImageUrl()).into(holder.ivLogoCoin)
    }


    inner class CoinInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin = itemView.ivLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvPrice = itemView.tvPrice
        val tvUpDate = itemView.tvUpDate

    }


}