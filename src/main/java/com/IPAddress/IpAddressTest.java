package com.IPAddress;
//consume Pojo IPAddress class
public class IpAddressTest {
	private IpAddress ipAddress;
	
	//Constructors
	public IpAddressTest() {	
	}
	public IpAddressTest(IpAddress ipAddress) {
		super();
		this.ipAddress = ipAddress;
	}
	//setter and getter
	public IpAddress getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	//toString method, display the IPaddress results
	@Override
	public String toString() {
		return String.format("%s",getIpAddress());
	}
}//End class
