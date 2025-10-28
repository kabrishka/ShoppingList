package com.kabrishka.shoppinglist.di

import android.app.Application
import com.kabrishka.shoppinglist.data.db.AppDatabase
import com.kabrishka.shoppinglist.data.db.ShopListDao
import com.kabrishka.shoppinglist.data.repository.ShopListRepositoryImpl
import com.kabrishka.shoppinglist.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    // Явно указываем реализацию, т.к. dagger не выбирает ее автоматически
    // Binds связывает интерфейс с реализацией
    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}