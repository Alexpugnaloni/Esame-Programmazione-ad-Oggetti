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



    public Vector<WeatherData> calculateStat(Vector<WeatherData> list){ //DOVREBBE ESSERE VOID
       Vector result = new Vector<WeatherData>();

        MinValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {

            WeatherData wD = list.get(i);
            if (wD.getTemperature() < MinValue.getTemperature()) {
                MinValue = wD;
            }
        }
        result.add(MinValue);
        return result;
    }
}
