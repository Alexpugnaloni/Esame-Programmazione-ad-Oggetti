package it.forecast.Openweather.Controller;

import it.forecast.Openweather.Database.Database;
import it.forecast.Openweather.Database.DatabaseFutureCalls;
import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Service.ApiKey;
import it.forecast.Openweather.Service.WeatherService;
import it.forecast.Openweather.Stats.PostRequestBodyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

/**
 * Classe controller che gestisce le chiamate a disposizione dell'utente.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */


@RestController
public class Controller {
	/**  Attributi usati per la ricerca programmata.
	 *
	 */

	public String url;
	public String cityPar = "Ancona";
	public String api_keyPar;
	public String langPar ="it";




	@Autowired
	WeatherService w;

	/**
	 * Rotta per visualizzare condizioni attuali e previsioni meteo per 5 giorni.
	 * @param city città che si vuole visualizzare.
	 * @param lang lingua in cui si vuole visualizzare i risultati.
	 * @return Vettore di condizioni meteo.

	 */

	@GetMapping("/weather")
			public ResponseEntity<Object> get5ForecastWeather(@RequestParam( name="city",defaultValue="Ancona") String city, @RequestParam(name="lang",defaultValue = "it") String lang) throws NoDataException, IOException, ParseException {
		city= city.toLowerCase();
		lang = lang.toLowerCase();
		cityPar = city;
		langPar = lang;
		ApiKey apiKey = new ApiKey();
		apiKey.ReadApiKey();
		api_keyPar = apiKey.getApiKey();
		url = "https://api.openweathermap.org/data/2.5/forecast?q="+ city + "&appid="+ api_keyPar+ "&lang=" + lang + "&units=metric";
		return new ResponseEntity<>(w.get5ForecastWeather(url), HttpStatus.OK);
	}

	/**
	 * Chiamata programmata per popolare i database presenti nel progetto con frequenza oraria.
	 *
	 */
	@Scheduled(initialDelay = 10000,fixedRate = 5000)
	public void scheduledRequest() throws ParseException, NoDataException, IOException {

		get5ForecastWeather(cityPar,langPar);
		Database.saveToCSV();
		DatabaseFutureCalls.saveToCSV();
	}

	/**
	 * Rotta per visualizzare statistiche periodiche.
	 * @body contiene parametri utilizzati dalle classi di statistiche
	 * @return	JSONObject di statistiche periodiche.

	 */
	@PostMapping("/periodicstats")
		public 	ResponseEntity<Object> getStats (@RequestBody PostRequestBodyHandler PeriodicStats) throws NoDataException, IOException, ParseException {

		return new ResponseEntity<>(w.getStats(PeriodicStats), HttpStatus.OK);

	}

	/**
	 * Rotta per visualizzare statistiche su previsioni azzeccate.
	 * @body contiene parametri utilizzati dalle classi di statistiche
	 * @return JSONObject di statistiche.
	 */
	@PostMapping("/accuracystats")
		public ResponseEntity<Object> getAccuracy(@RequestBody PostRequestBodyHandler AccuracyStats) throws NoDataException, IOException, ParseException {
		return new ResponseEntity<>(w.getAccuracy(AccuracyStats),HttpStatus.OK);
	}
}


