package com.Daily;
//consume the Pojo daily class
import java.util.List;

import com.Current.Current;

public class DailyWeather {
	
	private String timezone;
	private Current current;
	private List<Daily> daily = null;
	
	//Constructors
	public DailyWeather() {
	}
	public DailyWeather(String timezone, Current current, List<Daily> daily) {
		super();
		this.timezone = timezone;
		this.current = current;
		this.daily = daily;
	}
	//setters and getters
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}	
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	public List<Daily> getDaily() {
		return daily;
	}
	public void setDaily(List<Daily> daily) {
		this.daily = daily;
	}
	//toString method, display results
	@Override
	public String toString() {
		return "DailyWeather \ntimezone=" + timezone + "\n" + current + "\n" + daily.subList(0, 5);
	}
}//End class