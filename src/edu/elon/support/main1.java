/**
 * main1.java 1.0 Mar 31, 2015Mar 31, 2015
 * Copyright (c) 2015 David Han
 * Campus Box 5702, Elon University, Elon, NC 27244
 */
package edu.elon.support;

/**
 * 
 * Driver class that has a single main method to instantiate the
 * DistanceController and call top controller method
 * 
 * @author David Han
 *
 */
public class main1 {

  /**
   * 
   * Driver method that starts application
   * 
   * @param args String array of command line arguments not used by application
   * 
   */
  public static void main(String[] args) {
    DistanceController controller = new DistanceController();
    controller.go();
    System.exit(0);
    //hi
  }
}