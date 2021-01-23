package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Vector;


public class MaxTemperature extends Stats {

    private double maxTemperature;
    private WeatherData MaxValue;
    private String date;

    public MaxTemperature(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.maxTemperature = 0;
        this.date = null;
    }
@Override
    public double getTemp(){
        return this.maxTemperature; }
    @Override
    public String getDate(){
        return  this.date;

    }



    public void calculateStat(){

        MaxValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {
            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() > MaxValue.getTemperature()) {
                MaxValue = wD;
            }
        }
        maxTemperature = MaxValue.getTemperature();
        date = MaxValue.getDate();

    }

    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("tempMax", getTemp());

        St.put("tempMaxDate",getDate());

        return St;
    }

}
