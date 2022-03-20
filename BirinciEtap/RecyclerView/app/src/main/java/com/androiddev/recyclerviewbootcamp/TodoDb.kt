package com.androiddev.recyclerviewbootcamp

object TodoDb {

    fun getToDos(): ArrayList<TodoModel>{

        val todoList = arrayListOf<TodoModel>()

        todoList.add(TodoModel(1,"Alışverişe git"))
        todoList.add(TodoModel(2,"16:00 ekip toplantısı"))
        todoList.add(TodoModel(3,"Bitirme tezine çalış"))
        todoList.add(TodoModel(4,"Telefon faturasını yatır"))
        todoList.add(TodoModel(5,"Çeviriyi tamamla"))
        todoList.add(TodoModel(6,"Ödevleri hazırla"))
        todoList.add(TodoModel(7,"Bilgisayarları temizle"))
        todoList.add(TodoModel(8,"Buglara bak"))
        todoList.add(TodoModel(9,"Proje için hazırlık yap"))
        todoList.add(TodoModel(10,"Bankayı ara"))
        
        todoList.add(TodoModel(11,"Hergün 30dk spor yap"))
        todoList.add(TodoModel(12,"Hergün 30dk kitap oku"))
        todoList.add(TodoModel(13,"Hergün Mediumda bir yazı oku"))
        todoList.add(TodoModel(14,"Hergün 30dk ingilizce çalış"))
        
        return todoList

    }

}