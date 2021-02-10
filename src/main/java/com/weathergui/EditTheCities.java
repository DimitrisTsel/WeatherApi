package com.weathergui;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class EditTheCities {
	private static Scanner input;
	private static Formatter output;

	//add city method
	public static void addCity(String name) throws IOException {
		openFile();
		addRecord(name);
		closeFile();
	}

	// open file cities.txt
	public static void openFile() throws IOException {
		try {
			FileWriter f = new FileWriter("cities.txt", true);
			output = new Formatter(f);

		} catch (SecurityException securityException) {
			System.err.println("Write permission denied. Terminating.");
			System.exit(1); // terminate the program
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		}
	}

	// add records to file
	public static void addRecord(String city) {

		try {
			// output new record to file; assumes valid input
			output.format("%s%n", city);
		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Error writing to file. Terminating.");

		} catch (NoSuchElementException noSuchElementException) {
			System.err.println("Invalid input. Please try again.");
			System.exit(1); // discard input so user can try again
		}
	} 

	// delete a city method
	public static void deleteCity(String lineContent) throws IOException {
	    File file = new File("cities.txt");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    String line = "";
	    List<String> fileContents = new ArrayList<String>();

	    //loop through each line
	    while ((line = br.readLine()) != null) {
	        if (line.contains(lineContent)) {
	            //skip
	            continue;
	        }
	        fileContents.add(line);
	    }

	    br.close();

	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));

	    //loop buffer
	    for (String s : fileContents) {
	        bw.write(s);
	        bw.newLine();
	    }
	    bw.close();
	}
	
	//read city method
	public static void readCity() throws IOException {
		openFiles();
		readRecords();
		closeFile();
	}

	// open file cities.txt
	public static void openFiles() {
		try {
			input = new Scanner(Paths.get("cities.txt"));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	// read record from file
	public static void readRecords() {
		System.out.printf("%-10s%n", "Available Cities");

		try {
			while (input.hasNext()) // while there is more to read
			{
				// display record contents
				System.out.printf("%-10s%n", input.next());
			}

		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.");
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating.");
		}
	} 

	// close file
	public static void closeFile() {
		if (output != null)
			output.close();
	} 
} 
