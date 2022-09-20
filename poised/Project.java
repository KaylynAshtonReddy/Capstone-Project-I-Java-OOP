/*Project Class is constructed here with all variables
 * contains all the Getters and setters */

package com.poised;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Project {
	String projectNumber;
	String projectName;
	String projectType ;
	String projectAddress;
	String projectErf ;
	
	LocalDate projectDeadline;
	
    // money-related attributes:

	double feeTotal;
	double feePaid;
	

	LocalDate formattedDate;

    // variables to hold input used to create a Person object
    String firstName = null;
    String lastName = null;
    String personPhone = null;
    String personEmail = null;
    String personWorkAdd = null;
//    
//
	// Project finalisation attributes - also not in the constructor
	boolean projectStatus = false;       // default is false for finalised or not
	LocalDate dateCompleted;
	private Customer newCustomer;
	private Contractor newContractor;
	private Architect newArchitect;

	// full constructor - arguments excluding completed date and finalised boolean
	public Project(String projectNumber, String projectName, String projectType, String projectAddress, String projectErf, double totalCost,
			double paidFees, LocalDate formattedDate, Customer newCustomer, Contractor newContractor, Architect newArchitect) {
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectAddress = projectAddress;
		this.projectErf = projectErf;
		this.feeTotal = totalCost;
		this.feePaid= paidFees;
		this.projectDeadline = formattedDate;
		this.newCustomer= newCustomer;
		this.newContractor= newContractor;
		this.newArchitect = newArchitect;
		
		
	}

	// Creation of all getters and setters for all attributes
	public String getprojectNumber() {
		return projectNumber;
	}


	public void setprojectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getprojectName() {
		return projectName;
	}


	public void setprojectName(String projectName) {
		this.projectName = projectName;
	}
	

	public String getprojectType() {
		return projectType;
	}

	public void setprojectType(String projectType) {
		this.projectType = projectType;
	}


	public void setprojectAdress(String projectAdress) {
		this.projectAddress = projectAdress;
	}

	public String getprojectErf() {
		return projectErf;
	}

	public void setprojectErf(String projectErf) {
		this.projectErf = projectErf;
	}

	public LocalDate getprojectDeadline() {
		return projectDeadline;
	}

	public LocalDate setprojectDeadline(LocalDate userDate) {
		this.projectDeadline = userDate; 
		return projectDeadline;
	}

	public String getprojectAddress() {
		return projectAddress;
	}

	public void setprojectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	
	public boolean isprojectFinalised() {
		return projectStatus;
	}

	public void setprojectFinalised() {
		this.projectStatus = true;
		
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	
	public double getFeeTotal() {
		return feeTotal;
	}

	public double updateFeesPaid(double inputFees) {
		 this.feePaid = this.feePaid + inputFees;
		 return feePaid;

	}
	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}

	public double getFeePaid() {
		return feePaid;
		}

	public void setDateCompleted(LocalDate dateComplete) {
		this.dateCompleted = dateComplete;

	
	}
	
	public String getCustomerDetails() {
		return this.newCustomer.toString();
	}

	
	// toString override method that returns attributes as a string
	public String toString() {
		String output = "\n--- Project Information ---";
		output += "\nProject number       : " 	+ projectNumber;
		output += "\nProject name         : " 	+ projectName; 
		output += "\nProperty type       : " 	+ projectType;
		output += "\nProperty address    : " 	+ projectAddress; 
		output += "\nProperty ERF number : "		+ projectErf; 
		output += "\nProject total cost  : R" 	+ feeTotal; 
		output += "\nProject amount paid : R" 	+ feePaid;
		output += "\nProject deadline    : " 	+ projectDeadline;
		
		// Condition to print if the project is finalised or not
		if (!this.isprojectFinalised()) {
			output += "\nProject finalised     :No";
		}
		else {
			output += "\nProject finalised: Yes";
		}
		return Project.class == null ? "" : Project.class.toString();
	}

}
