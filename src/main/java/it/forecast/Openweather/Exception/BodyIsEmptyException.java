package it.forecast.Openweather.Exception;

public class BodyIsEmptyException extends Exception{
    private static final long serialVersionUID = 1L;

    public BodyIsEmptyException() {
        super("IL BODY DEL POST NON CONTIENE NULLA.");
    }
}
