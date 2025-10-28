package com.kabrishka.shoppinglist.di

import androidx.lifecycle.ViewModel
import com.kabrishka.shoppinglist.presentation.MainViewModel
import com.kabrishka.shoppinglist.presentation.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

// Используется, когда нельзя повесить на класс @Inject
// Например, различные ViewModel
@Module
interface ViewModelModule {

    // IntoMap - механизм, который собирает объекты в Map, где:
    // key - аннотация, например, ViewModelKey
    // value - внедряемое значение
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemViewModel): ViewModel
}