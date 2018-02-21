package com.siddapps.android.p97.data

import com.google.gson.annotations.SerializedName

data class APIResponse(
        @SerializedName("languageId") val languageId: String,
        @SerializedName("languageName") val languageName: String,
        @SerializedName("version") val version: Int,
        @SerializedName("stringDictionary") val stringDictionary: StringDictionary,
        @SerializedName("createdOn") val createdOn: Any,
        @SerializedName("id") val id: Any,
        @SerializedName("tenantId") val tenantId: String,
        @SerializedName("documentType") val documentType: String,
        @SerializedName("ttl") val ttl: Any,
        @SerializedName("_etag") val etag: Any
)
