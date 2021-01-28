package it.forecast.Openweather.Exceptions;

public class FailRequestException extends Exception{
    private String s1,s2;

    public  FailRequestException(){
        super();
        this.s1= "city";
        this.s2= "lang";

    }
 @Override
    public String getMessage(){
        return "Failed Request, check correct name of" +s1+ "and "+s2+"parameters";
}

}
