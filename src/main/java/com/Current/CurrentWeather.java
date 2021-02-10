package com.Current;
//consume the Pojo current class
public class CurrentWeather {
	
	private String timezone;
	private Current current;
	
	//Constructors
	public CurrentWeather() {
	}
	public CurrentWeather( String timezone, Current current) {
	super();
	this.timezone = timezone;
	this.current = current;
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
	//toString method, display the results
	@Override
	public String toString() {
		return "CurrentWeather \ntimezone=" + timezone  + current;
	}	
}//End class