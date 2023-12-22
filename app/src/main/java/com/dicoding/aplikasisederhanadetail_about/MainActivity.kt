package com.dicoding.aplikasisederhanadetail_about

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
	private lateinit var rvHeroes: RecyclerView
	private val list = ArrayList<Hero>()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		rvHeroes = findViewById(R.id.rv_heroes)
		rvHeroes.setHasFixedSize(true)
		list.addAll(getListHeroes())
		showRecyclerList()
	}
	
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return super.onCreateOptionsMenu(menu)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.about_page -> {
				val about = Intent(this@MainActivity, AboutActivity::class.java)
				startActivity(about)
				true
			}
			android.R.id.home -> {
				onBackPressed()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}
	
	
	
	private fun getListHeroes(): ArrayList<Hero> {
		val dataName = resources.getStringArray(R.array.data_name)
		val dataDescription = resources.getStringArray(R.array.data_description)
		val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
		
		val listHero = ArrayList<Hero>()
		for (i in dataName.indices) {
			val hero = Hero(dataName[i],dataDescription[i], dataPhoto.getResourceId(i, -1))
			listHero.add(hero)
		}
		return listHero
	}



	
	private fun showRecyclerList() {
		rvHeroes.layoutManager = LinearLayoutManager(this)
		val listHeroAdapter = ListHeroAdapter(list)
		rvHeroes.adapter = listHeroAdapter
		
		listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
			override fun onItemClicked(data: Hero) {
				val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
				intentToDetail.putExtra("DATA", data)
				startActivity(intentToDetail)
			}
		})
	}
	
	private fun showSelectedHero(hero: Hero) {
		Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
	}
}