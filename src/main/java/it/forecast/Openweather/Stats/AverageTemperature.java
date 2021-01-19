package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class AverageTemperature extends Stats {
    private double averageTemperature;
    private String date;

    public AverageTemperature(Vector<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageTemperature = 0;
        this.date = null;
    }


    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public double getTemp() {
        return this.averageTemperature;
    }

    public void calculateStat() {
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

     //   Vector<WeatherData> WeatherDataAverage = new Vector<WeatherData>();
        WeatherData finalAverage = new WeatherData();

        averageTemperature = finalAverage.getTemperature();
        date = finalAverage.getDate();
      //  finalAverage.setTemperature(avg);
      //   WeatherDataAverage.add(finalAverage);

    }

}