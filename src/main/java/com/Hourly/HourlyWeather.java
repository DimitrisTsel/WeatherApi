package com.Hourly;
//consume Pojo hourly class
import java.util.List;

public class HourlyWeather {
	private String timezone;
	private List<Hourly> hourly = null;
	
	//Constructors
	public HourlyWeather() {
	}
	public HourlyWeather(String timezone, long timezoneOffset, List<Hourly> hourly) {
		super();
		this.timezone = timezone;
		this.hourly = hourly;
	}
	//setters and getters
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public List<Hourly> getHourly() {
		return hourly;
	}
	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}
	//toString method, display hourly results
	@Override
	public String toString() {
		return "HourlyWeather \ntimezone=" + timezone + "\nhourly=" + hourly +"\n";
	}
}//End class