package it.forecast.Openweather.Stats;

public class PostRequestBodyHandler {

    String city;
    String period;
    Double accuracy;
    String param;

    public PostRequestBodyHandler(String city, String period, Double accuracy, String param) {

        this.city = city;
        this.period = period;
        this.accuracy = accuracy;
        this.param = param;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
