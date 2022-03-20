package com.androiddev.recyclerviewbootcamp

import androidx.recyclerview.widget.DiffUtil

class TodoDiffUtilCallBack: DiffUtil.ItemCallback<TodoModel>() {
    /*
   -Bizim için eklenen itemların hem ıd sini hem tüm verilerini eşleştirmeye çalışıp ona göre ya eklenen veriyi güncelliyor ya da eklenen veriler aynıysa güncelleme yapmıyor
   -yanı notifydatasetchange e göre daha performanslı
    */
    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem.todoId == newItem.todoId
        //10 veri var diyelim 1 veri daha elecek ve 11 veri olacak. yani burada sadece bir veri ekliyor tüm verileri güncellemeden
        //benzersiz ıd sini ele alıyor hurada
    }

    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return oldItem == newItem
        //içeriğini kontrol ediyor
    }

}