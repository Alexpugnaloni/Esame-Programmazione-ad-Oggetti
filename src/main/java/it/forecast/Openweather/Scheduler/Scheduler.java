package it.forecast.Openweather.Scheduler;


import it.forecast.Openweather.Service.WeatherForecast_API_Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

    @Component
    public class Scheduler {

        @Autowired
        private WeatherForecast_API_Call oWD = new WeatherForecast_API_Call();

        /**
         *
         * Metodo che consente di salvare i dati sul database ogni ora
         *
         */
        @Scheduled(fixedRate=3600000)
        public void scheduler() {
//
        }

    }

