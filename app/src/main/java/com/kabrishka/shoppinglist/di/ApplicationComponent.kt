package com.kabrishka.shoppinglist.di

import android.app.Application
import com.kabrishka.shoppinglist.presentation.view.MainActivity
import com.kabrishka.shoppinglist.presentation.view.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

// Интерфейс для построения графа зависимостей
// Компонент, привязанный к жизненному циклу Application
// Компонент определяет фактическое время жизни через привязку к жизненному циклу конкретного объекта
@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity) // В MainActivity будет внедряться ViewModelModule

    fun inject(fragment: ShopItemFragment) // В ShopItemFragment будет внедряться ViewModelModule

    @Component.Factory
    interface Factory {

        fun create(
          @BindsInstance application: Application
        ): ApplicationComponent
    }
}