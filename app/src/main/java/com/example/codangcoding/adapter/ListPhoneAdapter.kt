package com.example.codangcoding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codangcoding.DetailPhoneActivity
import com.example.codangcoding.databinding.ItemViewBinding
import com.example.codangcoding.model.dataPhone

class ListPhoneAdapter (var listPhone: ArrayList<dataPhone>):
RecyclerView.Adapter<ListPhoneAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listPhone.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val phone = listPhone[position]

        Glide.with(holder.itemView.context)
            .load(phone.image)
            .into(holder.binding.imgProfile)

        holder.binding.tvName.text = phone.name

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailPhoneActivity::class.java)
            intent.putExtra("DATA", phone)

            holder.itemView.context.startActivity(intent)
        }
    }


}