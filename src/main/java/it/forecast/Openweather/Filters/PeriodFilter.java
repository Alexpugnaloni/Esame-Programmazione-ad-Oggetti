package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Vector;

public class PeriodFilter {

    public static List<WeatherData> getFilteredPeriod(String period, List<WeatherData> weatherForecast) {

        List<WeatherData> FilteredList = new Vector<WeatherData>();

        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        */

        switch (period) {

            case "day": System.out.println("day"); break;
            case "week": System.out.println("week"); break;
            case "month": System.out.println("month"); break;
        }
        return FilteredList;

        }
    }

