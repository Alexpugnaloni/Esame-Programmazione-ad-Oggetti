package it.forecast.Openweather.Controller;

import it.forecast.Openweather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	public String url;

	@Autowired
	WeatherService w;


	@GetMapping("/cities")
			public ResponseEntity<Object> get5ForecastWeather(@RequestParam name="q",defaultValue="Ancona") String q, @RequestParam(name="lang",defaultValue = "it") String lang) throws NoDataException
	{
		q= q.toLowerCase();
		lang= lang.toLowerCase();
		url = "https://api.openweathermap.org/data/2.5/forecast?q="+ q + "&lang=" + lang + "&units=metric&cnt=40";
		return new ResponseEntity<>(w.get5ForecastWeather(url), HttpStatus.OK);
	}
}

//MANCANO LE GETMAPPING DI STATS E FILTRI
