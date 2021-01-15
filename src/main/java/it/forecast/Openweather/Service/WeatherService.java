package it.forecast.Openweather.Service;


import it.forecast.Openweather.Model.WeatherData;
import org.json.JSONObject;

import java.util.List;

public interface WeatherService {

	List<WeatherData> get5ForecastWeather(String url); // throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException
//	List<WeatherData> get5ForecastWeatherFiltered(JSONObject bodyFilter, String url);
//	List<WeatherData> getStats(String url);
}
