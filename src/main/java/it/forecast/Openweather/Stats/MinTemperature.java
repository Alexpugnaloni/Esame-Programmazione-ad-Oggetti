package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class MinTemperature extends Stats{
    private double minTemperature;
    private WeatherData MinValue;
    private String date;

    public MinTemperature(Vector<WeatherData> weatherForecast){
        super(weatherForecast);
        this.minTemperature = 0;
        this.date = null;
    }


    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public double getTemp() {
        return this.minTemperature;
    }

    public void calculateStat(){

        MinValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() < MinValue.getTemperature()) {
                MinValue = wD;
            }
            minTemperature = MinValue.getTemperature();
            date = MinValue.getDate();
        }


    }
}
