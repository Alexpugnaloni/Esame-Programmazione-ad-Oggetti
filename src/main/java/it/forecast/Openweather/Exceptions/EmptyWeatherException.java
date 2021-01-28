package it.forecast.Openweather.Exceptions;

public class EmptyWeatherException extends Exception{
    private String empty;
    public EmptyWeatherException(String empty){
        super();
        this.empty = empty;
    }
    @Override
    public String getMessage(){
        return empty + " empty";
    }
}
