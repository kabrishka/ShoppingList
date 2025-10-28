package com.kabrishka.shoppinglist.di

import javax.inject.Scope


// Время жизни аннотации singleton не понятно
// сама по себе ничего не делает
// Компонент определяет фактическое время жизни через привязку к жизненному циклу конкретного объекта
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
