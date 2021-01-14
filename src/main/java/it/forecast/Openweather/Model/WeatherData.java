package it.forecast.Openweather.Model;

public class WeatherData {

	private String city;
	private String description;
	private String temperature;
	private String tempMin;
	private String tempMax;
	private String humidity;
	private String pressure;
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
	
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getTempMin() {
		return tempMin;
	}
	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}
	
	
	
	
	public String getTempMax() {
		return tempMax;
	}
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	
	
	
	
	
	
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
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
