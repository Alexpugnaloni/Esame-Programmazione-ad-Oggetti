package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;
import java.util.List;

/**
 * Sottoclasse che si occupa di generare statistiche sulle condizioni meteo.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public class ConditionStats extends Stats{
    /**
     * parametri utilizzati come contatori
     */

    int thunderstorm = 0, drizzle = 0, rain = 0, snow = 0, clear = 0, clouds = 0, other = 0;

    public ConditionStats(List<WeatherData> weatherForecast) {
        super(weatherForecast);
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
        return 0;
    }

    /**
     * Metodo che calcola statistiche sulle condizioni meteo.
     */
    @Override
    public void calculateStat() {


        for (WeatherData weatherData : weatherForecast) {

            switch (weatherData.getMainCondition()) {

                case "Thunderstorm":
                    thunderstorm++;
                    break;
                case "Drizzle":
                    drizzle++;
                    break;
                case "Rain":
                    rain++;
                    break;
                case "Snow":
                    snow++;
                    break;
                case "Clear":
                    clear++;
                    break;
                case "Clouds":
                    clouds++;
                    break;
                default:
                    other++;
                    break;
            }
        }



    }

    /**
     * Metodo che ritorna statistiche su condizioni meteo.
     * @return condizioni meteo
     */
    @Override
    public JSONObject ritornaCalculateStat() {
        JSONObject St = new JSONObject();

        St.put("Thunderstorm", thunderstorm);
        St.put("Drizzle", drizzle);
        St.put("Rain", rain);
        St.put("Snow", snow);
        St.put("Clear", clear);
        St.put("Clouds", clouds);
        St.put("Other specific atmosphere cases", other);


        return St;
    }
}
