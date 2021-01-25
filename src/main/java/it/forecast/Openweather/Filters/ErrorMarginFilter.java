package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class ErrorMarginFilter {


    private int count;



    public List<WeatherData> calculateAccuracy(List<WeatherData> weatherForecast, List<WeatherData> futureForecast, Double accuracy){
        List<WeatherData> FilteredList = new Vector<>();
        double a,b,result;
        for(int i=weatherForecast.size()-1; i>=0;i--){
            for (WeatherData weatherData : futureForecast) {
                if (weatherForecast.get(i).getDate().compareTo(weatherData.getDate()) > 0) {
                    a = weatherForecast.get(i).getTemperature();
                    b = weatherData.getTemperature();
                    if (a >= b) result = b / a;
                    else result = a / b;
                    if (result >= accuracy) {
                        count ++;

                        FilteredList.add(weatherForecast.get(i));
                    }
                }

            }

        }

        return FilteredList;
    }

    public int getCount(){

        return count;
    }
}
