package com.zibran.brutoapp.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zibran.brutoapp.domain.model.Hero
import com.zibran.brutoapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery
    private val _searchHeroes = MutableStateFlow<PagingData<Hero>>(PagingData.empty())
    val searchHeroes: StateFlow<PagingData<Hero>> = _searchHeroes

    internal fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    internal fun searchHeroes(query: String, dispatcher: CoroutineDispatcher = Dispatchers.IO) {
        viewModelScope.launch(dispatcher) {
            useCases.searchHeroesUseCase(query = query).cachedIn(viewModelScope).collect() {
                _searchHeroes.value = it
            }
        }
    }
}