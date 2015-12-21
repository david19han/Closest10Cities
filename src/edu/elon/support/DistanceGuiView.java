/*
 * DistanceGuiView.java 1.0 Mar 29, 2015
 *
 * Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * View to get input data from user and display results.
 *
 * @author David Han
 * 
 * 
 */
public class DistanceGuiView {

  private double userLat;
  private double userLong;
  private String name;
  private int closestCities;
  private File selectedFile;

  private ArrayList<Integer> locId = new ArrayList<Integer>();
  private ArrayList<String> country = new ArrayList<String>();
  private ArrayList<String> region = new ArrayList<String>();
  private ArrayList<String> cities = new ArrayList<String>();
  private ArrayList<String> postalCode = new ArrayList<String>();
  private ArrayList<Double> latitudes = new ArrayList<Double>();
  private ArrayList<Double> longitudes = new ArrayList<Double>();

  /**
   * 
   * Prompts user to select a file, reads file line by line creating an instance
   * of an identical file in order file is correct type, then continues to
   * prompt user until correct file is chosen.
   * 
   *
   * @catch displays error message indicating file is invalid
   * 
   */

  public void chooseFile() {

    JFileChooser chooser = new JFileChooser();
    Scanner in = null;
    Scanner in2 = null;
    String firstline = "";
    String secondline = "";
    boolean valid = false;

    while (!valid) {// or valid == false. valid checks for boolean true. !valid checks for boolean that is false.
      try {
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          selectedFile = chooser.getSelectedFile();
          in = new Scanner(selectedFile);
          firstline = in.nextLine();
          secondline = in.nextLine();
          int lineNumber = 1;
          ArrayList<String> lineArray = new ArrayList();

          while (in.hasNextLine()) {
            String line = in.nextLine();
            lineArray.add(line);
            lineNumber++;

          }
          for (int i = 0; i < lineArray.size(); i++) {
            in2 = new Scanner(lineArray.get(i));
            in2.useDelimiter(",");

            locId.add(Integer.parseInt(in2.next()));
            country.add(in2.next());
            region.add(in2.next());
            cities.add(in2.next());
            postalCode.add(in2.next());
            latitudes.add(Double.parseDouble(in2.next()));
            longitudes.add(Double.parseDouble(in2.next()));

          }
          valid = true;
        }
      }

      catch (IOException exception) {

        String title = "Invalid File";
        String message = "The file" + selectedFile + "is not in proper format";
        JOptionPane.showMessageDialog(null, message, title,
            JOptionPane.INFORMATION_MESSAGE);
      }

    }
  }

  /**
   * Displays a formatted table of locations and their latitudes and longitudes
   * closest to the user based on their desired number of cities.
   *
   * @param Town
   *        array called city that holds the number of desired cities distance
   *        from users, their names, and locations.
   * @param String
   *        name of user
   * @param integer
   *        number of cities prompted by user
   * 
   *
   */
  public void finalDisplayMessage(Town[] city, String name, int closestCities) {

    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
        "Monospaced", Font.PLAIN, 12)));

    String headers = String.format("%-25s %-16s %-16s %-15s\n", "Location",
        "Latitude", "Longitude", "Mileage");

    for (int i = 0; i < closestCities; i++) {

      String cityName = city[i].getName();
      String finalcityName = cityName.substring(1, cityName.length() - 1);

      headers = headers
          + String.format("%-25s %-16s %-16s %11.2f\n", finalcityName,
              city[i].getLatitude(), city[i].getLongitude(),
              city[i].getDistance());
    }

    JOptionPane.showMessageDialog(null, "\nClosest " + closestCities + " to "
        + name + " are: " + " \n" + headers, "Closest Cities",
        JOptionPane.QUESTION_MESSAGE);
  }

  /**
   * 
   * Displays to standard output of city names in an array
   * 
   * @return Array List String type of cities
   */

  public ArrayList getCitiesArray() {
    return cities;
  }

  /**
   * 
   * Prompts user for desired number of cities closest to them
   * 
   * @return integer number of cities the user wants
   */
  public int getClosestCities() {
    String inputs = JOptionPane.showInputDialog(null,
        "Enter your desired number of closest cities to your location",
        "Number Of Closest Cities", JOptionPane.QUESTION_MESSAGE);
    closestCities = Integer.parseInt(inputs);

    return closestCities;
  }

  /**
   * 
   * Displays to standard output of latitudes in an array
   * 
   * @return Array List double type of latitudes
   */

  public ArrayList getLatitudeArray() {
    return latitudes;
  }

  /**
   * 
   * Displays to standard output of longitudes in an array
   * 
   * @return Array List double type of longitudes
   */

  public ArrayList getLongitudeArray() {
    return longitudes;
  }

  /**
   * 
   * First prompt for the user, asks name
   * 
   * @return string name of user
   * 
   */

  public String getName() {
    String inputs = JOptionPane.showInputDialog(null, "Enter your name",
        "User Entry", JOptionPane.QUESTION_MESSAGE);
    name = inputs;

    return name;
  }

  /**
   * Asks user for current latitude coordinate
   *
   * @return double user's latitude
   */

  public double getUserLat() {
    String inputs = JOptionPane.showInputDialog(null, "Enter your latitude",
        "Latitude Entry", JOptionPane.QUESTION_MESSAGE);
    userLat = Double.parseDouble(inputs);

    return userLat;
  }

  /**
   * Prompts user for current longitude coordinate
   *
   * @return double user's longitude
   */
  public double getUserLong() {

    String inputs = JOptionPane.showInputDialog(null, "Enter your longitude",
        "Longitude Entry", JOptionPane.QUESTION_MESSAGE);
    userLong = Double.parseDouble(inputs);

    return userLong;
  }
}
