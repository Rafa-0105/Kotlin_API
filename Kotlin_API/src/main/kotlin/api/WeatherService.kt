package api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


interface WeatherService {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("q") city:String,
        @Query("appid") apiKey:String
    ): Call<WeatherResponse>

}