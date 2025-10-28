package com.kabrishka.shoppinglist.data

import com.kabrishka.shoppinglist.domain.ShopItem
import javax.inject.Inject


class ShopListMapper @Inject constructor() {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModel(
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enabled = shopItem.enabled
        )

    fun mapDbModelToEntity(shopItem: ShopItemDbModel) = ShopItem(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}