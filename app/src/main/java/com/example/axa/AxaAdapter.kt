package com.example.axa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.axa.core.domain.AxaEntity
import com.example.axa.databinding.ItemUserBinding

class AxaAdapter : ListAdapter<AxaEntity, AxaAdapter.ListViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AxaEntity) {
            binding.title.text = data.title
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<AxaEntity> =
            object : DiffUtil.ItemCallback<AxaEntity>() {
                override fun areItemsTheSame(oldItem: AxaEntity, newItem: AxaEntity): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(oldItem: AxaEntity, newItem: AxaEntity): Boolean {
                    return oldItem == newItem
                }
            }
    }
}