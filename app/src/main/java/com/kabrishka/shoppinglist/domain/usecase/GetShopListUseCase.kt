package com.kabrishka.shoppinglist.domain.usecase

import androidx.lifecycle.LiveData
import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopListUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}