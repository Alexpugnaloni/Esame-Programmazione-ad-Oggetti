package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.Vector;

/**
 * Sottoclasse che rappresenta la statistica media temperatura percepita.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class AverageFeelsLike extends Stats{
    private double averageFeelsLike;

    /**
     * Costruttore della classe AverageFeelsLike.
     * @param weatherForecast vettore di dati meteo.
     */
    public AverageFeelsLike(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.averageFeelsLike = 0;

    }

    /**
     * Metodo che ritorna data e ora.
     * @return data e ora.
     */
    @Override
    public String getDate() {
        return null;
    }

    /**
     * Metodo che ritorna la temperatura.
     * @return temperatura.
     */
    @Override
    public double getTemp() {
        return this.averageFeelsLike;
    }

    /**
     * Metodo che calcola la statistica media temperatura percepita.
     */
    public void calculateStat() {
        Vector<Double> v = new Vector<>();
        double sum = 0, avg;
        int size;
        for (WeatherData weatherData : weatherForecast) {
            v.add(weatherData.getFeels_like());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;

        averageFeelsLike = avg;

    }

    /**
     * Metodo che ritorna la statistica media temperatura percepita.
     * @return media temperatura percepita.
     */
    public JSONObject returnCalculateStat(){
        JSONObject St = new JSONObject();

        St.put("Average_FeelsLike", getTemp());

        return St;

    }
}
