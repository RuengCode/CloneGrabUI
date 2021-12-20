package com.example.clonegrab.test

import com.google.gson.annotations.SerializedName

data class MyDataList(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("response")
	val response: Response? = null
)

data class Flag(

	@field:SerializedName("status_flag")
	val statusFlag: String? = null,

	@field:SerializedName("enable_flag")
	val enableFlag: Boolean? = null
)

data class Operation(

	@field:SerializedName("updated_by")
	val updatedBy: Any? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("updated_date")
	val updatedDate: Any? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null
)

data class ResultItem(

	@field:SerializedName("flag")
	val flag: Flag? = null,

	@field:SerializedName("name_th")
	val nameTh: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("operation")
	val operation: Operation? = null,

	@field:SerializedName("name_en")
	val nameEn: String? = null
)

data class Response(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)
