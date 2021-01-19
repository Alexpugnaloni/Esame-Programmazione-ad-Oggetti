package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Stats.MaxTemperature;
import it.forecast.Openweather.Stats.MinTemperature;
import it.forecast.Openweather.Stats.Stats;
import org.json.JSONObject;
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
        if (this.weatherForecast == null || this.weatherForecast.contains("[]"))
            throw new NoDataException();

        return this.weatherForecast;
    }
    public JSONObject get5StatsWeather(String url) throws NoDataException {           //DA SISTEMARE PER STATS
        JSONObject St = new JSONObject();
        Stats s;
        try {
            WeatherForecast_API_Call c = new WeatherForecast_API_Call();
            weatherForecast = c.loadCall(url);
            if (this.weatherForecast == null)
                throw new NoDataException();
        } catch (Exception e) {
        }

        //MASSIMA
        s = new MaxTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        St.put("tempMax", s.getDouble());

        //Minima
        s = new MinTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        St.put("tempMin", s.getDouble());

        return St;

        
    }

    }



