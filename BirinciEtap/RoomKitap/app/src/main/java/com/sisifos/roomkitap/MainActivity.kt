package com.sisifos.roomkitap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sisifos.roomkitap.room.KitaplikDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var  kitaplikDB: KitaplikDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kitaplikDB = KitaplikDatabase.getirKitaplikDatabase(this)!!

    }
}