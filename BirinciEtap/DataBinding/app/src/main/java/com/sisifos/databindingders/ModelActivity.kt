package com.sisifos.databindingders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sisifos.databindingders.databinding.ActivityModelBinding

class ModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_model)


        binding.kedi = KediModel("Leo","Tekir",1)
    }
}