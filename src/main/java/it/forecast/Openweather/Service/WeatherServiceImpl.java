package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.City;
import it.forecast.Openweather.Model.WeatherData;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

@Service
public class WeatherServiceImpl implements WeatherService {

    private List<WeatherData> weatherForecast = new Vector<>();

    private List<WeatherData> weatherStats = new Vector<>();
    //private List<WeatherData> filteredForecast = new Vector<>();

    public WeatherServiceImpl() {
    }

    public List<WeatherData> get5ForecastWeather(String url) throws NoDataException {
        WeatherForecast_API_Call w = new WeatherForecast_API_Call();
        this.weatherForecast = w.loadCall(url);
        System.out.println(this.weatherForecast);                                           //COMMENTO PERCHE' INUTILE STAMPA QUA SOTTO
        if (this.weatherForecast == null || this.weatherForecast.contains("[]"))
            throw new NoDataException();
        return this.weatherForecast;
    }
    public List<WeatherData> get5StatsWeather(String url) throws NoDataException{           //DA SISTEMARE PER STATS
        WeatherForecast_API_Call w = new WeatherForecast_API_Call();
        this.weatherStats = w.loadCall(url);
        System.out.println(this.weatherStats);
        if(this.weatherStats == null || this.weatherStats.contains("[]"))
            throw new NoDataException();
        return this.weatherStats;
    }

    }



