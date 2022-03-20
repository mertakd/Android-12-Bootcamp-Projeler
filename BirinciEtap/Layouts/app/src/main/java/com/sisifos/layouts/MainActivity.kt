package com.sisifos.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sisifos.layouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    //Themes, color primary toolbar rengini ifade ediyor.color da purple_500 renginde
    //Themes, statusbar color ise toolbar ın ustundeki küçük yer

    //Toolbar kaldırma
    //Themes da windowActionBar false yap
    //windowNoTitle true yap(yazıyı kaldırıyor)

    fun bahsisHesapla(){
        val hizmetBedeliString = binding.hizmetBedeliEditText.text.toString()

        val tutar = hizmetBedeliString.toDouble()

        val secilenRadioButton = binding.bahsisSecenekleriRadioGroup.checkedRadioButtonId

        val bahsisYüzdesi = when(secilenRadioButton){

            R.id.yüzde_yirmi_radio_button -> 0.20
            R.id.yüzde_onsekiz_radio_button -> 0.18
            else -> 0.15
        }

        var bahsis = bahsisYüzdesi * tutar

        val yukariYuvarla = binding.bahsisYukariYuvarlaSwith.isChecked

        if (yukariYuvarla){
            bahsis = kotlin.math.ceil(bahsis)
        }

        binding.bahsisTutariTextView.text = "$bahsis "
    }
}