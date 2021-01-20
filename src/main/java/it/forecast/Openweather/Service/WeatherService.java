package it.forecast.Openweather.Service;


import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WeatherService {

	List<WeatherData> get5ForecastWeather(String url) throws IOException, ParseException, JSONException, NoDataException;
	Map<String,Object> get5StatsWeather(String url) throws IOException, ParseException, JSONException, NoDataException;
	//List<WeatherData> get5ForecastWeatherFiltered(JSONObject bodyFilter, String url);
	//List<WeatherData> getStats(String url);
}
