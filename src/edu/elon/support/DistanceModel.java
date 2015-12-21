/*
 * DistanceModel.java 1.0 Mar 29, 2015
 *
 * Copyright (c) 2015 David Han
 * Campus Box 2320, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * Math based class that calculates distance based on generic latitude and
 * longitude variables
 * 
 *
 * @author David Han 
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceModel {

  private final double RADIUS = 3959.0;
  private double degreeLat = 0;
  private double radianLat = 0;
  private double degreeLong = 0;
  private double radianLong = 0;

  /**
   * Formula that calculates the distance between two locations based on their
   * latutides and logitudes
   *
   * @param double generic latitude variable holder
   * @param double generic longitude variable holder
   * @param double second generic latitude variable holder
   * @param double generic longitude variable holder
   * 
   * @return double distance between two location's latitudes and logitudes
   */
  public double haversineFormula(double latitude1, double longitude1,
          double latitude2, double longitude2) {

    double distance = 0;
    double sinpowerLat = 0;
    double sinpowerLong = 0;
    double term2 = 0;
    double squareRoot = 0;

    degreeLong = ((longitude1 - longitude2) / 2);
    radianLong = degreeLong * (Math.PI / 180);
    degreeLat = ((latitude1 - latitude2) / 2);
    radianLat = degreeLat * (Math.PI / 180);
    latitude1 = latitude1 * (Math.PI / 180);
    latitude2 = latitude2 * (Math.PI / 180);

    sinpowerLat = Math.pow(Math.sin(radianLat), 2);
    sinpowerLong = Math.pow(Math.sin(radianLong), 2);
    term2 = Math.cos(latitude1) * Math.cos(latitude2) * sinpowerLong;
    squareRoot = Math.sqrt(sinpowerLat + term2);
    distance = 2 * RADIUS * Math.asin(squareRoot);

    return distance;

  }

}
