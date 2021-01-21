package it.forecast.Openweather;

import it.forecast.Openweather.Database.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class OpenweatherApplication {

	public static void main(String[] args) {
		Database.setWeatherDataCSV();
		SpringApplication.run(OpenweatherApplication.class, args);

	}

}
