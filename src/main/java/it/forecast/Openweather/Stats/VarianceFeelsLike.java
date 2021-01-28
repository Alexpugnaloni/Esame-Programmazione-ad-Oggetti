package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.Vector;

/**
 * Sottoclasse che genera statistiche su varianza temperatura percepita.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class VarianceFeelsLike extends Stats{
    /**
     * Attributo della classe VarianceFeelsLike.
     */
    private double varianceTemperatureFeelsLike;

    /**
     * Costruttore della classe VarianceFeelsLike.
     * @param weatherForecast vettore di dati meteo.
     */
    public VarianceFeelsLike(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.varianceTemperatureFeelsLike = 0;
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
     * Metodo che ritorna varianza temperatura percepita.
     * @return varianza temperatura percepita.
     */

    @Override
    public double getTemp() {
        return this.varianceTemperatureFeelsLike;
    }

    /**
     * Metodo che calcola statistiche su varianza temperatura percepita.
     */
    public void calculateStat() {

        Vector<Double> v = new Vector<>();
        double sum =  0, sumSquareRej =  0, variance, avg;
        int size;
        for (WeatherData weatherData : weatherForecast) {
            v.add(weatherData.getFeels_like());
        }
        size = v.size();
        for (int i = 0; i < size; i++) {
            sum = sum + v.elementAt(i);
        }
        avg = sum / size;
        for (int i = 0; i < size; i++) {

            sumSquareRej = sumSquareRej + Math.pow(v.elementAt(i) - avg, 2);
        }

        variance = sumSquareRej / size;
        varianceTemperatureFeelsLike = variance;

    }

    /**
     * Metodo che ritorna statistiche su varianza temperatura percepita.
     * @return varianza temperatura percepita.
     */
    public JSONObject returnCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("Variance_FeelsLike", getTemp());


        return St;
    }
}
