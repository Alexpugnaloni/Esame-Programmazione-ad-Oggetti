package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.Vector;

public class VarianceTemperature extends Stats {
    private double varianceTemperature;
    private String date;

    public VarianceTemperature(Vector<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.varianceTemperature = 0;
        this.date = null;
    }

    public double getDouble() {
        return this.varianceTemperature;
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public double getTemp() {
        return 0;
    }

    public void calculateStat() {

        Vector<Double> v = new Vector<Double>();
        Double sum = (double) 0, sumSquareRej = (double) 0, variance, avg;
        int size;
        for (int i = 0; i < weatherForecast.size(); i++) {
            v.add(weatherForecast.get(i).getTemperature());
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
        Vector<WeatherData> WeatherDataVariance = new Vector<WeatherData>();
        WeatherData finalVariance = new WeatherData();

        finalVariance.setTemperature(variance);
        WeatherDataVariance.add(finalVariance);

    }
}