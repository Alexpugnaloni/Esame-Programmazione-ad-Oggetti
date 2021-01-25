package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

public class MinTemperature extends Stats{
    private double minTemperature;
    private String date;

    public MinTemperature(List<WeatherData> weatherForecast){
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

        WeatherData minValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() < minValue.getTemperature()) {
                minValue = wD;
            }
            minTemperature = minValue.getTemperature();
            date = minValue.getDate();
        }

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("tempMin", getTemp());

        St.put("tempMinDate",getDate());

        return St;
    }
}
