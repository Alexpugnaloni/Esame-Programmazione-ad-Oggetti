package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class AverageTemperature extends Stats {
    private double averageTemperature;

    public AverageTemperature(Vector<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageTemperature = 0;
    }

    public double getDouble() {
        return this.averageTemperature;
    }


    public Vector<WeatherData> calculateStat() {
        Vector<Double> v = new Vector<Double>();
        Double sum = (double) 0, avg;
        int size;
        for (int i = 0; i < weatherForecast.size(); i++) {
            v.add(weatherForecast.get(i).getTemperature());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;

        Vector<WeatherData> WeatherDataAverage = new Vector<WeatherData>();
        WeatherData finalAverage = new WeatherData();

        finalAverage.setTemperature(avg);
        WeatherDataAverage.add(finalAverage);
        return WeatherDataAverage;
    }
}