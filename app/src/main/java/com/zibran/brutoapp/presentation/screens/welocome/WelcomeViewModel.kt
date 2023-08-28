package com.zibran.brutoapp.presentation.screens.welocome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zibran.brutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {


    fun saveOnBoardingState(completed: Boolean, dispatcher: CoroutineDispatcher = Dispatchers.IO) {
        viewModelScope.launch(dispatcher) {
            useCases.saveOnBoardingUseCase(completed = completed)
        }
    }
}