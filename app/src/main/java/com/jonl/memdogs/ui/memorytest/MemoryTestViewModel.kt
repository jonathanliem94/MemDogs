package com.jonl.memdogs.ui.memorytest

import androidx.lifecycle.ViewModel
import com.jonl.memdogs.data.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoryTestViewModel @Inject constructor(
    networkRepository: NetworkRepository
): ViewModel() {
}