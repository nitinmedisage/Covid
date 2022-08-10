package com.elink.covidassingment.model

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:23
 */

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class APIResponse(
    @SerializedName("data")
    val data: ArrayList<DataList>? = null

)