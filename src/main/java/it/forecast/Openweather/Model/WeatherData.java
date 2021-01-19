package it.forecast.Openweather.Model;

public class WeatherData {


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

	public WeatherData( String description, Double temperature, Double tempMin, Double tempMax, Double feels_like, Long humidity,Long pressure,String date, String city, String country){

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
	}

	public WeatherData() {

	}


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
	
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + "; ");
		buffer.append("Temperature: " + temperature + "; ");
		buffer.append("Temp Max: " + tempMax + "; ");
		buffer.append("Temp Min: " + tempMin + "; ");
		buffer.append("Feels Like: " + feels_like + "; ");
		buffer.append("Humidity: " + humidity + "; ");
		buffer.append("Pressure: " + pressure + "; ");
		buffer.append("Date: " + date + "; "); 
		return buffer.toString();
	}
	
	
	
}
