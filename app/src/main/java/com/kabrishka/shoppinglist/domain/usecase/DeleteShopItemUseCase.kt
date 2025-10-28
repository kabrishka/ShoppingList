package com.kabrishka.shoppinglist.domain.usecase

import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class DeleteShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}