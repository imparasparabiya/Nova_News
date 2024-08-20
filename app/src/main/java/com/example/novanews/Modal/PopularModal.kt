package com.example.novanews.Modal

import com.google.gson.annotations.SerializedName

data class PopularModal(

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("subnews")
	val subnews: List<SubnewsItem>? = null
)

data class SubnewsItem(

	@field:SerializedName("snippet")
	val snippet: String? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("newsUrl")
	val newsUrl: String? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)

data class ItemsItem(

	@field:SerializedName("snippet")
	val snippet: String? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("newsUrl")
	val newsUrl: String? = null,

	@field:SerializedName("hasSubnews")
	val hasSubnews: Boolean? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null,

	@field:SerializedName("subnews")
	val subnews: List<SubnewsItem?>? = null
)

data class Images(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("thumbnailProxied")
	val thumbnailProxied: String? = null
)
