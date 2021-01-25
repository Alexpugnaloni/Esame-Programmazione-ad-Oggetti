package it.forecast.Openweather.Filters;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;
import java.util.Vector;

/**
 * Classe che contiene il filtro margine d'errore.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class ErrorMarginFilter {
    /**
     * Attributo usato come contatore da incrementare.
     */

    private int count;

    /**
     * Metodo utilizzato per calcolare il margine d'errore.
     * @param weatherForecast vettore di chiamate proveniente da database attuale.
     * @param futureForecast vettore di chiamate proveniente da database futuro.
     * @param accuracy margine d'errore scelto dall'utente.
     * @param param tipo di dato che l'utente vuole visualizzare.
     * @return vettore di chiamate filtrare in base al param scelto.
     */

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

    /**
     * Metodo per estrarre il contatore e quantificare le chiamate azzeccate.
     * @return contatore.
     */

    public int getCount(){

        return count;
    }
}
