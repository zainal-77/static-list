package com.dicoding.aplikasisederhanadetail_about

// data class
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Hero(
	var name: String,
	var description: String,
//	var detailDescription: String,
	var photo: Int
) : Parcelable