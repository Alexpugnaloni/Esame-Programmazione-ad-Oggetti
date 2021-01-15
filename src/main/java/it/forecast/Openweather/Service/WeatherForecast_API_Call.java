package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.DoubleBuffer;
import java.util.List;
import java.util.Vector;

public class WeatherForecast_API_Call {

	public List<WeatherData> loadCall(String url) throws NoDataException {
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
		} catch (IOException e) {
		} catch (ParseException e) {

		}

		return downloadedForecast;


	}


	private void buildForecast(JSONObject stats, List<WeatherData> downloadedForecast) {
		JSONArray a = (JSONArray) stats.get("list");


		for (Object o : a) {
			try {
				JSONObject elem = (JSONObject) o;
				JSONObject main = elem.getJSONObject("main");

				Double temperature = (Double) main.get("temp");
				Double tempMin = (Double) main.get("temp_min");
				Double tempMax = (Double) main.get("temp_max");
				Integer pressure = (Integer) main.get("pressure");
				Integer humidity = (Integer) main.get("humidity");

				JSONArray weatherList = elem.getJSONArray("weather");
				JSONObject data = (JSONObject) weatherList.get(0);
				String description = (String) data.get("description");
				String date = (String) elem.getString("dt_txt");

				WeatherData w = new WeatherData(description, temperature, tempMin, tempMax, humidity, pressure, date);
				downloadedForecast.add(w);

			} catch (Exception e) {
			}
		}

	}


}

