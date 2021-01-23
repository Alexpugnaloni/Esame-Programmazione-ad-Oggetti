package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class AverageFeelsLike extends Stats{
    private double averageFeelsLike;


    public AverageFeelsLike(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageFeelsLike = 0;

    }


    @Override
    public String getDate() {
        return null;
    }

    @Override
    public double getTemp() {
        return this.averageFeelsLike;
    }

    public void calculateStat() {
        Vector<Double> v = new Vector<Double>();
        Double sum = (double) 0, avg;
        int size;
        for (int i = 0; i < weatherForecast.size(); i++) {
            v.add(weatherForecast.get(i).getFeels_like());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;

        averageFeelsLike = avg;

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("Average_FeelsLike", getTemp());

        return St;

    }
}
