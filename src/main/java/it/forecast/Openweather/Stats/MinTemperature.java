package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Sottoclasse che genera statistiche su minima temperatura.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class MinTemperature extends Stats{
    /**
     * Attributi della classe MinTemperature.
     */
    private double minTemperature;
    private String date;

    /**
     * Costruttore della classe MinTemperature.
     * @param weatherForecast vettore di dati meteo.
     */
    public MinTemperature(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.minTemperature = 0;
        this.date = null;
    }

    /**
     * Metodo che ritorna data e ora.
     * @return data e ora.
     */
    @Override
    public String getDate() {
        return this.date;
    }

    /**
     * Metodo che ritorna minima temperatura.
     * @return minima temperatura.
     */
    @Override
    public double getTemp() {
        return this.minTemperature;
    }

    /**
     * Metodo che calcola statistiche su minima temperatura.
     */
    public void calculateStat(){

        WeatherData minValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() < minValue.getTemperature()) {
                minValue = wD;
            }
            minTemperature = minValue.getTemperature();
            date = minValue.getDate();
        }

    }

    /**
     * Metodo che ritorna statistiche su minima temperatura.
     * @return minima temperatura e data e ora.
     */
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("tempMin", getTemp());

        St.put("tempMinDate",getDate());

        return St;
    }
}
