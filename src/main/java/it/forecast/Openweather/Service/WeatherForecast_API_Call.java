package it.forecast.Openweather.Service;

import it.forecast.Openweather.Database.Database;
import it.forecast.Openweather.Database.DatabaseFutureCalls;
import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Vector;

/**
 * Classe che si occupa di gestire il download e i relativi dati forniti dalla chiamata api.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class WeatherForecast_API_Call {
	/**
	 * Metodo che si occupa della chiamata all'api
	 * @param url indirizzo di ricerca
	 * @return dati relativi alla chiamata api.
	 */



	public List<WeatherData> loadCall(String url) {
		List<WeatherData> downloadedForecast = new Vector<>();
		JSONParser parser = new JSONParser();

		try {
			//API CALL
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				JSONObject stats = (JSONObject) parser.parse(inputLine);


				buildForecast(stats, downloadedForecast);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return downloadedForecast;


	}

	/**
	 * Metodo che si occupa di prelevare solamente alcuni dati dalla chiamata completa all'api.
	 * @param stats JSONObject per ingresso nella lista di oggetti della chiamata.
	 * @param downloadedForecast chiamata totale.
	 */


	private void buildForecast(JSONObject stats,  List<WeatherData> downloadedForecast) {
		JSONArray a = (JSONArray) stats.get("list");

		JSONObject c = (JSONObject) stats.get("city");
		String city = (String) c.get("name");
		String country = (String) c.get("country");
		int CurrentCounter = 0;



		for (Object o : a) {
			try {
				JSONObject elem = (JSONObject) o;
				JSONObject main = (JSONObject) elem.get("main");

				Double temperature = (Double) main.get("temp");
				Double tempMin = (Double) main.get("temp_min");
				Double tempMax = (Double) main.get("temp_max");
				Double feels_like = (Double) main.get("feels_like");
				Long pressure = (Long) main.get("pressure");
				Long humidity = (Long) main.get("humidity");

				JSONArray weatherList = (JSONArray) elem.get("weather");
				JSONObject data = (JSONObject) weatherList.get(0);
				String description = (String) data.get("description");
				String date = (String) elem.get("dt_txt");
				String mainCondition = (String) data.get("main");


				WeatherData w = new WeatherData(description, temperature, tempMin, tempMax, feels_like, humidity, pressure, date, city,country, mainCondition);
				downloadedForecast.add(w);

				if (CurrentCounter == 0) {
					Database.addWeatherForecast(w);
				} else {
					DatabaseFutureCalls.addWeatherForecast(w);
				}
				CurrentCounter++;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

