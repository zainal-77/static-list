package com.dicoding.aplikasisederhanadetail_about


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NavUtils
import androidx.core.app.TaskStackBuilder

class DetailActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)
		supportActionBar?.title = "Detail"
		
		val data = intent.getParcelableExtra<Hero>("DATA")
		val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
		val tvName = findViewById<TextView>(R.id.tv_item_name)
		val tvDescription = findViewById<TextView>(R.id.tv_item_description)
		
		imgPhoto.setImageResource(data?.photo ?: 0)
		tvName.text = data?.name
		tvDescription.text = data?.description
	}


	
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_sharing, menu)
		return super.onCreateOptionsMenu(menu)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val data = intent.getParcelableExtra<Hero>("DATA")
		
		val nama = data?.name
		val description = data?.description
		
		val sendIntent: Intent = Intent().apply {
			action = Intent.ACTION_SEND
			putExtra(Intent.EXTRA_TEXT, "$nama\n $description")
			type ="text/plain"
		}
		val shareIntent = Intent.createChooser(sendIntent, null)
		startActivity(shareIntent)
		return super.onOptionsItemSelected(item)
	}
	
	override fun onSupportNavigateUp(): Boolean {
		val upIntent = NavUtils.getParentActivityIntent(this)
		return if (upIntent != null && NavUtils.shouldUpRecreateTask(this, upIntent)) {
			TaskStackBuilder.create(this)
				.addNextIntentWithParentStack(upIntent)
				.startActivities()
			true
		} else if (upIntent != null) {
			NavUtils.navigateUpTo(this, upIntent)
			true
		} else {
			super.onSupportNavigateUp()
		}
	}
}
