package com.kabrishka.shoppinglist.domain.usecase

import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class EditShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}