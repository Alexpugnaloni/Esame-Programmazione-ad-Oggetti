package it.forecast.Openweather.Model;
/**
 * Classe che rappresenta oggetti che contengono alias assegnato.
 * nome della colonna e tipo di dato.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class Metadata {
    /**
     * Attributi della Classe Metadata.
     */

    private String alias;
    private String sourcefield;
    private String type;

    /**
     * Costruttori della classe Metadata.
     */

    public Metadata() {}

    public Metadata(String alias, String sourcefield, String type) {
        this.alias = alias;
        this.sourcefield = sourcefield;
        this.type = type;
    }

    /**
     * Metodi Getter e Setter degli attributi della classe.
     */

    public String getAlias(){
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSourcefield() {
        return sourcefield;
    }

    public void setSourcefield(String sourcefield) {
        this.sourcefield = sourcefield;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
