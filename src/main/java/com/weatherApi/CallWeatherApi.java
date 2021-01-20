package com.weatherApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.Coordinations.CoordTest;
import com.Current.CurrentWeather;
import com.Daily.DailyWeather;
import com.Hourly.HourlyWeather;
import com.IPAddress.IpAddress;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CallWeatherApi {
	
	private static final String OpenWeatherApiKey = "cc048903dd1da2a3432cee10c4f61661";
	private static final String AccessIPkey = "737c8d45325cd14987d1ee427b0cc1bf";
	private static final String IpAddress = "http://myip.dnsomatic.com/";
	private static final String getCoordinates = "http://api.ipstack.com/";
	private static final String OpenWeatherOneCall = "https://api.openweathermap.org/data/2.5/onecall";
	private static final String OpenWeatherCurrent = "http://api.openweathermap.org/data/2.5/weather";
	
	public static BufferedReader in = null;
	
	public static void getCurrentApi(String location,String type){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		try {
			HttpGet getRequestCity=new HttpGet(OpenWeatherCurrent+"?q="+location+"&appid="+OpenWeatherApiKey);
			getRequestCity.addHeader("accept", "application/json");
			HttpResponse responseCity=httpClient.execute(getRequestCity);
			
			CoordTest city = null;
			ObjectMapper mapperCity=new ObjectMapper();
			mapperCity.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			city=mapperCity.readValue(responseCity.getEntity().getContent(), CoordTest.class);
			
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+city.toString()+"&exclude=daily,minutely,hourly,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			
			CurrentWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), CurrentWeather.class);
				System.out.println(c.toString());
		}
		catch(JacksonException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally{
			   httpClient.close();
		}
	}
	public static void getCurrentForecastUsingIp(String type) {
		DefaultHttpClient httpClient = new DefaultHttpClient();		
		 try 
         {
          URL myIP = new URL(IpAddress);

          in = new BufferedReader(new InputStreamReader(myIP.openStream()));
         
         } catch (Exception e1) 
         {
         }try {
			//Find IP
			HttpGet getRequestCoordIP = new HttpGet(getCoordinates+in.readLine()+"?access_key="+AccessIPkey+"&format=1");
		
			getRequestCoordIP.addHeader("accept", "application/json");

			HttpResponse responseCoord = httpClient.execute(getRequestCoordIP);

			IpAddress coordIP = null; 

			ObjectMapper mapperCoordIP = new ObjectMapper();
			mapperCoordIP.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			coordIP = mapperCoordIP.readValue(responseCoord.getEntity().getContent(), IpAddress.class);
			
			//OpenWeather data
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+coordIP.toString()+"&exclude=daily,minutely,hourly,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			System.out.println(coordIP.toString());
			CurrentWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), CurrentWeather.class);
				System.out.println(c.toString());
		}
		catch(JacksonException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e1) 
        {
        }finally{
			   httpClient.close();
		}
	}
	public static void getDailyApi(String location, String type){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		try {
			HttpGet getRequestCity=new HttpGet(OpenWeatherCurrent+"?q="+location+"&appid="+OpenWeatherApiKey);
			getRequestCity.addHeader("accept", "application/json");
			HttpResponse responseCity=httpClient.execute(getRequestCity);
			
			CoordTest city = null;
			ObjectMapper mapperCity=new ObjectMapper();
			mapperCity.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			city=mapperCity.readValue(responseCity.getEntity().getContent(), CoordTest.class);
		
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+city.toString()+"&exclude=minutely,hourly,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			
			DailyWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), DailyWeather.class);
				System.out.println(c.toString());
		}
		catch(JacksonException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally{
			   httpClient.close();
		}
	}	
	public static void getDailyForecastUsingIp(String type) {
		DefaultHttpClient httpClient = new DefaultHttpClient();		
		 try 
        {
         URL myIP = new URL(IpAddress);

         in = new BufferedReader(new InputStreamReader(myIP.openStream()));
        
        } catch (Exception e1) 
        {
        }try {
			//Find IP
			HttpGet getRequestCoordIP = new HttpGet(getCoordinates+in.readLine()+"?access_key="+AccessIPkey+"&format=1");
		
			getRequestCoordIP.addHeader("accept", "application/json");

			HttpResponse responseCoord = httpClient.execute(getRequestCoordIP);

			IpAddress coordIP = null; 

			ObjectMapper mapperCoordIP = new ObjectMapper();
			mapperCoordIP.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			coordIP = mapperCoordIP.readValue(responseCoord.getEntity().getContent(), IpAddress.class);
			
			//OpenWeather data
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+coordIP.toString()+"&exclude=minutely,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			System.out.println(coordIP.toString());
			DailyWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), DailyWeather.class);
				System.out.println(c.toString());
		}
		catch(JacksonException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e1) 
       {
       }finally{
		 httpClient.close();
		}
	}	
	public static void getHourlyApi(String location,String type){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		try {
			HttpGet getRequestCity=new HttpGet(OpenWeatherCurrent+"?q="+location+"&appid="+OpenWeatherApiKey);
			getRequestCity.addHeader("accept", "application/json");
			HttpResponse responseCity=httpClient.execute(getRequestCity);
			CoordTest city = null;
			ObjectMapper mapperCity=new ObjectMapper();
			mapperCity.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			city=mapperCity.readValue(responseCity.getEntity().getContent(), CoordTest.class);
			
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+city.toString()+"&exclude=current,daily,minutely,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			
			HourlyWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), HourlyWeather.class);
			System.out.println(c.toString());
		}
		catch(JacksonException e) {
			e.printStackTrace();
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally{
			   httpClient.close();
		}
	}
	public static void getHourlyForecastUsingIp(String type) {
		DefaultHttpClient httpClient = new DefaultHttpClient();		
		try {
		  URL myIP = new URL(IpAddress);		
		  in = new BufferedReader(new InputStreamReader(myIP.openStream()));		   
		  }catch (Exception e1) 
		  {
		  }try {
			//Find IP
			HttpGet getRequestCoordIP = new HttpGet(getCoordinates+in.readLine()+"?access_key="+AccessIPkey+"&format=1");			
			getRequestCoordIP.addHeader("accept", "application/json");		
			HttpResponse responseCoord = httpClient.execute(getRequestCoordIP);
			IpAddress coordIP = null; 	
			ObjectMapper mapperCoordIP = new ObjectMapper();
			mapperCoordIP.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);		
			coordIP = mapperCoordIP.readValue(responseCoord.getEntity().getContent(), IpAddress.class);
				
			//OpenWeather data
			HttpGet getRequest=new HttpGet(OpenWeatherOneCall+"?"+coordIP.toString()+"&exclude=minutely,alerts&appid="+OpenWeatherApiKey+"&units="+type);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response=httpClient.execute(getRequest);
			System.out.println(coordIP.toString());
			HourlyWeather c = null;
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			c=mapper.readValue(response.getEntity().getContent(), HourlyWeather.class);
			System.out.println(c.toString());
			}
			catch(JacksonException e) {
				e.printStackTrace();
			}
			catch(ClientProtocolException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}catch (Exception e1) 
		  	{
		  	}finally{
			 httpClient.close();
			}
	}
		
}

