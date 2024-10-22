package com.example.NavigationApplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NavigationApplication.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<String?>()
    val loginResult: LiveData<String?> get() = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val response = authRepository.login(username, password)
            if (response.isSuccessful) {
                _loginResult.value = response.body()?.keypass
            } else {
                _loginResult.value = null
            }
        }
    }
}
