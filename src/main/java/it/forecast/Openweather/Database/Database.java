package it.forecast.Openweather.Database;

import it.forecast.Openweather.Model.Metadata;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Service.CSVparsing;

import java.util.ArrayList;

public class Database {
    private static ArrayList<WeatherData> weatherforecast = new ArrayList<>();
    private static final ArrayList<Metadata> metadata = new ArrayList<>();
    private static final String csvFile = "DatabaseFile/Database.csv";

    public static ArrayList<WeatherData> getWeatherforecast(){
        return weatherforecast;
    }

    public static ArrayList<Metadata> getMetadata(){
        metadata.add(new Metadata("description","Description","String"));
        metadata.add(new Metadata("temperature","Temperature","Double"));
        metadata.add(new Metadata("tempMin","TempMin","Double"));
        metadata.add(new Metadata("tempMax","TempMax","Double"));
        metadata.add(new Metadata("feels_like","Feels Like","Double"));
        metadata.add(new Metadata("humidity","Humidity","Long"));
        metadata.add(new Metadata("pressure","Pressure","Long"));
        metadata.add(new Metadata("date","Date","String"));
        metadata.add(new Metadata("city","City","String"));
        metadata.add(new Metadata("country","Country","String"));
        metadata.add(new Metadata("mainCondition","Main Condition","String"));
        return metadata;
    }

    public static void addWeatherForecast(WeatherData weatherData) {
        weatherforecast.add(weatherData);
    }

    public static void setWeatherDataCSV(){
        weatherforecast = CSVparsing.runParsing(csvFile);
    }
    public static void saveToCSV(){
        CSVparsing.saveToDatabase(csvFile);
    }
}
