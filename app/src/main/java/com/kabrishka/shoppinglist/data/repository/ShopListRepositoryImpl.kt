package com.kabrishka.shoppinglist.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.kabrishka.shoppinglist.data.db.ShopListDao
import com.kabrishka.shoppinglist.data.mapper.ShopListMapper
import com.kabrishka.shoppinglist.domain.entity.ShopItem
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import javax.inject.Inject

// Данный класс можно использовать как зависимость
class ShopListRepositoryImpl @Inject constructor(
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper
) : ShopListRepository {

    // MediatorLiveData - позволяет перехватывать события из другой livedata и каким-то образом  реагировать на них
    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        // медиатор будет перехватывать объекты LiveData<List<ShopItemDbModel>>
        // addSource добавляет источник данных
        // лямбда функция будет вызвана при каждом изменении в оригинальной LiveData<List<ShopItemDbModel>>
        addSource(shopListDao.getShopList()) {
            value = mapper.mapListDbModelToListEntity(it)
        }
    }

    // аналог медиатора, если нужно перевести из одного типа в другой
//    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(shopListDao.getShopList()) {
//        mapper.mapListDbModelToListEntity(it)
//    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }
}