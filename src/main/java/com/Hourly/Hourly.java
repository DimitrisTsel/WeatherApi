package com.Hourly;
//Pojo hourly class
import java.util.Date;
import java.util.List;
import com.Daily.Weather;
public class Hourly {	
	private long dt;
	private Date d = new Date(dt);
	private double temp;
	private List<Weather> weather = null;
	
	//Constructors
	public Hourly() {
	}
	public Hourly(long dt,Date d, double temp, List<Weather> weather) {
		super();
		this.dt = dt;
		this.d=d;
		this.temp = temp;
		this.weather = weather;
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
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	//toString method, display hourly results
	@Override
	public String toString() {
		return "\n\nHourly:\nDatetime:"+getD()+"\nAverage temp=" + temp + "\nweather=" + weather;
	}
}//End class