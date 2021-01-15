package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Vector;

@Service
public class WeatherServiceImpl implements WeatherService{

    private List<WeatherData> weatherForecast= new Vector<>();

//  private List<WeatherData> filteredForecast = new Vector<>();

    public WeatherServiceImpl() { }

    public List<WeatherData> get5ForecastWeather(String url) throws NoDataException {
        WeatherForecast_API_Call w = new WeatherForecast_API_Call();
        this.weatherForecast=w.loadCall(url);
        System.out.println(this.weatherForecast);
        if(this.weatherForecast== null || this.weatherForecast.contains("[]"))
            throw new NoDataException();
        return this.weatherForecast;
    }


    //MANCANO GET DI FILTER E STATS
}
