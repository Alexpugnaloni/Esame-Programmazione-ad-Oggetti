package it.forecast.Openweather.Service;


import it.forecast.Openweather.Model.WeatherData;

public interface WeatherService {

	list<WeatherData> get5ForecastWeather(String url); // throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException
	list<WeatherData> get5ForecastWeatherFiltered(JSONObject bodyFilter, String url);
	list<WeatherData> getStats(String url);
}
