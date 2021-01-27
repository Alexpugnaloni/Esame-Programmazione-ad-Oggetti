package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Sottoclasse che si occupa di generare statistiche su tmeperatura massima percepita.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public class MaxFeelsLike extends Stats{
    /**
     * attributi della classe.
     */
    private double maxTemperatureFeelsLike;
    private String date;

    /**
     * Costruttore della classe.
     * @param weatherForecast vettore di dati meteo.
     */
    public MaxFeelsLike(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.maxTemperatureFeelsLike = 0;
        this.date = null;
    }

    /**
     * Metodo che ritorna temperatura.
     * @return temperatura.
     */
    @Override
    public double getTemp(){
        return this.maxTemperatureFeelsLike; }

    /**
     * Metodo che ritorna data e ora.
     * @return data e ora.
     */
    @Override
    public String getDate(){
        return  this.date;

    }

    /**
     * Metodo che calcola statistiche su temperatura massima percepita.
     */

    public void calculateStat(){

        WeatherData maxValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {
            WeatherData wD = weatherForecast.get(i);
            if (wD.getFeels_like() > maxValue.getFeels_like()) {
                maxValue = wD;
            }
        }
        maxTemperatureFeelsLike = maxValue.getFeels_like();
        date = maxValue.getDate();

    }

    /**
     * Metodo che ritorna statistiche su temperatura massima percepita.
     * @return temperatura massima percepita e data.
     */
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("tempMax_FeelsLike", getTemp());

        St.put("tempMaxDate_FeelsLike",getDate());

        return St;
    }
}
