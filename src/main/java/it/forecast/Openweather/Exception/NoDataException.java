package it.forecast.Openweather.Exception;

public class NoDataException extends Exception {

    public NoDataException() {

        super();
        System.out.println("ERROR: PROGRAM DID NOT RECOVER THE EXPECTED DATA");
    }
}
