package it.forecast.Openweather.Database;

import it.forecast.Openweather.Model.Metadata;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Service.CSVparsing;

import java.util.ArrayList;


/**
 * Classe che contiene i metodi salvadati automatizzati dallo scheduler per salvare le previsioni dei giorni successivi
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */
public class DatabaseFutureCalls {

    /**
     * array contenente tutti i dati sulle previsioni dei giorni successivi
     */
    private static ArrayList<WeatherData> weatherforecast = new ArrayList<>();

    /**
     * array contentente tutti i metadati
     */
    private static final ArrayList<Metadata> metadata = new ArrayList<>();

    /**
     * percorso del database popolato di dati sulle previsioni dei giorni successivi
     */
    private static final String csvFile = "DatabaseFile/DatabaseFutureCalls.csv";

    /**
     * @return array di tutti i dati sulle previsioni dei giorni successivi
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
     * metodo che aggiunge dati sulle previsioni dei giorni successivi all' array
     * @param weatherData istanza della classe weatherdata
     */
    public static void addWeatherForecast(WeatherData weatherData) {
        weatherforecast.add(weatherData);
    }

    /**
     * metodo che allo start del programma ripulisce e setta il database per il salvataggio dei dati
     */
    public static void setWeatherDataCSV(){
        weatherforecast = CSVparsing.runParsing(csvFile);
    }

    /**
     * metodo utilizzato per salvare i dati sul database
     */
    public static void saveToCSV(){
        CSVparsing.saveToDatabaseFutureCalls(csvFile);
    }
}
