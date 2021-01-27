package it.forecast.Openweather.Stats;

/**
 * Classe che contiene il costruttore per i body delle chiamate PostRequest.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class PostRequestBodyHandler {
    /**
     * Attributi della classe PostRequestBodyHandler.
     */

    String city;
    String period;
    Double accuracy;
    String param;

    /**
     * Costruttore della classe PostRequestBodyHandler.
     * @param city città di cui visulizzare le statistiche.
     * @param period periodo scelto.
     * @param accuracy margine d'errore.
     * @param param indicatore di cui calcolare l'accuratezza.
     */
    public PostRequestBodyHandler(String city, String period, Double accuracy, String param) {

        this.city = city;
        this.period = period;
        this.accuracy = accuracy;
        this.param = param;
    }

    /**
     * Metodi Getter e Setter degli attributi della classe PostRequestBodyHandler.
     */

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
