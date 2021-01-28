package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

/**
 * Sottoclasse che si occupa di generare statistiche su varianza temperatura.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class VarianceTemperature extends Stats {
    /**
     * Attributo della classe VarianceTemperature.
     */
    private double varianceTemperature;

    /**
     * Costruttore della classe VarianceTemperature.
     * @param weatherForecast vettore di dati meteo.
     */
    public VarianceTemperature(List<WeatherData> weatherForecast) {
        super(weatherForecast);
        this.varianceTemperature = 0;
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
     * Metodo che ritorna varianza temperatura.
     * @return varianza temperatura.
     */
    @Override
    public double getTemp() {
        return this.varianceTemperature;
    }

    /**
     * Metodo che calcola statistiche su varianza temperatura.
     */
    public void calculateStat() {

        Vector<Double> v = new Vector<>();
        double sum = 0, sumSquareRej = 0, variance, avg;
        int size;
        for (WeatherData weatherData : weatherForecast) {
            v.add(weatherData.getTemperature());
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
        varianceTemperature = variance;

    }

    /**
     * Metodo che ritorna statistiche su varianza temperatura.
     * @return varianza temperatura.
     */
    public JSONObject returnCalculateStat(){
        JSONObject St = new JSONObject();


        St.put("Variance", getTemp());


        return St;
    }
}