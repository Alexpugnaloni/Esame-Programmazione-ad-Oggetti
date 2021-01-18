package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.Vector;


public class MaxTemperature extends Stats {

    private double maxTemperature;

    public MaxTemperature(Vector<WeatherData> weatherForecast){
        super(weatherForecast);
        this.maxTemperature = 0;
    }

    public double getDouble(){
        return this.maxTemperature;
    }

    public Vector<WeatherData> calculateStat(){
       Vector result = new Vector<WeatherData>();
        MaxValue = weatherForecast.get(0);
        for (int i = 1; i < list.size(); i++) {
            WeatherData wD = list.get(i);
            if (wD.getTemperature() > MaxValue.getTemperature()) {
                MaxValue = wD;
            }
        }
        result.add(MaxValue);
        return result;

    }


}
