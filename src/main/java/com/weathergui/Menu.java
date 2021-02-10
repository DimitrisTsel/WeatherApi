package com.weathergui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
//The main panel of the app
public class Menu extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
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
		PanelSearchCity.setBounds(500, 174, 190, 32);
		contentPane.add(PanelSearchCity);
		JPanel PanelCityHandling = new JPanel();
		PanelCityHandling.setBackground(new Color(153, 153, 153));
		PanelCityHandling.setBounds(406, 95, 145, 32);
		PanelSearchCity.add(PanelCityHandling);

		// label edit cities
		JLabel lblCityHandling = new JLabel("Edit cities");
		lblCityHandling.addMouseListener(new MouseAdapter() {
			@Override
			// dispose menu page and set visible edit cities page
			public void mouseClicked(MouseEvent e) {
				Menu.this.dispose();
				EditCities editCities = new EditCities();
				editCities.setVisible(true);
			}
		});
		lblCityHandling.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCityHandling.setVerticalAlignment(SwingConstants.TOP);
		PanelCityHandling.add(lblCityHandling);

		JPanel PanelWeatherForecast = new JPanel();
		PanelWeatherForecast.setBackground(new Color(153, 153, 153));
		PanelWeatherForecast.setBounds(500, 270, 190, 32);
		contentPane.add(PanelWeatherForecast);

		JPanel PanelCityHandling_1 = new JPanel();
		PanelCityHandling_1.setBackground(new Color(153, 153, 153));
		PanelWeatherForecast.add(PanelCityHandling_1);

		// label weather forecast
		JLabel lblWeatherForecast = new JLabel("Weather forecast");
		lblWeatherForecast.addMouseListener(new MouseAdapter() {
			@Override
			// dispose menu page and set visible weather forecast page
			public void mouseClicked(MouseEvent e) {
				Menu.this.dispose();
				WeatherForecast weatherForecast = new WeatherForecast();
				weatherForecast.setVisible(true);
			}
		});
		lblWeatherForecast.setVerticalAlignment(SwingConstants.TOP);
		lblWeatherForecast.setFont(new Font("Tahoma", Font.BOLD, 14));
		PanelCityHandling_1.add(lblWeatherForecast);

		JPanel PanelExit = new JPanel();
		PanelExit.setBackground(new Color(153, 153, 153));
		PanelExit.setBounds(500, 460, 190, 32);
		contentPane.add(PanelExit);

		JPanel PanelCityHandling_3 = new JPanel();
		PanelCityHandling_3.setBackground(new Color(153, 153, 153));
		PanelExit.add(PanelCityHandling_3);

		// label exit
		JLabel lblExit = new JLabel("Exit");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			// close the app
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					Menu.this.dispose();
				}
			}
		});
		lblExit.setVerticalAlignment(SwingConstants.TOP);
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		PanelCityHandling_3.add(lblExit);

		JLabel lblWeather = new JLabel("Weather Forecast App");
		lblWeather.setForeground(Color.WHITE);
		lblWeather.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWeather.setBounds(472, 48, 329, 32);
		contentPane.add(lblWeather);

	}
}
