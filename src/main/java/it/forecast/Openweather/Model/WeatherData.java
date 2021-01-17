package it.forecast.Openweather.Model;

public class WeatherData {


	private String description;
	private Double temperature;
	private Double tempMin;
	private Double tempMax;
	private Long humidity;
	private Long pressure;
	private String date;

	public WeatherData( String description, Double temperature, Double tempMin, Double tempMax, Long humidity,Long pressure,String date){

		this.description = description;
		this.temperature = temperature;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.humidity = humidity;
		this.pressure = pressure;
		this.date = date;
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
	
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Temperature: " + temperature + ";");
		return buffer.toString();
	}
	
	
	
}
