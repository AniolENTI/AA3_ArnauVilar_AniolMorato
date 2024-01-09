package com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.Repositories

import com.enti.dostres.cdi.arnauvilar.aniolmorato.eldenring.cells.Items.ItemData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class ItemApiService : ItemRepository {

    companion object {
        const val BASE_URL = "https://eldenring.fanapis.com/api/"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$Timestamp"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        val ApiService: RetrofitItemApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitItemApiService::class.java)
        }
    }

    interface RetrofitItemApiService {
        @GET("items")
        suspend fun GetItems(
            @Query("ts") timestamp: String = Timestamp,
            @Query("hash") hash: String = Hash
        ) : Response<ItemResponseData>
    }

    override suspend fun GetItems(): MutableList<ItemData> {

        val response = ApiService.GetItems()

        println(response)

        if(response.isSuccessful) {

            response.body()?.itemList?.let { items ->
                return items
            } ?: kotlin.run {
                //Controlar el error de alguna forma
                return mutableListOf()
            }

        } else {
            //Controlar el error de alguna forma
            return mutableListOf()
        }
    }

}