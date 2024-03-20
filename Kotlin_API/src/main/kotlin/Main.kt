import api.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(WeatherService::class.java)

    val weatherCall = service.getCurrentWeather("São Paulo", "0b056fe8c4eab7373b6a5a64fad4d9fc")
    val response = weatherCall.execute()

    if (response.isSuccessful) {
        val weatherResponse = response.body()
        val temperaturaCelsius = weatherResponse?.main?.temp?.minus(273.15)
        println("Temperatura: ${temperaturaCelsius?.format(2)} °C")
        println("Descrição: ${weatherResponse?.weather?.get(0)?.description}")
    } else {
        println("Erro ao consultar a API")
    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)