package com.kabrishka.shoppinglist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


// ViewModelFactory - синглтон
// Оборачиваем map value ViewModel в Provider, т.к:
// 1. Откладывает создание объекта до момента вызова .get()
// 2. При повороте экрана Activity/Fragment пересоздается и нужен новый ViewModel,
// без Provider использовались бы старые
class ViewModelFactory @Inject constructor(
    private val viewModelProviders: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModelProviders[modelClass]
            ?: throw IllegalArgumentException("ViewModel $modelClass not found")
        return provider.get() as T
    }
}