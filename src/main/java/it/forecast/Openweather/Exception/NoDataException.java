package it.forecast.Openweather.Exception;

public class NoDataException extends Exception{

    public NoDataException() {

        super("ERROR: PROGRAM DID NOT RECOVER THE EXPECTED DATA");
    }
}
