package it.forecast.Openweather.Service;

import it.forecast.Openweather.Exceptions.FailRequestException;
import it.forecast.Openweather.Exceptions.MissingDataException;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Stats.PostRequestBodyHandler;
import org.json.JSONException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Interfaccia di servizio per la gestione delle operazioni sui dati meteo.
 */

public interface WeatherService {
	/**
	 * Metodo che restituisce le condizioni meteo attuali e previsioni meteo per 5 giorni.
	 * @param url indirizzo di ricerca.
	 * @return vettore di condizioni meteo.
	 */

	List<WeatherData> get5ForecastWeather(String url) throws IOException, ParseException, JSONException, MissingDataException, FailRequestException;

	/**
	 * Metodo che restituisce statistiche periodiche.
	 * @param PeriodicStats body passato alla rotta periodicstats
	 * @return JSONObject di statistiche periodiche.
	 */
	Map<String,Object> getStats(PostRequestBodyHandler PeriodicStats) throws IOException, ParseException, JSONException, MissingDataException;

	/**
	 * Metodo che restituisce statistiche su previsioni azzeccate.
	 * @param AccuracyStats body passato alla rotta accuracystats.
	 * @return JSONObject di statistiche.
	 */
	Map<String,Object> getAccuracy (PostRequestBodyHandler AccuracyStats) throws IOException, ParseException, JSONException, MissingDataException;

}
