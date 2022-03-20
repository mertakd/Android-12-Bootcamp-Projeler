package com.sisifos.kitaplaruygulama.network

class ApiUtils {

    companion object{

        private const val BASE_URL ="http://books.canerture.com/"

        fun kitaplarDAOInterfaceGetir() : KitapDAOInterface{ //retrofit servisimizi çağırıyor bu interface
            return RetrofitClient.getClient(BASE_URL).create(KitapDAOInterface::class.java)
            //retrofit objemizi oluşturduk
            //retrofit servisimizi çağırabilmek,kullanabilmek  için bu sınıfı yazdık


            //kitap dao interface döndürecek, yani bizim interface deki isteklerimizi çekip retrofite göndericek
        }
    }
}