package com.kabrishka.shoppinglist.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    // абстрактный метод, возвращающий релизацию интерфеса дао
    abstract fun shopListDao(): ShopListDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        // синглтоны должны быть синхронизированы
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"

        // для получения экземляра бд нужен контекст
        // исп. application, чтобы не утекал котекст актвити
        fun getInstance(application: Application): AppDatabase {
            // проверка было ли присвоено значение
            INSTANCE?.let {
                return it
            }
            // если два потока вызвали метод getInstance
            // и в обоих была сделана проверка выше
            // то оба потока дойдут до строчки с synchronized
            // первый поток зайдет в блок ниже, а другой будет ждать
            // чтобы не было двух экземпляров бд
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }

                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}