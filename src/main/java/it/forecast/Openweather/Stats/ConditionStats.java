package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Vector;

public class ConditionStats extends Stats{

    int thunderstorm = 0, drizzle = 0, rain = 0, snow = 0, clear = 0, clouds = 0, other = 0;

    public ConditionStats(List<WeatherData> weatherForecast) {
        super(weatherForecast);
    }


    @Override
    public String getDate() {
        return null;
    }

    @Override
    public double getTemp() {
        return 0;
    }

    @Override
    public void calculateStat() {



        for (int i = 0; i < weatherForecast.size(); i++) {

            switch (weatherForecast.get(i).getMainCondition()) {

                case "Thunderstorm": thunderstorm++; break;
                case "Drizzle": drizzle++; break;
                case "Rain": rain++; break;
                case "Snow": snow++; break;
                case "Clear": clear++; break;
                case "Clouds": clouds++; break;
                default: other++; break;
            }
        }



    }

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

        System.out.println(St);

        return St;
    }
}
