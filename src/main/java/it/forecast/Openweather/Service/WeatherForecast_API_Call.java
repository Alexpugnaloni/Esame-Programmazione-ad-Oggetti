package it.forecast.Openweather.Service;

import it.forecast.Openweather.Model.WeatherData;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Vector;

public class WeatherForecast_API_Call {

	public List<WeatherData> download(String url) throws NoDataException{
		List<WeatherData> downloadedWeathers= new Vector<>();
		JSONParser parser = new JSONParser();

		//MANCA IL TRY CATCH CHE PER ORA NON SO COME FARLO
			//API CALL
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				JSONObject stats = (JSONObject) parser.parse(inputLine);


				buildWheaters(stats, downloadedWeathers);
			}
		in.close();
		}





		private void buildWheaters(JSONObject stats,List<WeatherData> downloadedWeathers) {
			JSONArray a = (JSONArray) stats.get("q");
			//DA FINIRE E DA CAPIRE
		}
	}

