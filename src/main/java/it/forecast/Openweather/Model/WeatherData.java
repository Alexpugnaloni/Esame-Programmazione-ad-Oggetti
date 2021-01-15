package it.forecast.Openweather.Model;

public class WeatherData {

	private String city;
	private String description;
	private Double temperature;
	private Double tempMin;
	private Double tempMax;
	private Integer humidity;
	private Integer pressure;
	private String date;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	
	
	
	
	
	
	
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("City: " + city + ";");
		buffer.append("Description: " + description + ";");
		buffer.append("Temperature: " + temperature + ";");
		return buffer.toString();
	}
	
	
	
}
