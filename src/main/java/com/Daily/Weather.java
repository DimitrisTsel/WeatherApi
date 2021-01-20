package com.Daily;
//Pojo weather class
public class Weather {
	
	private long id;
	private String main;
	private String description;
	private String icon;
	
	//Constructors
	public Weather() {
	}
	public Weather(long id, String main, String description, String icon) {
		super();
		this.id = id;
		this.main = main;
		this.description = description;
		this.icon = icon;
	}
	//setters and getters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	//toString method, display the weather results
	@Override
	public String toString() {
		return  main +", "+ description ;
	}
}//End class

