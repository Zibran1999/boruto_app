package com.zibran.brutoapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zibran.brutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
):ViewModel() {

    private val _onBoardingCompleted= MutableStateFlow(false)
    val onBoardingCompleted:StateFlow<Boolean> =_onBoardingCompleted

    init {
        viewModelScope.launch(dispatcher) {
            _onBoardingCompleted.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}