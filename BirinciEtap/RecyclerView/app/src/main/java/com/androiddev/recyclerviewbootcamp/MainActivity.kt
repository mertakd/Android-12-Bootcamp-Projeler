package com.androiddev.recyclerviewbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddev.recyclerviewbootcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val  todoAdapter by lazy { TodoAdapter() }
    //bu sayfa açıldığında bunun nesnesini bir kere üret ve bir daha tekrar tekrar bu adapteri bir daha oluşturma böylece daha performasnlı bir yapı oluşturmuş oluyoruz


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val todoList = TodoDb.getToDos()
        //todo db den nesne yaratmama gerek kalmadı object olduğu için direk çağırabildim.

        //todoAdapter.updateList(todoList)

        binding.rvTodos.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = todoAdapter
        }

        /*todoAdapter.onToDoClick = {
            /*
            -recyclerview a ait işlemler adapter da yapılıyor
            -recyclerview dışındaki kapsamındaki işlemler mesela textview işlemi mainactivity de yapılıyor.
            -bunun içinde arada bir bağlantı, köprü kurmamız gerekiyor. bunun içinde listener lar var. interface ile yada highoreder function lar la yapılıyor en kolayı highorder .
             */
            println(it.todoText)
        }

         */

        todoAdapter.submitList(todoList)


    }
}