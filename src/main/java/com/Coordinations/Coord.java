package com.Coordinations;
//Pojo coord class
public class Coord {
	//declare the coordinates
	private double lat;
	private double lon;
	
	//Constructors
	public Coord() {
	}

	public Coord(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	//setters and getters
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}	
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	//toString method, the coordinates are presented
	@Override
	public String toString() {
		return String.format("lat=%4f&lon=%4f", getLat(),getLon());
	}
}//End class