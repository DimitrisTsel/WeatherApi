package com.Coordinations;
//consumes the results of Pojo coord class
public class CoordTest {
	private Coord coord;
	//Constructors
	public CoordTest() {	
	}
	public CoordTest(Coord coord) {
		super();
		this.coord=coord;
	}
	//setter and getter
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	//toString method, display the result
	public String toString() {
		return String.format("%s",getCoord());
	}
}//End class
