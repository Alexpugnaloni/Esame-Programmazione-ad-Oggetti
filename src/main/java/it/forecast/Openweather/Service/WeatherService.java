package it.forecast.Openweather.Service;


import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WeatherService {

	List<WeatherData> get5ForecastWeather(String url) throws IOException, ParseException, JSONException, NoDataException;
	Map<String,Object> getStats(String city, String period) throws IOException, ParseException, JSONException, NoDataException;
	Map<String,Object> getAccuracy (String city, Double accuracy) throws IOException, ParseException, JSONException, NoDataException;

}
