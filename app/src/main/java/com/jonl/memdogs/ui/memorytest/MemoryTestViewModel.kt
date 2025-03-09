package com.jonl.memdogs.ui.memorytest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonl.memdogs.data.NetworkRepository
import com.jonl.memdogs.util.extractBreedFromString
import com.jonl.memdogs.util.formatName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoryTestViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
): ViewModel() {

    init {
        refresh()
    }

    private val _uiState = MutableStateFlow(MemTestUiState("", ""))
    val uiState: StateFlow<MemTestUiState> = _uiState.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            networkRepository.randomDog.collect { result ->
                val breedName = formatName(
                    extractBreedFromString(result)
                )
                _uiState.value = MemTestUiState(
                    imageUri = result,
                    breedName = breedName,
                )
            }
        }
    }
}

data class MemTestUiState(
    val imageUri: String = "",
    val breedName: String = "",
)