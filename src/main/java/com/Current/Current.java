package com.Current;
//Pojo current class
import java.util.Date;
import java.util.List;

import com.Daily.Weather;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Current {
	@JsonProperty("dt")
	private long dt;
	private Date d = new Date(dt);
	@JsonProperty("temp")
	private double temp;
	@JsonProperty("feels_like")
	private double feelsLike;
	@JsonProperty("humidity")
	private long humidity;
	@JsonProperty("clouds")
	private long clouds;
	@JsonProperty("wind_speed")
	private double windSpeed;
	@JsonProperty("wind_deg")
	private long windDeg;
	@JsonProperty("weather")
	private List<Weather> weather = null;
	
	//Constructors
	public Current() {
	}
	public Current(long dt,Date d, double temp, double feelsLike, long humidity,long clouds,double windSpeed, long windDeg, List<Weather> weather) {
		super();
		this.dt = dt;
		this.temp = temp;
		this.feelsLike = feelsLike;
		this.humidity = humidity;
		this.clouds = clouds;
		this.windSpeed = windSpeed;
		this.windDeg = windDeg;
		this.weather = weather;
		this.d=d;
	}
	//setters and getters
	public Date getD() {
		d=new Date(dt*1000);
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public long getDt() {
		return dt;
	}	
	public void setDt(long dt) {
		this.dt = dt;
	}	
	public double getTemp() {
		return temp;
	}	
	public void setTemp(double temp) {
		this.temp = temp;
	}	
	public double getFeelsLike() {
		return feelsLike;
	}	
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}	
	public long getHumidity() {
		return humidity;
	}	
	public void setHumidity(long humidity) {
		this.humidity = humidity;
	}
	public long getClouds() {
		return clouds;
	}
	public void setClouds(long clouds) {
		this.clouds = clouds;
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
	//toString method, display the results
	@Override
	public String toString() {
		return "\nCurrent: \nDatetime:"+getD()+ "\ncurrent temp=" + temp + "\nFeelslike="+feelsLike+"\nhumidity=" + humidity+"%" + "\nclouds=" + clouds+"%" + "\nwindSpeed=" + windSpeed + "\nwindDeg="
				+ windDeg +"\nweather="+weather ;
	}
}//End class