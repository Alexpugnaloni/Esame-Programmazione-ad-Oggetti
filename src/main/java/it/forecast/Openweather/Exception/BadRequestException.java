package it.forecast.Openweather.Exception;

public class BadRequestException extends Exception{
    public BadRequestException(){

    }
    @Override
    public String getMessage(){
        return "Bad Request, check correct name of city and lang parameters";
    }
}
