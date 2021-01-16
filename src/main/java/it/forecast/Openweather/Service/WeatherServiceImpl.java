package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Vector;

@Service
public class WeatherServiceImpl implements WeatherService {

    private List<WeatherData> weatherForecast = new Vector<>();

    private List<WeatherData> filteredForecast = new Vector<>();

    public WeatherServiceImpl() {
    }

    public List<WeatherData> get5ForecastWeather(String url) throws NoDataException {
        WeatherForecast_API_Call w = new WeatherForecast_API_Call();
        this.weatherForecast = w.loadCall(url);
        System.out.println(this.weatherForecast);
        if (this.weatherForecast == null || this.weatherForecast.contains("[]"))
            throw new NoDataException();
        return this.weatherForecast;
    }

   /* public List<WeatherData> get5ForecastWeatherFiltered(JSONObject bodyFilter, String url) {
        try {
            WeatherForecast_API_Call w = new WeatherForecast_API_Call();
            List<WeatherData> forecastToFilter1 = w.loadCall(url);
            List<WeatherData> forecastToFilter2 = new Vector<>();

            if (forecastToFilter1 == null)
                throw new NoDataException();

            this.filteredForecast.clear();

            Filter f0 = new Filter();
            f0.parsingFilters(bodyFilter);

            if (!f0.getFiltersName().isEmpty() && !f0.getFiltersCountry().isEmpty()) {
                for (Filter f : f0.getFiltersName()) {
                    f.toFilter(forecastToFilter1, forecastToFilter2);
                }
                for (Filter f : f0.getFiltersCountry()) {
                    f.toFilter(forecastToFilter1, forecastToFilter2);
                }
            }
            if (f0.getFiltersName().isEmpty() && !f0.getFiltersCountry().isEmpty()) {
                for (Filter f : f0.getFiltersCountry()) {
                    f.toFilter(forecastToFilter1, forecastToFilter2);
                }
            }
            if (!f0.getFiltersName().isEmpty() && f0.getFiltersCountry().isEmpty()) {
                for (Filter f : f0.getFiltersName()) {
                    f.toFilter(forecastToFilter1, forecastToFilter2);
                }
            }
            if (f0.getFiltersName().isEmpty() && f0.getFiltersCountry().isEmpty()) {
                filteredDomains = forecastToFilter1;
            }
            for (Filter f : f0.getFilters()) {
                f.toFilter(filteredForecast);
            }
        } catch (Exception e) {
            System.out.println("Generic Error");
            System.out.println("messages: " + e.getMessage());
            System.out.println("cause: " + e.getCause()); //da rivedere eccezioni
        }
        return filteredForecast;
    }

    public JSONObject getStats(String url) throws NoDataException {

        JSONObject Stat = new JSONObject();
        Stats q;
        try {
            WeatherForecast_API_Call w = new WeatherForecast_API_Call();
            weatherForecast = w.loadCall(url);
            if (this.weatherForecast == null)
                throw new NoDataException();
        } catch (Exception e) {
            System.out.println("ERRORE GENERICO in getStats().");
            System.out.println("MESSAGGIO: " + e.getMessage());
            System.out.println("CAUSA: " + e.getCause());
            throw new NoDataException();
        }

        //aggiungere nostre statistiche
        return Stat; */
    }



