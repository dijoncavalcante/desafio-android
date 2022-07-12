package com.picpay.desafio.android.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.RequestResult
import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.domain.useCase.ContactUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: ContactUseCase
) : ViewModel() {

    private val TAG = this.javaClass.name

    private val _getAllUsersViewState = MutableLiveData<ViewState<List<UserResponse>>>()
    var getAllUsersViewState: LiveData<ViewState<List<UserResponse>>> = _getAllUsersViewState

    fun getUsers() =
        viewModelScope.launch {
            _getAllUsersViewState.value = ViewState.LOADING
            val requestResult = useCase.getUsers()

            when (requestResult) {
                is RequestResult.Succeeded -> {
                    Log.d(TAG, "Get users returned successfully")
                    _getAllUsersViewState.postValue(ViewState.SUCCESS(requestResult.data))
                }
                is RequestResult.Failure -> {
                    Log.e(TAG, "Error when get users")
                    Log.e(TAG, requestResult.errorMsg.toString())
                }
            }
        }
}