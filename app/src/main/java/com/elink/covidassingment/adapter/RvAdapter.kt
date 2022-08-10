package com.elink.covidassingment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elink.covidassingment.databinding.SingleItemBinding
import com.elink.covidassingment.model.DataList

/**
 * Created by Nitin Sabale
 * @since 10-08-2022. 17:52
 */
class RvAdapter(
    private var languageList: List<DataList>
) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(languageList[position]){
                binding.tvLangName.text = this.iso
                binding.tvDescription.text = this.name
                binding.expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }
            }
        }
    }
    // return the size of languageList
    override fun getItemCount(): Int {
        return languageList.size
    }

    fun setAdapterData(dataListList: MutableList<DataList>) {
        languageList = dataListList
        notifyDataSetChanged()
    }
}