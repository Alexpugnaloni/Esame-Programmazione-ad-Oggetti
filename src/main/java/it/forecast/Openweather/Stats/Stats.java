package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Classe astratta per le statistiche.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public abstract class Stats {
    /**
     * vettore che conterrà i dati meteo sui quali effettuare statistiche.
     */

    List<WeatherData> weatherForecast;

    /**
     * Costruttore della classe Stats.
     * @param weatherForecast vettore di dati meteo.
     */
    public Stats(List<WeatherData> weatherForecast){
        this.weatherForecast = weatherForecast;
    }

    /**
     * Metodo che restituisce il vettore di dati meteo sui quali calcolare statistiche.
     * @return vettore di dati meteo.
     */
    public List<WeatherData> getWeatherForecast(){
        return weatherForecast;
    }

    /**
     * Metodo che modifica il vettore dei dati meteo sui quali verranno calcolate le statistiche.
     * @param weatherForecast nuovo vettore di dati meteo sui quali calcolare le statistiche.
     */
    public void setWeatherForecast(List<WeatherData> weatherForecast){
        this.weatherForecast = weatherForecast;
    }

    /**
     * Metodo che ritorna data e ora.
     * @return data e ora.
     */
    public abstract String getDate();


    /**
     * Metodo che ritorna la temperatura.
     * @return temperatura.
     */
    public abstract double getTemp();

    /**
     * Metodo che ritorna una statistica di tipo JSONObject.
     * @return
     */
    public JSONObject getJSONObject() {
        return null;
    }

    /**
     * Metodo astratto per il calcolo delle statistiche.
     */
    public abstract void calculateStat();

    /**
     * Metodo astratto per ritornare il calcolo delle statistiche.
     * @return calcolo delle statistiche.
     */
    public abstract JSONObject returnCalculateStat();
}
