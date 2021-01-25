package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

public class ErrorMarginFilter {


    private int count;



    public List<WeatherData> calculateAccuracy(List<WeatherData> weatherForecast, List<WeatherData> futureForecast, Double accuracy, String param) {

        List<WeatherData> FilteredList = new Vector<>();
        double a, b, result;

        switch (param) {

            case "temperature": {
                for (WeatherData data : weatherForecast) {
                    for (WeatherData weatherData : futureForecast) {
                        if (data.getDate().compareTo(weatherData.getDate()) > 0) {
                            a = data.getTemperature();
                            b = weatherData.getTemperature();
                            if (a >= b) result = b / a;
                            else result = a / b;
                            if (result >= accuracy) {
                                count++;

                                FilteredList.add(data);
                            }
                        }

                    }

                }

                return FilteredList;
            }
            case "humidity": {
                for (WeatherData data : weatherForecast) {
                    for (WeatherData weatherData : futureForecast) {
                        if (data.getDate().compareTo(weatherData.getDate()) > 0) {
                            a = data.getHumidity();
                            b = weatherData.getHumidity();
                            if (a >= b) result = b / a;
                            else result = a / b;
                            if (result >= accuracy) {
                                count++;

                                FilteredList.add(data);
                            }
                        }

                    }

                }

                return FilteredList;
            }
            case "pressure": {
                for (WeatherData data : weatherForecast) {
                    for (WeatherData weatherData : futureForecast) {
                        if (data.getDate().compareTo(weatherData.getDate()) > 0) {
                            a = data.getPressure();
                            b = weatherData.getPressure();
                            if (a >= b) result = b / a;
                            else result = a / b;
                            if (result >= accuracy) {
                                count++;

                                FilteredList.add(data);
                            }
                        }

                    }

                }

                return FilteredList;
            }
            default: return null;
        }

        }

    public int getCount(){

        return count;
    }
}
