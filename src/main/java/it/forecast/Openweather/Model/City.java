package it.forecast.Openweather.Model;

public class City {
    private Long id;
    private String city;
    private String country;

    public City(Long id, String city, String country) {
        this.id = id;
        this.city= city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("Id: " + id + ";");
        buffer.append("City: " + city + ";");
        return buffer.toString();
    }
}
