package com.kabrishka.shoppinglist.domain.usecase

import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}