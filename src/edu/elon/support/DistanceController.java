/*
 * DistanceController.java 1.0 Mar 29, 2015
 *
 * Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.support;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Calculates the closest distance in a comma, seperated value file of locations
 * based on a user's input latitude and longitude.
 *
 * @author David Han
 *
 * 
 */
public class DistanceController {
  /**
   * Top level control method that creates instance of View, gets user's name,
   * latitude, longitude, and desired number of closest cities, reads through
   * file selected by user and sorts data in array lists, creates an instance of
   * Model to call distance calculating methods, then organizes found distances
   * between the user in a class called Town that holds names of towns,
   * corresponding latitudes, longitudes, and distances, then sorts and limits
   * number of locations displayed based on user's desired locations.
   * 
   * Display to the user all desired number of cities that are closest
   * 
   */

  public void go() {
    DistanceGuiView view = new DistanceGuiView();
    DistanceModel model = new DistanceModel();

    view.chooseFile();

    String username = view.getName();
    double userLat = view.getUserLat();
    double userLong = view.getUserLong();
    int closestCities = view.getClosestCities();

    ArrayList<Double> latitudes = view.getLatitudeArray();
    ArrayList<Double> longitudes = view.getLongitudeArray();
    ArrayList<String> cities = view.getCitiesArray();

    ArrayList<Double> distances = new ArrayList<Double>();

    for (int i = 0; i < cities.size(); i++) {
      distances.add(model.haversineFormula(userLat, userLong, latitudes.get(i),
          longitudes.get(i)));
    }

    Town[] city = new Town[cities.size()];
    Town towni;
    for (int i = 0; i < cities.size(); i++) {
      towni = new Town(cities.get(i), latitudes.get(i), longitudes.get(i),
          distances.get(i));
      city[i] = towni;
    }

    Arrays.sort(city);
    

    Town[] closestCitiesArray = Arrays.copyOf(city, closestCities);
    
    System.out.println(closestCitiesArray[2]);
    System.out.println(closestCitiesArray[2].hashCode());
    view.finalDisplayMessage(city, username, closestCities);

  }
}
