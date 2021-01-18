package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public abstract class Stats {

    List<WeatherData> weatherForecast;

    public Stats(List<WeatherData> weatherForecast){
        this.weatherForecast = weatherForecast;
    }

    public List<WeatherData> getWeatherForecast(){
        return weatherForecast;
    }
    public void setWeatherForecast(List<WeatherData> weatherForecast){
        this.weatherForecast = weatherForecast;
    }
    public int getInt() {
        return 0;
    }


    public double getDouble() {
        return 0;
    }


    public JSONObject getJSONObject() {
        return null;
    }
    public abstract Vector<WeatherData> calculateStat(Vector<WeatherData> list); //boooooooooooohhhh DOVREBBE ESSERE VOID
}
