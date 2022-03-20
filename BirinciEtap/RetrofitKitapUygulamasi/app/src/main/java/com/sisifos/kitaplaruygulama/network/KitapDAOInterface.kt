package com.sisifos.kitaplaruygulama.network

import android.telecom.Call
import com.sisifos.kitaplaruygulama.response.KitaplarResponse
import retrofit2.http.GET

interface KitapDAOInterface {
    //interface bir işin nasıl yapılacağını gösteren şablonlardır
    //İnterface, burdan bir obje oluşturmak yerine, burdad yaptığımız işlemleri diğer tarafta kullanabiliyorduk

    //biz retrofitin http isteklerini kullanarak server ile nasıl iletişim kullanıcağını anlatıcaz
    //get, put, post, delete bu metotları kullanarak istek oluşturduğumuz kısım diyebiliriz
    //bu fonksiyon çalıştığında retrofit "all_books.php" bu kısmı alıp, base url sonuna yapıştıracak ve istediğimiz kaynağa gidecek

    @GET("all_books.php") //base url den sonraki yapıyı kopyalıcaz
    fun kitaplariAl() : retrofit2.Call<KitaplarResponse>
    //call retrofit işleme isteği başlatırken kullanılır
    //bizim ne tarz bir cevap istediğimizi call objesiyle gönderecez
    //call mainthread yani kullanıcı arayüzünü bloklamadan verlieri internetden indirirken yapcağımız işlem
    //call yerine RX JAVA ile de kullanılabiliyor

}