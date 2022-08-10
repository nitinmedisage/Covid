package com.elink.covidassingment.viewmodelsfactories

/**
 * Created by Nitin Sabale
 * @since 27-07-2022. 18:32
 */
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elink.covidassingment.viewmodel.UserViewModel

class UserViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel() as T
    }

}