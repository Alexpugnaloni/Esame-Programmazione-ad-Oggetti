package it.forecast.Openweather.Exception;

public class NoDataException extends Exception {
private String missing;
    public NoDataException(String missing) {

        super();
        this.missing = missing;
    }
    @Override
    public String getMessage() {

        return " the field " + missing + "is missing";
    }
}
