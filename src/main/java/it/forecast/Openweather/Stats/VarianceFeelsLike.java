package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class VarianceFeelsLike extends Stats{
    private double varianceTemperatureFeelsLike;

    public VarianceFeelsLike(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.varianceTemperatureFeelsLike = 0;
    }


    @Override
    public String getDate() {
        return null;
    }

    @Override
    public double getTemp() {
        return this.varianceTemperatureFeelsLike;
    }

    public void calculateStat() {

        Vector<Double> v = new Vector<Double>();
        Double sum = (double) 0, sumSquareRej = (double) 0, variance, avg;
        int size;
        for (int i = 0; i < weatherForecast.size(); i++) {
            v.add(weatherForecast.get(i).getFeels_like());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;
        for (int i = 0; i < size; i++) {

            sumSquareRej = sumSquareRej + Math.pow(v.elementAt(i) - avg, 2);
        }

        variance = sumSquareRej / size;
        varianceTemperatureFeelsLike = variance;

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("Variance_FeelsLike", getTemp());


        return St;
    }
}
