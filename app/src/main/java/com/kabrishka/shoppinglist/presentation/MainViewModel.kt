package com.kabrishka.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kabrishka.shoppinglist.data.ShopListRepositoryImpl
import com.kabrishka.shoppinglist.domain.DeleteShopItemUseCase
import com.kabrishka.shoppinglist.domain.EditShopItemUseCase
import com.kabrishka.shoppinglist.domain.GetShopListUseCase
import com.kabrishka.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {
    // не должны зависить от Data
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        var newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}