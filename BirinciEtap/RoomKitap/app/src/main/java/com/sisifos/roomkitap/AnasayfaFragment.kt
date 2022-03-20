package com.sisifos.roomkitap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sisifos.roomkitap.databinding.FragmentAnasayfaBinding
import com.sisifos.roomkitap.room.KitapModel
import com.sisifos.roomkitap.room.KitaplikDatabase


class AnasayfaFragment : Fragment() {
    private lateinit var  binding: FragmentAnasayfaBinding
    private lateinit var  kitaplikDB: KitaplikDatabase

    private lateinit var kitapList: ArrayList<KitapModel?>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container,false)
        return binding.root


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kitaplikDB = KitaplikDatabase.getirKitaplikDatabase(requireContext())!!

        kitapList = kitaplikDB.kitaplikDao().tümKitaplar()
        tumKitaplariGoster()
    }

    fun tumKitaplariGoster(){

        binding.apply {

            if (kitapList.isEmpty()){
                Snackbar.make(requireView(), "Kitap Bulunamadı",1000).show()
            }else{
                val kitaplikAdapter = KitaplikAdapter(kitapList)
                rvKitap.adapter = kitaplikAdapter
                rvKitap.layoutManager = GridLayoutManager(context,2)
                rvKitap.setHasFixedSize(true)
            }
        }
    }


}