package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Stats.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
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
    public Map<String, Object> get5StatsWeather(String url) throws NoDataException {           //DA SISTEMARE PER STATS
        JSONObject St = new JSONObject();
        Stats s;
        try {
            WeatherForecast_API_Call c = new WeatherForecast_API_Call();
            weatherForecast = c.loadCall(url);
            if (this.weatherForecast == null)
                throw new NoDataException();
        } catch (Exception e) {
        }

        Vector result = new Vector<>();

        s = new MaxTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());
        St.put("MaxStats",new JSONArray(result));


        result = new Vector<>();
        s = new MinTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());
        St.put("MinStats",new JSONArray(result));

        result = new Vector<>();
        s = new AverageTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());
        St.put("Average",new JSONArray(result));

        result = new Vector<>();
        s = new VarianceTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());
        St.put("Variance", new JSONArray(result));


        return St.toMap();




    }

    }



