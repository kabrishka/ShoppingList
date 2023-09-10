package com.kabrishka.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kabrishka.shoppinglist.data.ShopListRepositoryImpl
import com.kabrishka.shoppinglist.domain.DeleteShopItemUseCase
import com.kabrishka.shoppinglist.domain.EditShopItemUseCase
import com.kabrishka.shoppinglist.domain.GetShopListUseCase
import com.kabrishka.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // не должны зависить от Data
    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    // CoroutineContext
    // описывает на каком потоке будет выполн. корутина
    // как реагировать на ошибки, отмену корутины и тд
    // для viewmodel был придуман viewModelScope
//    private val scope = CoroutineScope(Dispatchers.Main)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }

    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            var newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}