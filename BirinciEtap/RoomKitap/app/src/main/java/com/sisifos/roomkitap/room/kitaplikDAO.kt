package com.sisifos.roomkitap.room

import androidx.room.*


@Dao
interface kitaplikDAO {

    @Insert
    fun kitapEkle(kitap: KitapModel)

    @Update
    fun kitapGuncelle(kitap: KitapModel)

    @Delete
    fun kitapSil(kitap: KitapModel)

    @Query("SELECT * FROM kitaplık")
    fun tümKitaplar() : ArrayList<KitapModel?>
}