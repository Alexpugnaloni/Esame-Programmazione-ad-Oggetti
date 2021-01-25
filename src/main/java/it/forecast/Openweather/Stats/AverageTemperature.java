package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class AverageTemperature extends Stats {
    private double averageTemperature;


    public AverageTemperature(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageTemperature = 0;

    }


    @Override
    public String getDate() {
        return null;
    }

    @Override
    public double getTemp() {
        return this.averageTemperature;
    }

    public void calculateStat() {
        Vector<Double> v = new Vector<>();
        double sum = 0, avg;
        int size;
        for (WeatherData weatherData : weatherForecast) {
            v.add(weatherData.getTemperature());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;

        averageTemperature = avg;

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("Average", getTemp());

        return St;

    }

}