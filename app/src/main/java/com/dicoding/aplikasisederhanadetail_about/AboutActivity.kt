package com.dicoding.aplikasisederhanadetail_about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.core.app.TaskStackBuilder
import com.dicoding.aplikasisederhanadetail_about.R

class AboutActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_about)
		
		supportActionBar?.apply {
			title = "Profile" // Ganti judul sesuai kebutuhan
			setDisplayHomeAsUpEnabled(true)
		}
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
