package it.forecast.Openweather.Filters;


import it.forecast.Openweather.Model.WeatherData;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

/**
 * Classe che contiene il filtro del periodo.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class PeriodFilter {
    /**
     * Metodo che filtra statistiche in base al periodo.
     * @param period periodo scelto dall'utente.
     * @param weatherForecast vettore di chiamate.
     * @return vettore di chiamate filtrate in base al periodo scelto.
     */

    public static List<WeatherData> getFilteredPeriod(String period, List<WeatherData> weatherForecast) {

        List<WeatherData> FilteredList = new Vector<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dtf.format(now);


        switch (period) {

            case "day":
                now = now.minusDays(1);
                String dateString = dtf.format(now);
                for(int i=weatherForecast.size()-1; i>=0;i--) {
                    if (weatherForecast.get(i).getDate().compareTo(dateString)>0) {
                        FilteredList.add(weatherForecast.get(i));
                    }
                    else break;
                }
                break;

            case "week":
                now = now.minusWeeks(1);
                for(int i=weatherForecast.size()-1; i>=0;i--) {
                    if (weatherForecast.get(i).getDate().compareTo(now.toString())>0)
                        FilteredList.add(weatherForecast.get(i));
                     else break;
                }
                 break;
            case "month":
               now = now.minusMonths(1);
                for(int i=weatherForecast.size()-1; i>=0;i--) {
                    if (weatherForecast.get(i).getDate().compareTo(now.toString())>0)
                        FilteredList.add(weatherForecast.get(i));
                     else break;
                }
                 break;
        }
        return FilteredList;

        }
    }

