package com.siddapps.android.p97.data

import com.google.gson.annotations.SerializedName

data class APIResponse(
        @SerializedName("languageId") val languageId: String,
        @SerializedName("version") val version: Int,
        @SerializedName("stringDictionary") val stringDictionary: StringDictionary,
        @SerializedName("tenantId") val tenantId: String
)
