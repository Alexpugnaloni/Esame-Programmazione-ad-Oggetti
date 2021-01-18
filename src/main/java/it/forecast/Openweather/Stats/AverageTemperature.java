package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

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
        Vector<Double> v2 = new Vector<Double>();
        Double sum2 = (double) 0, avg2;
        int sizeAvg;
        for (int i = 0; i < list.size(); i++) {
            v2.add(list.elementAt(i).getTemperature());
        }
        sizeAvg = v2.size();
        for (int i = 0; i < sizeAvg; i++) {
            sum2 = sum2 + v2.elementAt(i);
        }
        avg = sum2 / sizeAvg;
        for (int i = 0; i < sizeAvg; i++) {
            sum2 = sum2 + v2.elementAt(i);
        }

        avg2 = sum2 / sizeAvg;
        Vector<WeatherData> WeatherDataAverage = new Vector<WeatherData>();
        WeatherData finalAverage = new WeatherData();

        finalAverage.setTemperature(avg2);
        WeatherDataAverage.add(finalAverage);
        return WeatherDataAverage;
    }
}