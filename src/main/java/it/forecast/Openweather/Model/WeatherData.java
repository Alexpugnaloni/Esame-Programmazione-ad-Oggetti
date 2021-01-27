package it.forecast.Openweather.Model;

/**
 * Classe che contiene i dati del servizio meteo.
 * @author Pugnaloni Alex
 * @author Riva Tommaso
 */

public class WeatherData {
	/**
	 * attributi della classe WeatherData settati private.
	 */


	private String description;
	private Double temperature;
	private Double tempMin;
	private Double tempMax;
	private Double feels_like;
	private Long humidity;
	private Long pressure;
	private String date;
	private String city;
	private String country;
	private String mainCondition;

	/**
	 * Costruttore della Classe WeatherData con i suoi attributi.
	 * @param description descrizione.
	 * @param temperature temperatura.
	 * @param tempMin temperatura minima.
	 * @param tempMax temperatura massima.
	 * @param feels_like temperatura percepita.
	 * @param humidity umidità.
	 * @param pressure pressione.
	 * @param date data e ora.
	 * @param city città.
	 * @param country paese.
	 * @param mainCondition condizione principale.
	 */

	public WeatherData( String description, Double temperature, Double tempMin, Double tempMax, Double feels_like, Long humidity,Long pressure,String date, String city, String country, String mainCondition){

		this.description = description;
		this.temperature = temperature;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.feels_like = feels_like;
		this.humidity = humidity;
		this.pressure = pressure;
		this.date = date;
		this.city = city;
		this.country = country;
		this.mainCondition = mainCondition;
	}

	public WeatherData() {

	}

	/**
	 * serie di getter e setter per gli attributi della classe WeatherData.
	 */

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {

		this.description = description;
	}

	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Double getFeels_like() {return feels_like;}
	public void setFeels_like(Double feels_like) {this.feels_like = feels_like;}
	
	public Long getHumidity() {
		return humidity;
	}
	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}
	
	public Long getPressure() {
		return pressure;
	}
	public void setPressure(Long pressure) {
		this.pressure = pressure;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}

	public String getCountry(){
		return country;
	}
	public void setCountry(String country){
		this.country = country;
	}

	public String getMainCondition(){
		return mainCondition;
	}
	public void setMainCondition(String mainCondition){
		this.mainCondition= mainCondition;
	}


	
	
	
}
