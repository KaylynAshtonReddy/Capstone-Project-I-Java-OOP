/*Contractor Class extends Person here with all variables
 * contains all the Getters and setters 
 * Updated the getters and setters for Contractor*/
package com.poised;

public class Contractor extends Person {
	
	static final String PERSONTYPE = "Contractor";
	public Contractor(String firstName, String lastName, String telephoneNumber, String emailAddr, String physicalAddr) {
		super(firstName, lastName, telephoneNumber, emailAddr, physicalAddr);

	}
	
	/*Getters and setters*/
	public void setContractorFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
		
	public void setContractorLastName(String newLastName) {
		this.lastName = newLastName;
	}
	public void setContractorTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public void setContractorEmailAddress(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public void setContractorPhysicalAddr(String physicalAddr) {
		this.physicalAddr = physicalAddr;
	}
	
		@Override
		public String toString() {
			String output = "\n =========" + PERSONTYPE + " Contact Information ========= \n";
			output += "\nName: " + firstName + " " + lastName;
			output += "\nPhone number: " + telephoneNumber;
			output += "\nEmail address: " + emailAddr;
			output += "\nWork address: " + physicalAddr + "\n";
		return output;
			}
	}
