package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;


import java.util.List;
import java.util.Vector;

public class CityFilter {

    public static List<WeatherData> getFilteredCity(String city, List<WeatherData> weatherForecast) {

        List<WeatherData> FilteredList = new Vector<>();
        for (WeatherData weatherData : weatherForecast) {
            if (city.equals(weatherData.getCity())) {
                FilteredList.add(weatherData);
            }

        }
        return FilteredList;

    }
}
