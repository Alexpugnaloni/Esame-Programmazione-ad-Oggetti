package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class AverageTemperature extends Stats {
    private double averageTemperature;


    public AverageTemperature(Vector<WeatherData> weatherForecast) {
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

        averageTemperature = avg;

    }
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();
        // calculateStat();
       // returnCalculateStat().get(averageTemperature);
        St.put("Average", getTemp());
      //  System.out.println(St); //QUA FUNZIONA
        return St;

    }

}