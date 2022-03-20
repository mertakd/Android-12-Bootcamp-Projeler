package com.begumyolcu.urunlerroomapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UrunModel::class], version = 1, exportSchema = false)
abstract class UrunlerDatabase : RoomDatabase() {

    /**
     * veri tabanının tek bir instance si oluşması gerekiyor.
     * birçok kez oluşursa veri tabanımızı düzgün çalışmaz
     * veriler çoklanabilir
     * komple veritabanı çökebilir aynı anda işlemler yapılmaya çalışıldığında
     * o yüzden tek bir instance oluşturulması lazım
     */

    /**
     * abstract class da benzer özellikleri olan nesneleri bir yapı altında topluyoruz
     * ama interface de sadece metotların tanımı bulunuyor
     * bir sınıf birden fazla interface i imlement edebiliyor
     */

    abstract val urunlerDao : UrunlerDao

    companion object {

        @Volatile
        private var INSTANCE: UrunlerDatabase? = null

        fun getUrunlerDatabase(context: Context) : UrunlerDatabase? {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UrunlerDatabase::class.java,
                        "urunler_database"
                    )
                        .fallbackToDestructiveMigration() //eski şemayı yani verileri yok et
                        .build()

                    INSTANCE = instance
                }
                return INSTANCE
            }
        }
    }
}