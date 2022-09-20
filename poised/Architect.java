/*Architect extends Person here with all variables
 * contains all the Getters and setters */

package com.poised;

public class Architect extends Person {
	
	static final String PERSONTYPE = "Architect";
	public Architect(String firstName, String lastName, String telephoneNumber, String emailAddr, String physicalAddr) {
		super(firstName, lastName, telephoneNumber, emailAddr, physicalAddr);

	}
	public String toString() {
		String output = "\n =========" + PERSONTYPE + " Contact Information ========= \n";
		output += "\nName: " + firstName + " " + lastName;
		output += "\nPhone number: " + telephoneNumber;
		output += "\nEmail address: " + emailAddr;
		output += "\nWork address: " + physicalAddr+ "\n";
	return output;
	}
}
