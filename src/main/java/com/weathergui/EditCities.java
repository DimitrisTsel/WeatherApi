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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JEditorPane;
import java.awt.Color;
//Edit cities class
public class EditCities extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldCity;
	
	public EditCities() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(contentPane);
		setUndecorated(true);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setVisible(true);
		JPanel panelEditCities= new JPanel();
		panelEditCities.setBackground(Color.DARK_GRAY);
		panelEditCities.setBounds(0, 0, 171, 650);
		contentPane.add(panelEditCities);
		panelEditCities.setLayout(null);
		
		JLabel lblCityName = new JLabel("City name");
		lblCityName.setForeground(Color.WHITE);
		lblCityName.setBounds(10, 103, 92, 13);
		panelEditCities.add(lblCityName);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(10, 116, 140, 19);
		panelEditCities.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		//add cities
		JButton btnInsertCity = new JButton("Insert");					
		btnInsertCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = textFieldCity.getText();
				try {
					File file = new File("cities.txt");
					Scanner inputStream = new Scanner(new FileInputStream(file));
					if ((inputStream.hasNextLine()) && (inputStream.useDelimiter("\\Z").next().toLowerCase().contains(city.toLowerCase()))) {
						JFrame frame = new JFrame("ERROR");
						JOptionPane.showMessageDialog(frame, "City already exists.","ERROR" ,JOptionPane.OK_OPTION);
						textFieldCity.setText("");
					}else {
					EditTheCities.addCity(textFieldCity.getText());
					JOptionPane.showMessageDialog(null,"Insert completed" );
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInsertCity.setBounds(31, 246, 103, 21);
		panelEditCities.add(btnInsertCity);
		
		JPanel panelExitFromEditClasses = new JPanel();
		panelExitFromEditClasses.setBackground(SystemColor.activeCaptionBorder);
		panelExitFromEditClasses.setBounds(10, 599, 151, 27);
		panelEditCities.add(panelExitFromEditClasses);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			//on click go to the previous page
			public void mouseClicked(MouseEvent e) {
				EditCities.this.dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
							
			}
		});
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelExitFromEditClasses.add(lblBack);
		
		//delete city
		JButton btnDeleteCity = new JButton("Delete");
		btnDeleteCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cityDel = textFieldCity.getText();
				try {
				File file = new File("cities.txt");
				Scanner inputStream = new Scanner(new FileInputStream(file));
				
				if (!inputStream.hasNextLine()) {
					JFrame frame = new JFrame("ERROR");
					JOptionPane.showMessageDialog(frame, "The list of the cities is empty.","ERROR" ,JOptionPane.OK_OPTION);
				}
				else if ((inputStream.hasNextLine()) && (!(new Scanner(new File("cities.txt")).useDelimiter("\\Z").next().toLowerCase().contains(cityDel.toLowerCase())))) {
					JFrame frame = new JFrame("ERROR");
					JOptionPane.showMessageDialog(frame, "City does not exist.","ERROR" ,JOptionPane.OK_OPTION);
					textFieldCity.setText("");
				}
				else { 						
					String line = "";
				    //The list where you are writing all your lines to
				    List<String> fileContents = new ArrayList<String>();
				    while (inputStream.hasNextLine()) {
						line = inputStream.nextLine();
				        if (!line.toLowerCase().contains(cityDel.toLowerCase())) {
					        fileContents.add(line);
				        }
				    }
				    inputStream.close();
				    PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
				    for (String s : fileContents) {
				    	outputStream.write(s);
				    	outputStream.println();
					    }
				    outputStream.close();
						
				    textFieldCity.setText("");
				    JOptionPane.showMessageDialog(null,"Delete completed" );
				}
			} catch (FileNotFoundException e1) {
				JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Failed to open the file","ERROR" ,JOptionPane.OK_OPTION);
				System.exit(0);
		}
	}
	});
		btnDeleteCity.setBounds(31, 298, 103, 21);
		panelEditCities.add(btnDeleteCity);
		
		//on click load in a pop up window with the available cities list
		JButton btnLoadCities = new JButton("Load");
		btnLoadCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JTextArea ta = new JTextArea(20, 60);
					ta.read(new FileReader("cities.txt"), null);
					ta.setEditable(false);
					JOptionPane.showMessageDialog(null, new JScrollPane(ta));
					}
					catch (IOException ioe) {
					ioe.printStackTrace();
					}
					}
					});
		btnLoadCities.setBounds(1061, 2, 129, 21);
		contentPane.add(btnLoadCities);	
	}
}