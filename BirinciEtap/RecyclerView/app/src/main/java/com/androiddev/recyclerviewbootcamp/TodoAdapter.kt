package com.androiddev.recyclerviewbootcamp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.recyclerviewbootcamp.databinding.TodoItemDesignBinding

class TodoAdapter(): ListAdapter<TodoModel, TodoAdapter.TodoViewHolder>(TodoDiffUtilCallBack()){
    //RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() bu artık kullanılmıyor diffutiden dolayı


    var onToDoClick: (TodoModel) -> Unit = {}
    //highorder function
    //todomodel versini mainactivity içinde kullanmamızı sağlıyor

    private val todoList = arrayListOf<TodoModel>()
    //TodoAdapter constructorun da tanımlamıyoruz sürekli güncellememek için



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        //viewholder ın aslında oluşturulduğu yer

        val todoItemDesignBinding = TodoItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(todoItemDesignBinding)

    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        /*
        -holder todoadapter daki todoviewholder ı getiriyor böylece bind fonksiyonu çağırılıyor
        -bind listeyi değil o anki todo yu istiyor position a göre
        -sırayla listenin içindeki her bir elemanı, TodoViewHolder içindeki bind ın içine göndermiş oluyoruz.
        -burayı for döngüsü gibi düşünebiliriz
        -120 tane ıtem var diyelim recyclerview ın içine bunları teker teker yerleştiriyor for döngüsü misali
        -ilk eleamnı aldı bunu TodoViewHolder a gönderdi, sonra bu veri xml in içine gitti, data binding de bu veriyi alır TextView wideget ına yazdırır.
        -sonra tekrar tekrar bu işlemler devam eder
         */

        val todo = getItem(position)
        holder.bind(todo)
        //holder.bind(todoList[position])
    }



    inner class TodoViewHolder(private val todoItemDesignBinding: TodoItemDesignBinding):RecyclerView.ViewHolder(todoItemDesignBinding.root) {
        /*
        tasarımı çağırdığımız ve işlemler yaptığımız sınıf burası olacak.
        Viewjolder olarak return yapayoruz yukarda kullanabilmek için todoadapter da yani

        class olduğu için globaldeki değişkeni burada göremiyorum, inner class yaparsak görebiliriz.
        -inner class subbclass ı oluyor todoadapter ın

         */

        fun bind(todo: TodoModel){
            //her bir todu yu bu fonksiyona göndericez
            //todoItem databindigi işaret ediyor
            todoItemDesignBinding.todoItem = todo

            /*todoItemDesignBinding.cbTodo.setOnCheckedChangeListener { compoundButton, check ->
                if (check){
                    //check true ise demek
                    onToDoClick(todo)

                }
            }

             */


        }

    }

    //override fun getItemCount(): Int = todoList.size
    /*fun updateList(updatedList: List<TodoModel>){
        todoList.clear()
        todoList.addAll(updatedList)
        notifyDataSetChanged()
        //notifyDataSetChanged metodunda tek bir veriyi güncellemiyor 1500 veri var diyelim bu 1500 veriyi beraber güncelliyor. bu sağlıklı bir yöntem değil
        //bunun yerine diffutil kullanmak daha performasnlı oluyor
    }

     */


}