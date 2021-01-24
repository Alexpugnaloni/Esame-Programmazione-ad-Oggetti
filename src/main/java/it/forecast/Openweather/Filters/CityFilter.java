package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

public class CityFilter {

    public static List<WeatherData> getFilteredCity(String city, List<WeatherData> weatherForecast) {

        List<WeatherData> FilteredList = new Vector<WeatherData>();
        for (int i=0; i<weatherForecast.size(); i++) {
            if (city.equals(weatherForecast.get(i).getCity())) {
                FilteredList.add(weatherForecast.get(i));
            }

        }
        return FilteredList;

    }
}
