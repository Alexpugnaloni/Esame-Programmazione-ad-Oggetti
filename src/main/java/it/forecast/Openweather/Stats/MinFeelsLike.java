package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Sottoclasse che si occupa di generare statistiche su minima temperatura percepita.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public class MinFeelsLike extends Stats{
    /**
     * Attributi della classe MinFeelsLike.
     */
    private double minTemperatureFeelsLike;
    private String date;

    /**
     * Costruttore della classe MinFeelsLike.
     * @param weatherForecast vettore di dati meteo.
     */
    public MinFeelsLike(List<WeatherData> weatherForecast){
        super(weatherForecast);
        this.minTemperatureFeelsLike = 0;
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
     * Metodo che ritorna minima temperatura percepita.
     * @return minima temperatura percepita.
     */
    @Override
    public double getTemp() {
        return this.minTemperatureFeelsLike;
    }

    /**
     * Metodo che calcola statistiche su minima temperatura percepita.
     */
    public void calculateStat(){

        WeatherData minValue = weatherForecast.get(0);
        for (int i = 1; i < weatherForecast.size(); i++) {

            WeatherData wD = weatherForecast.get(i);
            if (wD.getFeels_like() < minValue.getFeels_like()) {
                minValue = wD;
            }
            minTemperatureFeelsLike = minValue.getFeels_like();
            date = minValue.getDate();
        }

    }

    /**
     * Metodo che ritorna statistiche su minima temperatura percepita.
     * @return minima temperatura percepita e data e ora.
     */
    public JSONObject returnCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("tempMin_FeelsLike", getTemp());

        St.put("tempMinDate_FeelsLike",getDate());

        return St;
    }
}
