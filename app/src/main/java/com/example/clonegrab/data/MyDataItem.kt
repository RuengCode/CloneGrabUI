package com.example.clonegrab.data


import com.google.gson.annotations.SerializedName

data class MyDataItem(

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class Base(

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("sign")
    val sign: String? = null
)

data class Data(

    @field:SerializedName("stats")
    val stats: Stats? = null,

    @field:SerializedName("coins")
    val coins: List<CoinsItem?>? = null,

    @field:SerializedName("base")
    val base: Base? = null
)

data class SocialsItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class LinksItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class AllTimeHigh(

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("timestamp")
    val timestamp: Long? = null
)

data class CoinsItem(

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("penalty")
    val penalty: Boolean? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("uuid")
    val uuid: String? = null,

    @field:SerializedName("circulatingSupply")
    val circulatingSupply: Float? = null,

    @field:SerializedName("websiteUrl")
    val websiteUrl: String? = null,

    @field:SerializedName("allTimeHigh")
    val allTimeHigh: AllTimeHigh? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("iconType")
    val iconType: String? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("links")
    val links: List<LinksItem?>? = null,

    @field:SerializedName("approvedSupply")
    val approvedSupply: Boolean? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("iconUrl")
    val iconUrl: String? = null,

    @field:SerializedName("socials")
    val socials: List<SocialsItem?>? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("marketCap")
    val marketCap: Long? = null,

    @field:SerializedName("numberOfMarkets")
    val numberOfMarkets: Int? = null,

    @field:SerializedName("confirmedSupply")
    val confirmedSupply: Boolean? = null,

    @field:SerializedName("totalSupply")
    val totalSupply: Double? = null,

    @field:SerializedName("firstSeen")
    val firstSeen: Long? = null,

    @field:SerializedName("change")
    val change: Double? = null,

    @field:SerializedName("history")
    val history: List<String?>? = null,

    @field:SerializedName("listedAt")
    val listedAt: Int? = null,

    @field:SerializedName("volume")
    val volume: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("numberOfExchanges")
    val numberOfExchanges: Int? = null
)

data class Stats(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("offset")
    val offset: Int? = null,

    @field:SerializedName("totalExchanges")
    val totalExchanges: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("totalMarkets")
    val totalMarkets: Int? = null,

    @field:SerializedName("totalMarketCap")
    val totalMarketCap: Double? = null,

    @field:SerializedName("total24hVolume")
    val total24hVolume: Double? = null,

    @field:SerializedName("order")
    val order: String? = null,

    @field:SerializedName("base")
    val base: String? = null
)
