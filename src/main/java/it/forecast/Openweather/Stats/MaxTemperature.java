package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;



public class MaxTemperature extends Stats {

    private double maxTemperature;
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

        WeatherData maxValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {
            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() > maxValue.getTemperature()) {
                maxValue = wD;
            }
        }
        maxTemperature = maxValue.getTemperature();
        date = maxValue.getDate();

    }

    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("tempMax", getTemp());

        St.put("tempMaxDate",getDate());

        return St;
    }

}
