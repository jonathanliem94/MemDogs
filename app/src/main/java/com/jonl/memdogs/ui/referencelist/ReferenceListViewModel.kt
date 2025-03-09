package com.jonl.memdogs.ui.referencelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonl.memdogs.data.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReferenceListViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
): ViewModel() {

    init {
        refresh()
    }

    private val _uiState = MutableStateFlow(RefListUiState())
    val uiState: StateFlow<RefListUiState> = _uiState.asStateFlow()

    private fun refresh() {
        viewModelScope.launch {
            networkRepository.dogList.collect { result ->
                _uiState.value = RefListUiState(
                    items = result.dogList.keys.toList(),
                )
            }
        }
    }

}

data class RefListUiState(
    val items: List<String> = emptyList(),
)