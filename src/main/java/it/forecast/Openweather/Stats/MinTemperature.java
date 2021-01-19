package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class MinTemperature extends Stats{
    private double minTemperature;
    private WeatherData MinValue;

    public MinTemperature(Vector<WeatherData> weatherForecast){
        super(weatherForecast);
        this.minTemperature = 0;
    }

    public double getDouble(){
        return this.minTemperature;
    }



    public Vector<WeatherData> calculateStat(){ //DOVREBBE ESSERE VOID
       Vector result = new Vector<WeatherData>();

        MinValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() < MinValue.getTemperature()) {
                MinValue = wD;
            }
        }
        result.add(MinValue);
        return result;
    }
}
