package it.forecast.Openweather.Service;

import it.forecast.Openweather.Database.Database;
import it.forecast.Openweather.Database.DatabaseFutureCalls;
import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Filters.CityFilter;
import it.forecast.Openweather.Filters.ErrorMarginFilter;
import it.forecast.Openweather.Filters.PeriodFilter;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Stats.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Service
public class WeatherServiceImpl implements WeatherService {

    private List<WeatherData> weatherForecast = new Vector<>();
    private List<WeatherData> futureForecast = new Vector<>();


    public List<WeatherData> get5ForecastWeather(String url) throws NoDataException {
        WeatherForecast_API_Call w = new WeatherForecast_API_Call();
        this.weatherForecast = w.loadCall(url);
        if (this.weatherForecast == null || this.weatherForecast.contains("[]"))
            throw new NoDataException();

        return this.weatherForecast;
    }





    public Map<String, Object> getStats(String city,String period) throws NoDataException {

        JSONObject St = new JSONObject();
        Stats s;

        try {
            weatherForecast = Database.getWeatherforecast();
            if (this.weatherForecast == null)
                throw new NoDataException();
        } catch (Exception e) {
        }

        if (city.equals("")) {}
        else weatherForecast = CityFilter.getFilteredCity(city, weatherForecast);
        List<WeatherData> weatherStats = PeriodFilter.getFilteredPeriod(period, weatherForecast);

        Vector result = new Vector<>();
        Vector resultFeelsLike = new Vector<>();

        // TEMPERATURE STATS
        s = new MaxTemperature(weatherStats);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new MinTemperature(weatherStats);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new AverageTemperature(weatherStats);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        s = new VarianceTemperature(weatherStats);
        s.calculateStat();
        result.add(s.ritornaCalculateStat());

        //FEELS LIKE STATS
        s = new MaxFeelsLike(weatherStats);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new MinFeelsLike(weatherStats);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new AverageFeelsLike(weatherStats);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new VarianceFeelsLike(weatherStats);
        s.calculateStat();
        resultFeelsLike.add(s.ritornaCalculateStat());

        s = new ConditionStats(weatherStats);
        s.calculateStat();


        St.put("Stats for Temperature",new JSONArray(result));
        St.put("Stats for Feels Like Temperature",new JSONArray(resultFeelsLike));
        St.put("Weather Condition Count", new JSONObject(s.ritornaCalculateStat()));




        return St.toMap();




    }


    public Map<String, Object> getAccuracy(String city, Double accuracy) throws IOException, ParseException, JSONException, NoDataException {
        JSONObject St = new JSONObject();
        ErrorMarginFilter marginFilter = new ErrorMarginFilter();

        try {
            weatherForecast = Database.getWeatherforecast();
            futureForecast = DatabaseFutureCalls.getWeatherforecast();
            if (this.weatherForecast == null || this.futureForecast == null)
                throw new NoDataException();

        } catch (Exception e) {
        }
        if (city.equals("")) {}
        else { weatherForecast = CityFilter.getFilteredCity(city, weatherForecast); futureForecast = CityFilter.getFilteredCity(city, futureForecast); }

        St.put("List of correct forecasts",new JSONArray(marginFilter.calculateAccuracy(weatherForecast,futureForecast,accuracy)));
        St.put("Amount of correct forecasts", marginFilter.getCount());

       return St.toMap();
    }

}



