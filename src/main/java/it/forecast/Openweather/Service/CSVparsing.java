package it.forecast.Openweather.Service;

import it.forecast.Openweather.Database.Database;
import it.forecast.Openweather.Database.DatabaseFutureCalls;
import it.forecast.Openweather.Model.WeatherData;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di popolare l'ArrayList di dati meteo.
 * prendendoli in input da un file CSV.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


public class CSVparsing {
    /**
     * Effettua il parsing del file CSV in modo da salvare ogni riga come un oggetto WeatherData.
     * @param csvFile percorso del file da cui recuperare le informazioni.
     * @return ArrayList di dati meteo.
     */

    @SuppressWarnings("deprecation")
    public static ArrayList<WeatherData> runParsing(String csvFile){

        int row = 1;
        String line="";
        ArrayList<WeatherData> weatherforecast = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
            bufferedReader.readLine();
            try{
                while((line = bufferedReader.readLine()) !=null) {

                    String[] recovered = line.split(";");


                    WeatherData objectRecovered = new WeatherData(recovered[0].replaceAll("^\\s+",""),
                            Double.parseDouble(recovered[1]),
                            Double.parseDouble(recovered[2]),
                            Double.parseDouble(recovered[3]),
                            Double.parseDouble(recovered[4]),
                            Long.parseLong(recovered[5]),
                            Long.parseLong(recovered[6]),
                            recovered[7].replaceAll("^\\s+",""),
                            recovered[8].replaceAll("^\\s+",""),
                            recovered[9].replaceAll("^\\s+",""),
                            recovered[10].replaceAll("^\\s+",""));


                    weatherforecast.add(objectRecovered);
                }
            }
                catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                }
            catch (NumberFormatException e) {
             e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            row++;

        try{
            bufferedReader.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
       }
          catch (FileNotFoundException e) {
        e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherforecast;
    }

    /**
     * Salva ogni dato meteo come riga in un file CSV.
     * @param csvFile percorso del file su cui salvare le informazioni.
     */

    public static void saveToDatabase(String csvFile) {
        ArrayList<WeatherData> weatherforecast = Database.getWeatherforecast();
        ArrayList<String> rows = new ArrayList<>();
        for (WeatherData recovered : weatherforecast) {

            String x = recovered.getDescription() + ";" + recovered.getTemperature() + ";"
                    + recovered.getTempMin() + ";" + recovered.getTempMax() + ";"
                    + recovered.getFeels_like() + ";" + recovered.getHumidity() + ";"
                    + recovered.getPressure() + ";" + recovered.getDate() + ";"
                    + recovered.getCity() + ";" + recovered.getCountry() + ";"
                    + recovered.getMainCondition();
            rows.add(x);
        }
        try {

            FileWriter csvWriter = new FileWriter(csvFile);
            File f = new File(csvFile);

                csvWriter.append("Description");
                csvWriter.append(";");
                csvWriter.append("Temperature");
                csvWriter.append(";");
                csvWriter.append("TempMin");
                csvWriter.append(";");
                csvWriter.append("TempMax");
                csvWriter.append(";");
                csvWriter.append("Feels Like");
                csvWriter.append(";");
                csvWriter.append("Humidity");
                csvWriter.append(";");
                csvWriter.append("Pressure");
                csvWriter.append(";");
                csvWriter.append("Date");
                csvWriter.append(";");
                csvWriter.append("City");
                csvWriter.append(";");
                csvWriter.append("Country");
                csvWriter.append(";");
                csvWriter.append("Main Condition");
                csvWriter.append("\n");

            String[] sections;
            for (String rowData : rows) {

                sections = rowData.split(";");

                for (String data : sections) {
                    csvWriter.append(data + ";");
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (FileNotFoundException e) {
         e.printStackTrace();

        } catch (IOException e) {

        }
    }
    /**
     * Salva ogni dato meteo come riga in un file CSV.
     * @param csvFile percorso del file su cui salvare le informazioni.
     */
    public static void saveToDatabaseFutureCalls(String csvFile) {
        ArrayList<WeatherData> weatherforecast = DatabaseFutureCalls.getWeatherforecast();
        ArrayList<String> rows = new ArrayList<String>();
        for (WeatherData recovered : weatherforecast) {
            String x = recovered.getDescription() + ";" + recovered.getTemperature() + ";"
                    + recovered.getTempMin() + ";" + recovered.getTempMax() + ";"
                    + recovered.getFeels_like() + ";" + recovered.getHumidity() + ";"
                    + recovered.getPressure() + ";" + recovered.getDate() + ";"
                    + recovered.getCity() + ";" + recovered.getCountry() + ";"
                    + recovered.getMainCondition();
            rows.add(x);
        }
        try {
            FileWriter csvWriter = new FileWriter(csvFile);
            File f = new File(csvFile);

                csvWriter.append("Description");
                csvWriter.append(";");
                csvWriter.append("Temperature");
                csvWriter.append(";");
                csvWriter.append("TempMin");
                csvWriter.append(";");
                csvWriter.append("TempMax");
                csvWriter.append(";");
                csvWriter.append("Feels Like");
                csvWriter.append(";");
                csvWriter.append("Humidity");
                csvWriter.append(";");
                csvWriter.append("Pressure");
                csvWriter.append(";");
                csvWriter.append("Date");
                csvWriter.append(";");
                csvWriter.append("City");
                csvWriter.append(";");
                csvWriter.append("Country");
                csvWriter.append(";");
                csvWriter.append("Main Condition");
                csvWriter.append("\n");

            String[] sections;
            for (String rowData : rows) {
                sections = rowData.split(";");

                for (String data : sections) {
                    csvWriter.append(data + ";");
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
