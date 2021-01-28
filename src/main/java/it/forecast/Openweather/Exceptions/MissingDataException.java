package it.forecast.Openweather.Exceptions;

public class MissingDataException extends Exception {
private String missing;
    public MissingDataException(String missing) {

        super();
        this.missing = missing;
    }
    @Override
    public String getMessage() {

        return " the field " + missing + " is missing";
    }
}
