/**
 * Town.java 1.0 Mar 31, 2015Mar 31, 2015
 * Copyright (c) 2015 David Han
 * Campus Box 5702, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * Creates an object town that holds a towns name, latitude, longitude, and
 * distance from user in an array
 * 
 * @author David Han
 *
 */
public class Town implements Comparable {
  private String name;
  private double latitude;
  private double longitude;
  private double distance;

  public Town() {

  }

  /**
   * 
   * Creates instances of town's name, latitude, longitude, and distance from
   * user for Town to hold
   *
   * @param String
   *        name of a town
   * @param double latitude of town
   * @param double longitude of town
   * @param distance
   *        between town and user's inputed location
   */
  public Town(String aname, double alatitude, double alongitude,
      double adistance) {
    super();
    name = aname;
    latitude = alatitude;
    longitude = alongitude;
    distance = adistance;
  }

  @Override
  public int compareTo(Object aAnObject) {
    int result = 0;
    Town aTown = (Town) aAnObject;
    double delta = (this.getDistance() - aTown.getDistance());
    if (delta < -0.0000001) {
      result = -1;
    } else if (delta > 0.0000001) {
      result = 1;
    }
    return result;
  }

  /**
   * Displays to standard output of distance
   *
   * @return double distance between town and user's location
   *
   */
  public double getDistance() {
    return distance;
  }

  /**
   * Displays to standard output of latitude
   *
   * @return double town's latitude
   *
   */

  public double getLatitude() {
    return latitude;
  }

  /**
   * Displays to standard output of longitude
   *
   * @return double town's longitude
   *
   */

  public double getLongitude() {
    return longitude;
  }

  /**
   * Displays to standard output of name of the user
   *
   * @return String name of the user
   *
   */

  public String getName() {
    return name;
  }

  /**
   * 
   * Sets a variable distance from location to user
   * 
   * @param double variable to hold distance from location to user
   */

  public void setDistance(double aDistance) {
    distance = aDistance;
  }

  /**
   * 
   * Sets a variable latitude of a location
   * 
   * @param double variable to hold latitude of a location
   */

  public void setLatitude(double aLatitude) {
    latitude = aLatitude;
  }

  /**
   * 
   * Sets a variable longitude of a location
   * 
   * @param double variable to hold longitude of a location
   */

  public void setLongitude(double aLongitude) {
    longitude = aLongitude;
  }

  /**
   * 
   * Sets a variable name for the user's name
   * 
   * @param String
   *        variable to hold name of user
   */

  public void setName(String aName) {
    name = aName;
  }

  @Override
  public String toString() {
    return "Town [name=" + name + ", latitude=" + latitude + ", longitude="
        + longitude + ", distance=" + distance + "]";
  }

}
