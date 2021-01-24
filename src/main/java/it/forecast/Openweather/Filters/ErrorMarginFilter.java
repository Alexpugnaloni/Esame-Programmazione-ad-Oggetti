package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class ErrorMarginFilter {


    static int count=0;

    public static List<WeatherData> calculateAccuracy(List<WeatherData> weatherForecast, List<WeatherData> futureForecast, Double accuracy){
        List<WeatherData> FilteredList = new Vector<WeatherData>();
        double a,b,result;
        for(int i=weatherForecast.size()-1; i>=0;i--){
            for(int j=0; j<futureForecast.size();j++){
                if(weatherForecast.get(i).getDate().compareTo(futureForecast.get(j).getDate())>0){
                   a= (double) weatherForecast.get(i).getTemperature();
                   b= (double) futureForecast.get(j).getTemperature();
                   if(a>=b)  result = b/a;
                   else result = a/b;
                   System.out.println(result);
                   if(result>=accuracy) {
                       count++;
                       FilteredList.add(weatherForecast.get(i));
                   }
                }

            }

        }
        return FilteredList;
    }

    public static int getCount(){
        return count;
    }
}
