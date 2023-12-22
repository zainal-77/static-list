package com.dicoding.aplikasisederhanadetail_about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.aplikasisederhanadetail_about.databinding.ItemRowHeroBinding


class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
	private lateinit var onItemClickCallback: OnItemClickCallback
	
	fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
		this.onItemClickCallback = onItemClickCallback
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ListViewHolder(binding)
	}
	
	
	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val (name, description, photo) = listHero[position]
		holder.binding.imgItemPhoto.setImageResource(photo)
		holder.binding.tvItemName.text = name
		holder.binding.tvItemDescription.text = description // Tampilkan description di halaman list
		// Tidak perlu menampilkan detailDescription di halaman list
		holder.itemView.setOnClickListener {
			onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
		}
	}
	
	override fun getItemCount(): Int = listHero.size
	
	class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

	
	interface OnItemClickCallback {
		fun onItemClicked(data: Hero)
	}
}



