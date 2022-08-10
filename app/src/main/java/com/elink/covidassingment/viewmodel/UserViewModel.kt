package com.elink.covidassingment.viewmodel

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:28
 */
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elink.covidassingment.model.DataList
import com.elink.repository.UserRepository
import kotlin.collections.ArrayList


class UserViewModel() : ViewModel() {

    private val repository: UserRepository


    init {
        repository = UserRepository()
    }

    fun getData(): MutableLiveData<ArrayList<DataList>> {
        var listData = repository.getMutableLiveData()
        return listData
    }

}