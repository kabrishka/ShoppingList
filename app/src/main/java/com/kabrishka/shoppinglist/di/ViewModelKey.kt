package com.kabrishka.shoppinglist.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

// MapKey - позволяет безопасно связывать зависимости в Map(@IntoMap),
// избегая проблем с обфускацией
// Например, @StringKey("MyViewModel") может сломаться после ProGuard/R8
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
