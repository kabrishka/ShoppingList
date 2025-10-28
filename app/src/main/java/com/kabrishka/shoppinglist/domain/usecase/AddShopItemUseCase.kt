package com.kabrishka.shoppinglist.domain.usecase

import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}