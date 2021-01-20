package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.Vector;

public class MinFeelsLike extends Stats{
    private double minTemperatureFeelsLike;
    private WeatherData MinValue;
    private String date;

    public MinFeelsLike(Vector<WeatherData> weatherForecast){
        super(weatherForecast);
        this.minTemperatureFeelsLike = 0;
        this.date = null;
    }


    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public double getTemp() {
        return this.minTemperatureFeelsLike;
    }

    public void calculateStat(){

        MinValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getFeels_like() < MinValue.getFeels_like()) {
                MinValue = wD;
            }
            minTemperatureFeelsLike = MinValue.getFeels_like();
            date = MinValue.getDate();
        }

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("tempMin_FeelsLike", getTemp());

        St.put("tempMinDate_FeelsLike",getDate());

        return St;
    }
}
