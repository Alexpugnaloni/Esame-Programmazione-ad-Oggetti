package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class MaxFeelsLike extends Stats{
    private double maxTemperatureFeelsLike;
    private WeatherData MaxValue;
    private String date;

    public MaxFeelsLike(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.maxTemperatureFeelsLike = 0;
        this.date = null;
    }
    @Override
    public double getTemp(){
        return this.maxTemperatureFeelsLike; }
    @Override
    public String getDate(){
        return  this.date;

    }



    public void calculateStat(){

        MaxValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {
            WeatherData wD = weatherForecast.get(i);
            if (wD.getFeels_like() > MaxValue.getFeels_like()) {
                MaxValue = wD;
            }
        }
        maxTemperatureFeelsLike = MaxValue.getFeels_like();
        date = MaxValue.getDate();

    }

    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("tempMax_FeelsLike", getTemp());

        St.put("tempMaxDate_FeelsLike",getDate());

        return St;
    }
}
