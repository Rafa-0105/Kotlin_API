package api

data class MainData(
    val temp: Double,
    val humidity: Int
)

data class WeatherData(
    val description: String,
    val icon: String
)

data class WeatherResponse(
    val main: MainData,
    val weather: List<WeatherData>
)