package com.sisifos.roomkitap.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [KitapModel::class], version = 1)
abstract class KitaplikDatabase : RoomDatabase() {

    abstract fun kitaplikDao(): kitaplikDAO

    companion object{
        //bir tane database oluşturulmasını istediğimiz için companion object
        //yani bir tane instance oluşturacaz
        //eğer daha önce instance ı yoksa oluştur, eğer instance varsa var olan veri tabanını getir

        private var INSTANCE: KitaplikDatabase? = null

        fun getirKitaplikDatabase(context: Context): KitaplikDatabase? {

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    KitaplikDatabase::class.java,
                    "kitaplik.db")
                    .allowMainThreadQueries()
                    .build()
                //Eğer instance null ise database imiz oluşturuluyor
            }

            return INSTANCE
            //nul değilse var olan database i döndür
        }



    }


}