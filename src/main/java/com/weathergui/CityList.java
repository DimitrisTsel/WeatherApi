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
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

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

//The class of the List of available cities
public class CityList extends JFrame {
	private JPanel contentPane;
	private JTable table;
	JComboBox comboBoxUnit;
	JComboBox comboBoxForecast;
	JTextPane textPaneCity;
	String unit;
	String forecast;
	String location;
	String c;
	
	public CityList() {
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

		JLabel lblCityList = new JLabel("City List");
		lblCityList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityList.setForeground(Color.WHITE);
		lblCityList.setBounds(10, 97, 92, 13);
		panelSearchACity.add(lblCityList);

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
				CityList.this.dispose();
				WeatherForecast weatherForecast = new WeatherForecast();
				weatherForecast.setVisible(true);
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelExitFromSearchCity.add(lblBack);
		
		//choose the temperature unit
		comboBoxUnit = new JComboBox();
		comboBoxUnit.setBackground(new Color(255, 255, 255));
		comboBoxUnit.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxUnit.setModel(new DefaultComboBoxModel(new String[] { "Celcius", "Farehneit" }));
		comboBoxUnit.setBounds(10, 155, 140, 21);
		panelSearchACity.add(comboBoxUnit);
		
		//choose temperature mode
		comboBoxForecast = new JComboBox();
		comboBoxForecast.setModel(new DefaultComboBoxModel(new String[] { "Current", "Daily", "Hourly" }));
		comboBoxForecast.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxForecast.setBackground(Color.WHITE);
		comboBoxForecast.setBounds(10, 197, 140, 21);
		panelSearchACity.add(comboBoxForecast);
		
		//available city list
		final JComboBox comboBoxCityList = new JComboBox();
		comboBoxCityList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location = comboBoxCityList.getSelectedItem().toString();
			}
		});
		comboBoxCityList.setBounds(11, 120, 140, 21);
		panelSearchACity.add(comboBoxCityList);

		// Open List
		Scanner input = null;
		try {
			input = new Scanner(Paths.get("cities.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (input.hasNext()) // while there is more to read
		{
			comboBoxCityList.addItem(input.next());

		}
		//choose temp unit
		comboBoxUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = comboBoxUnit.getSelectedItem().toString();
				if (cb.equals("Celcius")) {
					unit = "metric";
				} else if (cb.equals("Farehneit")) {
					unit = "imperial";
				}

			}
		});
		//get the forecast mode
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
				if (forecast.equals("Current")) {
					c = CallWeatherApi.getCurrentApi(location, unit);
					textPaneCity.setText(c.toString());
				} else if (forecast.equals("Daily")) {
					c = CallWeatherApi.getDailyApi(location, unit);
					textPaneCity.setText(c.toString());
				} else if (forecast.equals("Hourly")) {
					c = CallWeatherApi.getHourlyApi(location, unit);
					textPaneCity.setText(c.toString());
				}

			}

		});

		btnSubmit.setBounds(44, 260, 76, 21);
		panelSearchACity.add(btnSubmit);

	}
}