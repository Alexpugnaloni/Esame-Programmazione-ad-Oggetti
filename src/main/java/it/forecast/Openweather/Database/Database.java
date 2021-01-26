package it.forecast.Openweather.Database;

import it.forecast.Openweather.Model.Metadata;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Service.CSVparsing;

import java.util.ArrayList;

/**
 * Classe che contiene i metodi salvadati automatizzati dallo scheduler per salvare i dati meteo correnti
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class Database {

    /**
     * array contenente tutti i dati meteo correnti
     */
    private static ArrayList<WeatherData> weatherforecast = new ArrayList<>();

    /**
     * array contentente tutti i metadati
     */
    private static final ArrayList<Metadata> metadata = new ArrayList<>();

    /**
     * percorso del database popolato di dati meteo correnti
     */
    private static final String csvFile = "DatabaseFile/Database.csv";

    /**
     * @return array di tutti i dati meteo correnti
     */
    public static ArrayList<WeatherData> getWeatherforecast(){
        return weatherforecast;
    }

    /**
     *
     * @return array di metadati
     */
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

    /**
     * metodo che aggiunge dati meteo correnti all' array
     * @param weatherData istanza della classe weatherdata
     */
    public static void addWeatherForecast(WeatherData weatherData) {
        weatherforecast.add(weatherData);
    }

    /**
     * metodo che popola l'array dinamico con i dati contenuti nel database dei dati meteo correnti
     */
    public static void setWeatherDataCSV(){
        weatherforecast = CSVparsing.runParsing(csvFile);
    }

    /**
     * metodo utilizzato per salvare i dati sul database
     */
    public static void saveToCSV(){
        CSVparsing.saveToDatabase(csvFile);
    }

}
