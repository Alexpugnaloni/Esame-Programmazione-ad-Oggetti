package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;


import java.util.List;
import java.util.Vector;

/**
 * Classe che contiene filtro per la città.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class CityFilter {
    /**
     * Metodo che filtra le chiamate salvate in base alla città.
     * @param city città di cui ottenere le chiamate.
     * @param weatherForecast vettore di chiamate.
     * @return vettore filtrato.
     */

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
