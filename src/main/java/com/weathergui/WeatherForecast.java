package com.weathergui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
//The panel of choosing the forecast type
public class WeatherForecast extends JFrame {
	
	private JPanel contentPane;
	public WeatherForecast() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(contentPane);
		setUndecorated(true);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel PanelSearchCity = new JPanel();
		PanelSearchCity.setBackground(new Color(153, 153, 153));
		PanelSearchCity.setBounds(500, 116, 190, 32);
		contentPane.add(PanelSearchCity);
		
		//label search a city
		JLabel lblSearchCity = new JLabel("Search a city");
		lblSearchCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//on click go to the search city panel
				WeatherForecast.this.dispose();
				SearchCity searchCity = new SearchCity();
				searchCity.setVisible(true);
				
			}
		});
		lblSearchCity.setVerticalAlignment(SwingConstants.TOP);
		lblSearchCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PanelSearchCity.add(lblSearchCity);
		
		JPanel PanelUsingIP = new JPanel();
		PanelUsingIP.setBackground(new Color(153, 153, 153));
		PanelUsingIP.setBounds(500, 190, 190, 32);
		contentPane.add(PanelUsingIP);
		
		JLabel lblUsingIP = new JLabel("Current location");
		lblUsingIP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//on click go to the current location panel
				WeatherForecast.this.dispose();
				CurrentLocation currentLocation= new CurrentLocation();
				currentLocation.setVisible(true);
			}
		});
		lblUsingIP.setVerticalAlignment(SwingConstants.TOP);
		lblUsingIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PanelUsingIP.add(lblUsingIP);
		
		JPanel PanelCityFromList = new JPanel();
		PanelCityFromList.setBackground(new Color(153, 153, 153));
		PanelCityFromList.setBounds(500, 271, 190, 32);
		contentPane.add(PanelCityFromList);
		
		JLabel lblCityFromList = new JLabel("Available cities from list");
		lblCityFromList.addMouseListener(new MouseAdapter() {
			@Override
			//on click go to the available city panel
			public void mouseClicked(MouseEvent e) {
				WeatherForecast.this.dispose();
				CityList cityList = new CityList();
				cityList.setVisible(true);
			}
		});
		lblCityFromList.setVerticalAlignment(SwingConstants.TOP);
		lblCityFromList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PanelCityFromList.add(lblCityFromList);
		
		JPanel PanelBack = new JPanel();
		PanelBack.setBackground(new Color(153, 153, 153));
		PanelBack.setBounds(500, 534, 190, 32);
		contentPane.add(PanelBack);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			//on click go to the previous panel
			public void mouseClicked(MouseEvent e) {
				WeatherForecast.this.dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		lblBack.setVerticalAlignment(SwingConstants.TOP);
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBack.add(lblBack);
		
		JLabel lblNewLabel = new JLabel("Weather Forecast");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(504, 25, 202, 32);
		contentPane.add(lblNewLabel);
	}
}
