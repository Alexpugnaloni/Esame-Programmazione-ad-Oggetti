package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

/**
 * Sottoclasse che rappresenta la statistica media temperatura.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class AverageTemperature extends Stats {
    private double averageTemperature;

    /**
     * Costruttore della classe AverageTempeerature
     * @param weatherForecast vettore di dati meteo
     */
    public AverageTemperature(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageTemperature = 0;

    }

    /**
     * Metodo che restituisce data e ora
     * @return data e ora
     */
    @Override
    public String getDate() {
        return null;
    }

    /**
     * Metodo che restituisce temperatura
     * @return temperatura
     */
    @Override
    public double getTemp() {
        return this.averageTemperature;
    }

    /**
     * Metodo che calcola la statistica media temperatura
     */
    public void calculateStat() {
        Vector<Double> v = new Vector<>();
        double sum = 0, avg;
        int size;
        for (WeatherData weatherData : weatherForecast) {
            v.add(weatherData.getTemperature());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;

        averageTemperature = avg;

    }

    /**
     * Metodo che ritorna la statistica media temperatura
     * @return media temperatura
     */
    public JSONObject ritornaCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("Average", getTemp());

        return St;

    }

}