package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Sottoclasse che si occupa di generare statistiche su massima temperatura.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */



public class MaxTemperature extends Stats {
    /**
     * Attributi della classe MaxTemperature.
     */

    private double maxTemperature;
    private String date;

    /**
     * Costruttore della classe MaxTemperature.
     * @param weatherForecast vettore di dati meteo.
     */
    public MaxTemperature(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.maxTemperature = 0;
        this.date = null;
    }

    /**
     * Metodo che ritorna temperatura.
     * @return temperatura.
     */
    @Override
    public double getTemp(){
        return this.maxTemperature; }

    /**
     * Metodo che ritorna data e ora.
     * @return data e ora.
     */
    @Override
    public String getDate(){
        return  this.date;

    }

    /**
     * Metodo che calcola statistiche su massima temperatura.
     */

    public void calculateStat(){

        WeatherData maxValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {
            WeatherData wD = weatherForecast.get(i);
            if (wD.getTemperature() > maxValue.getTemperature()) {
                maxValue = wD;
            }
        }
        maxTemperature = maxValue.getTemperature();
        date = maxValue.getDate();

    }

    /**
     * Metodo che ritorna statistiche su massima temperatura.
     * @return massima temperatura e data e ora.
     */
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("tempMax", getTemp());

        St.put("tempMaxDate",getDate());

        return St;
    }

}
