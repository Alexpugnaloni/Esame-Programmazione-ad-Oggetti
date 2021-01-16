package it.forecast.Openweather.Controller;

import it.forecast.Openweather.Exception.NoDataException;
import it.forecast.Openweather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

@RestController
public class Controller {

	public String url;

	@Autowired
	WeatherService w;


	@GetMapping("/weather")
			public ResponseEntity<Object> get5ForecastWeather(@RequestParam( name="city",defaultValue="Ancona") String city,@RequestParam(name="api_key", defaultValue = "64ad2ae5de08dc46224c92d7503a2ac2")String api_key, @RequestParam(name="lang",defaultValue = "it") String lang) throws NoDataException, IOException, ParseException {
		city= city.toLowerCase();
		api_key=api_key.toLowerCase();
		lang= lang.toLowerCase();
		url = "https://api.openweathermap.org/data/2.5/forecast?q="+ city + "&appid="+ api_key+ "&lang=" + lang + "&units=metric&cnt=40";
		return new ResponseEntity<>(w.get5ForecastWeather(url), HttpStatus.OK);
	}
}

//MANCANO LE GETMAPPING DI STATS E FILTRI
