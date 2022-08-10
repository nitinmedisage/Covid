package com.elink.covidassingment.model

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:23
 */

import com.google.gson.annotations.SerializedName
data class DataList(
    @SerializedName("iso")
    val iso: String? = null,

     @SerializedName("name")
    val name: String? = null,

    var expand : Boolean = false

)