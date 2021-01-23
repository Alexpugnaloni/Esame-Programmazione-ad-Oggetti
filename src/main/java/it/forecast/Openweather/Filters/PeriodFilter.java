package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Vector;

public class PeriodFilter {

    public static List<WeatherData> getFilteredPeriod(String period, List<WeatherData> weatherForecast) {

        List<WeatherData> FilteredList = new Vector<WeatherData>();
        System.out.println(weatherForecast);

        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        */
        switch (period) {

            case "day": {

               int d = weatherForecast.get(0).getDate().charAt(9);
                for ( int i = 0; i <= weatherForecast.size(); i++) {
                   if (weatherForecast.get(i).getDate().charAt(9) == d) {
                       FilteredList.add(weatherForecast.get(i));
                   }
                }

            } break;
            case "week": System.out.println("week"); break;
            case "month": System.out.println("month"); break;
        }
        return FilteredList;

        }
    }

