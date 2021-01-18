package it.forecast.Openweather.Stats;

import it.forecast.Openweather.Model.WeatherData;

import java.util.List;

public class Stats {

    protected WeatherData MaxValue;
    protected WeatherData MinValue;
    protected List<WeatherData> result;

    public List<WeatherData> getStats(String statsType, List<WeatherData> list) {return result;}
}
