package com.IPAddress;
//Pojo IP class
import com.fasterxml.jackson.annotation.JsonProperty;

public class IpAddress {
	@JsonProperty ("longitude")
	private double lon;
	@JsonProperty ("latitude")
	private double lat;
	
	//Constructors	
	public IpAddress() {
	}
	public IpAddress(double lon, double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}
	//setters and getters
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	//return a string containing longitude and latitude information
	@Override
	public String toString() {
		return String.format("lat=%.4f&lon=%.4f", getLat(), getLon());
	} //end method toString 	
}//End class

