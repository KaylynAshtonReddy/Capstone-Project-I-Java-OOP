package com.poised;

import java.util.Scanner;
/*Person Class is constructed here with all variables
 * contains all the Getters and setters 
 * 
 * Updated to remove all setters and getters from Person Class , as it is not used*/

public class Person {
  String firstName;
  String lastName;
  String telephoneNumber;
  String emailAddr;
  String physicalAddr;

  // Initialise scanner

  Scanner input = new Scanner(System.in);

  // Person -  constructor with all variable attributes
  public Person(String firstName, String lastName, String telephoneNumber,
      String emailAddr, String physicalAddr) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephoneNumber = telephoneNumber;
    this.emailAddr = emailAddr;
    this.physicalAddr = physicalAddr;
  }

}


