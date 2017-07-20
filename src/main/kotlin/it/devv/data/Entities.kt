package it.devv.data

import com.google.gson.annotations.SerializedName

/**
 * Created by oleg on 7/20/17.
 */

data class Data(@SerializedName("Name") val name: String, @SerializedName("Type") var type: String, @SerializedName("Designed by") var designedBy: String)
data class ParseData(val hash: Int, val data: Data)
data class Query(val includeWords: Array<String>, val excludeWords: Array<String>)