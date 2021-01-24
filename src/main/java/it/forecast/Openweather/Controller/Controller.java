package it.forecast.Openweather.Controller;

import it.forecast.Openweather.Database.Database;
import it.forecast.Openweather.Database.DatabaseFutureCalls;
import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Model.WeatherData;
import it.forecast.Openweather.Service.ApiKey;
import it.forecast.Openweather.Service.WeatherForecast_API_Call;
import it.forecast.Openweather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

@RestController
public class Controller {

	public String url;
	public String cityPar;
	public String api_keyPar;
	public String langPar;




	@Autowired
	WeatherService w;



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
	@Scheduled(initialDelay = 10000,fixedRate = 5000)
	public void scheduledRequest() throws ParseException, NoDataException, IOException {

		get5ForecastWeather(cityPar,langPar);
		Database.saveToCSV();
		DatabaseFutureCalls.saveToCSV();
	}

	@PostMapping("/stats")
		public 	ResponseEntity<Object> getStats (@RequestParam( name="city",defaultValue="Ancona") String city, @RequestParam(name= "period", defaultValue = "week") String period) throws NoDataException, IOException, ParseException {
		period = period.toLowerCase();
		return new ResponseEntity<>(w.getStats(period), HttpStatus.OK);

	}
}

//MANCA LA GETMAPPING DI STATS E FILTRI
