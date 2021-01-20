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
        Vector resultFeelsLike = new Vector<>();

        // TEMPERATURE STATS
        s = new MaxTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new MinTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new AverageTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new VarianceTemperature((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        //FEELS LIKE STATS
        s = new MaxFeelsLike((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new MinFeelsLike((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new AverageFeelsLike((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new VarianceFeelsLike((Vector<WeatherData>) weatherForecast);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new ConditionStats((Vector<WeatherData>) weatherForecast);
        s.calculateStat();


        St.put("Stats for Temperature",new JSONArray(result));
        St.put("Stats for Feels Like Temperature",new JSONArray(resultFeelsLike));
        St.put("Weather Condition Count", new JSONObject(s.ritornaCalculateStat()));



        return St.toMap();




    }

    }



