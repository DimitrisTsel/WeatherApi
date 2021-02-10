import static org.junit.Assert.*;

import org.junit.Test;

import com.weatherApi.CallWeatherApi;

public class test1 {

	@Test
	public void getCurrentWeather() {
		CallWeatherApi.getCurrentApi("Paris", "metric");
		System.out.println();
	}
	@Test
	public void getCurrentWeatherUsingIP() {
		CallWeatherApi.getCurrentForecastUsingIp("metric");
		System.out.println();
	}
	@Test
	public void getDailyWeather() {
		CallWeatherApi.getCurrentApi("Madrid", "imperial");
		System.out.println();
	}
	@Test
	public void getDailyWeatherUsingIP() {
		CallWeatherApi.getDailyForecastUsingIp("metric");
		System.out.println();
	}
	@Test
	public void getHourlyWeather() {
		CallWeatherApi.getCurrentApi("Berlin", "metric");
		System.out.println();
	}
	@Test
	public void getHourlyWeatherUsingIP() {
		CallWeatherApi.getHourlyForecastUsingIp("imperial");
		System.out.println();
	}
}
