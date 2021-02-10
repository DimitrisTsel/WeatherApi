package com.Daily;
//Pojo daily class
import java.util.List;

import com.Current.Current;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Daily {
	
	private long dt;
	private Temp temp1;
	@JsonProperty("feels_like")
	private FeelsLike feelsLike;
	private long humidity;
	@JsonProperty("wind_speed")
	private double windSpeed;
	@JsonProperty("wind_deg")
	private long windDeg;
	private List<Weather> weather = null;
	private long clouds;
	private double pop;
	private double rain;
	private double snow;
	
	//Constructors
	public Daily() {
	}
	public Daily(long dt, Temp temp1, FeelsLike feelsLike, long humidity,double windSpeed, long windDeg, List<Weather> weather, long clouds, double pop, double rain, double snow, Current current) {
	super();
	this.dt = dt;
	this.temp1 = temp1;
	this.feelsLike = feelsLike;
	this.humidity = humidity;
	this.windSpeed = windSpeed;
	this.windDeg = windDeg;
	this.weather = weather;
	this.clouds = clouds;
	this.pop = pop;
	this.rain = rain;
	this.snow = snow;
	}
	//setters and getters
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Temp getTemp1() {
		return temp1;
	}
	public void setTemp(Temp temp1) {
		this.temp1 = temp1;
	}
	public FeelsLike getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(FeelsLike feelsLike) {
		this.feelsLike = feelsLike;
	}
	public long getHumidity() {
		return humidity;
	}	
	public void setHumidity(long humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}	
	public long getWindDeg() {
		return windDeg;
	}
	public void setWindDeg(long windDeg) {
		this.windDeg = windDeg;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}	
	public long getClouds() {
		return clouds;
	}	
	public void setClouds(long clouds) {
		this.clouds = clouds;
	}
	public double getPop() {
		return pop;
	}	
	public void setPop(double pop) {
		this.pop = pop;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
	public double getSnow() {
		return snow;
	}	
	public void setSnow(double snow) {
		this.snow = snow;
	}
	//toString method, display the daily results
	@Override
	public String toString() {
		return "\nDaily:\n"+temp1 +"\n"+ feelsLike+ "\nhumidity="
				+ humidity+"%" + "\nwindSpeed=" + windSpeed + "\nwindDeg=" + windDeg + "\nweather="
				+ weather + "\nclouds=" + clouds+"%" + "\npop=" + pop + "\nrain=" + rain +"\nsnow=" + snow+"\n";
	}
	
}//End class