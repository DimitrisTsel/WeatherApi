package com.weathergui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.weatherApi.CallWeatherApi;
//The class of getting weather forecast using Ip
public class CurrentLocation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JComboBox comboBoxUnitIp;
	JComboBox comboBoxForecastIp;
	JTextPane textPaneCityIp;
	String unit;
	String forecast;
	String location;
	String c;
	
	public CurrentLocation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(contentPane);
		setUndecorated(true);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setVisible(true);
		JPanel panelSearchACity = new JPanel();
		panelSearchACity.setBackground(Color.DARK_GRAY);
		panelSearchACity.setBounds(0, 0, 165, 650);
		contentPane.add(panelSearchACity);
		panelSearchACity.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 41, 730, 560);
		contentPane.add(scrollPane);
		
		textPaneCityIp = new JTextPane();
		scrollPane.setViewportView(textPaneCityIp);

		JPanel panelExitFromSearchCity = new JPanel();
		panelExitFromSearchCity.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromSearchCity.setBounds(10, 599, 151, 27);
		panelSearchACity.add(panelExitFromSearchCity);
		
		//label back
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			//on click go to the previous page
			public void mouseClicked(MouseEvent e) {
				CurrentLocation.this.dispose();
				WeatherForecast weatherForecast = new WeatherForecast();
				weatherForecast.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelExitFromSearchCity.add(lblBack);
		
		//combobox of unit temp
		comboBoxUnitIp = new JComboBox();
		comboBoxUnitIp.setBackground(new Color(255, 255, 255));
		comboBoxUnitIp.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxUnitIp.setModel(new DefaultComboBoxModel(new String[] { "Celcius", "Farehneit" }));
		comboBoxUnitIp.setBounds(10, 155, 140, 21);
		panelSearchACity.add(comboBoxUnitIp);
		
		//combobox of forecast mode
		comboBoxForecastIp = new JComboBox();
		comboBoxForecastIp.setModel(new DefaultComboBoxModel(new String[] { "Current", "Daily", "Hourly" }));
		comboBoxForecastIp.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxForecastIp.setBackground(Color.WHITE);
		comboBoxForecastIp.setBounds(10, 197, 140, 21);
		panelSearchACity.add(comboBoxForecastIp);
		
		//select temp unit
		comboBoxUnitIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb=comboBoxUnitIp.getSelectedItem().toString();
				if(cb.equals("Celcius")) {
					unit="metric";
				}else if(cb.equals("Farehneit")){
					unit="imperial";
				}
				
			}
		});
		//select forecast mode
		comboBoxForecastIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forecast = comboBoxForecastIp.getSelectedItem().toString();
			}
		});
		//get the temp results
		JButton btnSubmitIp = new JButton("Submit");
		btnSubmitIp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						if(forecast.equals("Current")) {
							c=CallWeatherApi.getCurrentForecastUsingIp(unit);
						textPaneCityIp.setText(c.toString());
						}else if(forecast.equals("Daily")) {
							c=CallWeatherApi.getDailyForecastUsingIp(unit);
							textPaneCityIp.setText(c.toString());
						}else if(forecast.equals("Hourly")) {
							c=CallWeatherApi.getHourlyForecastUsingIp(unit);
							textPaneCityIp.setText(c.toString());
						}
					
				}
			
		});

		btnSubmitIp.setBounds(44, 260, 76, 21);
		panelSearchACity.add(btnSubmitIp);
	}
}
