package it.forecast.Openweather.Exceptions;

public class FailRequestException extends Exception{
    public FailRequestException(){

    }
    @Override
    public String getMessage(){
        return "Failed Request, check correct name of city and lang parameters";
    }
}
