package com.weathergui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.weatherApi.CallWeatherApi;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
//The class of getting temp results searching a city
public class SearchCity extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCityName;
	private JTable table;
	JComboBox comboBoxUnit;
	JComboBox comboBoxForecast;
	JTextPane textPaneCity;
	String unit;
	String forecast;
	String location;
	String c;

	public SearchCity() {
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
		
		textPaneCity = new JTextPane();
		scrollPane.setViewportView(textPaneCity);

		//label city name
		JLabel lblCityName = new JLabel("City name");
		lblCityName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityName.setForeground(Color.WHITE);
		lblCityName.setBounds(10, 97, 92, 13);
		panelSearchACity.add(lblCityName);
		
		//textfield of city name
		textFieldCityName = new JTextField();
		
		textFieldCityName.setBounds(10, 116, 140, 19);
		panelSearchACity.add(textFieldCityName);
		textFieldCityName.setColumns(10);

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
				SearchCity.this.dispose();
				WeatherForecast weatherForecast = new WeatherForecast();
				weatherForecast.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelExitFromSearchCity.add(lblBack);
		
		//combobox of temp unit
		comboBoxUnit = new JComboBox();
		comboBoxUnit.setBackground(new Color(255, 255, 255));
		comboBoxUnit.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxUnit.setModel(new DefaultComboBoxModel(new String[] { "Celcius", "Farehneit" }));
		comboBoxUnit.setBounds(10, 155, 140, 21);
		panelSearchACity.add(comboBoxUnit);
		
		//combobox of temp mode
		comboBoxForecast = new JComboBox();
		comboBoxForecast.setModel(new DefaultComboBoxModel(new String[] { "Current", "Daily", "Hourly" }));
		comboBoxForecast.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxForecast.setBackground(Color.WHITE);
		comboBoxForecast.setBounds(10, 197, 140, 21);
		panelSearchACity.add(comboBoxForecast);
		
		//select location
		textFieldCityName.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		location = textFieldCityName.getText();
			}
		});
		//select temp unit
		comboBoxUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb=comboBoxUnit.getSelectedItem().toString();
				if(cb.equals("Celcius")) {
					unit="metric";
				}else if(cb.equals("Farehneit")){
					unit="imperial";
				}
				
			}
		});
		//select type of forecast
		comboBoxForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forecast = comboBoxForecast.getSelectedItem().toString();
			}
		});
		//get the temp results
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						if(forecast.equals("Current")) {
							c=CallWeatherApi.getCurrentApi(location,unit);
						textPaneCity.setText(c.toString());
						}else if(forecast.equals("Daily")) {
							c=CallWeatherApi.getDailyApi(location, unit);
							textPaneCity.setText(c.toString());
						}else if(forecast.equals("Hourly")) {
							c=CallWeatherApi.getHourlyApi(location, unit);
							textPaneCity.setText(c.toString());
						}
					
				}
			
		});
		btnSubmit.setBounds(44, 260, 76, 21);
		panelSearchACity.add(btnSubmit);
	}
}