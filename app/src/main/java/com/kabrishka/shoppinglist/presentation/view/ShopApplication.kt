package com.kabrishka.shoppinglist.presentation.view

import android.app.Application
import com.kabrishka.shoppinglist.di.DaggerApplicationComponent

class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}