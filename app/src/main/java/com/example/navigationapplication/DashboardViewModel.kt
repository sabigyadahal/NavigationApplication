package com.example.NavigationApplication.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.NavigationApplication.Entity
import com.example.NavigationApplication.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    private val _entities = MutableLiveData<List<Entity>>()
    val entities: LiveData<List<Entity>> get() = _entities

    fun fetchDashboardData(keypass: String) {
        viewModelScope.launch {
            val response = dashboardRepository.getDashboardData(keypass)
            if (response.isSuccessful) {
                _entities.value = response.body()?.entities
            }
        }
    }
}
