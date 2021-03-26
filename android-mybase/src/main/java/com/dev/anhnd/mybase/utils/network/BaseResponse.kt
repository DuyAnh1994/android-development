package com.dev.anhnd.mybase.utils.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseResponse (
    @Expose
    @SerializedName("error_code")
    var error_code : Int? = null,

    @Expose
    @SerializedName("message")
    var message : String? = null
) : Serializable



