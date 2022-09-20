/* This project provides a data entry and storage system for a Company named Poised
 * The application allows a user to enter in data for a particular project
 * Once the details are entered in an additional menu will provide more options to the user
 * 
 * The project has been refactored to become more modular and Object orientated
 * Additional classes for Contractor/Customer/Architect have been created
 * Additional methods to limit the amount of code in a single method
 * String literals have been created to reduce code duplication
 * 
 * Updated:06/06/2022
 * Added try-catch blocks to all the NPE possibilities within the toString methods for printing
 * project details to the user
 * 
 * Removed unnecessary getters/setters from the Person Class
 * 
 * Ensured that each line of code does not pass 100 characters*/

package com.poised;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectMain {
  // Strings
  private static String projectNumber;
  private static String projectName;
  private static String projectType;
  private static String projectAddress;
  private static String projectErf;
  // Constants
  private static String enter = "Enter in ";
  private static String teleNum = " Telephone Number";
  private static String emailAddr = " Email Address";
  private static String physicalAddr = " Physical Address";

  // Money related variables
  private static double feeTotal;
  private static double totalFees;
  private static double paidFees;
  private static double feePaid;
  //Date variables
  private static String inputDate;
  private static LocalDate formattedDate;
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  // Person Variables
  private static String firstName;
  private static String lastName;
  private static String personPhone;
  private static String personEmail;
  private static String personWorkAdd;
  private static Architect newArchitect;
  private static Customer newCustomer;
  private static Contractor newContractor;
  private static Project newProject;

  public static void main(String[] args) {
    projectCreationMenu();
    menuTwo();

  }

  /*==============METHODS==============*/
  public static void projectCreationMenu() {
      System.out.println("""
        Welcome to the POISED Project Management system!
        \nKindly enter in the details
        for a new project to begin.\n """);

        // Calling methods
        projectInfo(); feeTotalConversion(); feesPaidInConversion(); projectDeadline();
        System.out.println();
        
        // Call customer method and instantiate object
        createCustomer(); newCustomer = new Customer
        (firstName, lastName, personPhone, personEmail, personWorkAdd);
        
        // Call architect method and instantiate object
        createArchitect(); Architect newArchitect = new Architect
        (firstName, lastName, personPhone, personEmail, personWorkAdd);
        
        // Call contractor method
        createContractor();
        
        // instantiate new project with references to Customer/Contractor & Architect objects
        newProject = new Project(projectNumber, projectName, projectType, projectAddress,
        projectErf, totalFees, paidFees, formattedDate, newCustomer, newContractor, newArchitect);
        System.out.println(newProject.getCustomerDetails());
      }

      /*Method which will request the user info for a new project*/
      public static void projectInfo() {
        Scanner projectUserInput = new Scanner(System.in);
        System.out.println("=== Enter information about the new project === \n");
        System.out.println("Enter the Project's number: ");
        projectNumber = projectUserInput.nextLine();
        System.out.println("Enter the Project's Name: ");
        projectName = projectUserInput.nextLine();
        System.out.println("Enter the type of building: ");
        projectType = projectUserInput.nextLine();
        System.out.println("Enter the physical address: ");
        projectAddress = projectUserInput.nextLine();
        System.out.println("Enter the erf number?: ");
        projectErf = projectUserInput.nextLine();
      }

      public static void feeTotalConversion() {
        boolean correctTotal = true;
        while (correctTotal) {
          Scanner totalAmountPayableInput = new Scanner(System.in);
          System.out.println("\nEnter the customer's total amount payable for the project: ");
          // try to run code or catch exceptions and request input again
          try {
            feeTotal = totalAmountPayableInput.nextDouble();
            break;
          } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("\n Input is not a valid number");
            System.out.println("Please ensure that you are inserting numbers only!");
          }
        }
      }
      public static void feesPaidInConversion() {
        boolean correctFeesPaid = true;
        // Loop to continue requesting input until the correct amount is provided
        while (correctFeesPaid) {
          Scanner totalFeesPaidInInput = new Scanner(System.in);
          System.out.println("\nTotal Project Fees which are paid in: ");
          try {
            feePaid = totalFeesPaidInInput.nextDouble();
            break;
          } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("\n Input is not a valid number");
            System.out.println("Please ensure that you are inserting numbers only!");
          }
        }
      }

      public static LocalDate projectDeadline() {
        boolean newCorrectFormat = true;
        // Printed lines
        while (newCorrectFormat) {

          Scanner input = new Scanner(System.in);
          System.out.println("\n Enter in the Project deadline in the specified format -  dd/MM/YYYY: \n ");
          // Getting the Date from user input as a String
          inputDate = input.nextLine();
          // Using a loop to request input until user enters correct data
          try {
            // Try change string date input into LocalDate class type
            formattedDate = LocalDate.parse(inputDate, formatter);
            System.out.println("Local Date " + formattedDate); // checking the date
            break;
            // Printing the converted date
          }
          // Refactorred the exceptions into 1 line
          catch (IllegalArgumentException | DateTimeParseException | InputMismatchException e) {
            // Display the exception
            System.out.println("Exception: " + e);
            System.out.println("Please try again!");
          }

        }
        return formattedDate;
      }

      public static void createCustomer() {
          /********************************
				Customer Details
			   Request first name
			   Request last name
			   Initialise full name variable
			   Request phone number
			   Request Email Address
			   Request Physical address
			   Instantiate object
			   Set type of person
           *********************************/

          Scanner customerDetailInput = new Scanner(System.in);
          System.out.println("""
          Kindly enter in all the customer details\n 
           """);

            System.out.println("Enter in the customers First Name:"); 
            firstName = customerDetailInput.nextLine();
            System.out.println(enter + "customers Last Name:");
            lastName = customerDetailInput.nextLine();
            String fullName = (firstName + " " + lastName);

            // Create project name if null
            if (projectName == null) {
              projectName = (projectType + " " + lastName);
            } else;

            System.out.println(enter + fullName + teleNum); personPhone = customerDetailInput.nextLine();

            System.out.println(enter + fullName + emailAddr); personEmail = customerDetailInput.nextLine();

            System.out.println(enter + fullName + physicalAddr); personWorkAdd = customerDetailInput.nextLine();

            // Instantiate new Customer object
            newCustomer = new Customer(firstName, lastName, personPhone, personEmail, personWorkAdd);
          }

          public static void createArchitect() {
            /***************************
            	Architect Details
                Request first name
                Request last name
                Initialise full name variable
                Request phone number
                Request Email Address
                Request Physical address
                Instantiate object
                Set type of person
             ***********************/
            Scanner architectDetailInput = new Scanner(System.in);
            System.out.println("\nKindly enter in all the Architect details \n");
            System.out.println(enter + " the Architect First Name:");
            firstName = architectDetailInput.nextLine();

            System.out.println(enter + " the Architect Last Name:");
            lastName = architectDetailInput.nextLine();

            String architectFullName = (firstName + " " + lastName);
            System.out.println(enter + architectFullName + teleNum);
            personPhone = architectDetailInput.nextLine();

            System.out.println(enter + architectFullName + emailAddr);
            personEmail = architectDetailInput.nextLine();

            System.out.println(enter + architectFullName + physicalAddr);
            personWorkAdd = architectDetailInput.nextLine();
          }

          public static void createContractor() {
            /***************************
			 Contractor Details
			    Request first name
			    Request last name
			    Initialise full name variable
			    Request phone number
			    Request Email Address
			    Request Physical address
			    Instantiate object
			    Set type of person
		    ****************************/
            Scanner contractorDetailInput = new Scanner(System.in);
            System.out.println("\nKindly enter in all the Contractors details \n");
            System.out.println(enter + " the Contractors First Name:");
            firstName = contractorDetailInput.nextLine();

            System.out.println(enter + " the contractors Last Name:");
            lastName = contractorDetailInput.nextLine();
            String contractorFullName = (firstName + " " + lastName);

            System.out.println(enter + contractorFullName + teleNum);
            personPhone = contractorDetailInput.nextLine();

            System.out.println(enter + contractorFullName + emailAddr);
            personEmail = contractorDetailInput.nextLine();

            System.out.println(enter + contractorFullName + physicalAddr);
            personWorkAdd = contractorDetailInput.nextLine();

            newContractor = new Contractor(firstName, lastName, personPhone, personEmail,
            		personWorkAdd);
            System.out.println(newContractor.toString());
          }
//
          @SuppressWarnings("finally")
          public static void menuTwo() {

            try (Scanner input = new Scanner(System.in)) {
              int menuChoice = 0;

              while (menuChoice != 7) {
                //Updated the Menu printout
                System.out.println("""
                  === === = Welcome to Menu 2 === === === =
                  Please select from the below options below:
                  1. Create new project 
                  2. Change Due Date 
                  3. Change amount paid to date
                  4. Change contractor details 
                  5. Finalise the project 
                  6. Print Project details 
                  7. Exit
                  """);

                  menuChoice = input.nextInt();
                  switch (menuChoice) {
                  case 1: {
                    // Call the menu method to create project
                    projectCreationMenu();
                    break;
                  }
                  case 2: {

                    System.out.println(newProject.getprojectDeadline());
                    // create new date which gets assigned the value of the project deadline
                    LocalDate newdDeadLine = projectDeadline();
                    newProject.setprojectDeadline(newdDeadLine);
                    System.out.println("The new project deadline has been updapted to " +
                      newProject.getprojectDeadline());
                    break;
                  }
                  case 3: {

                    System.out.println("\n The current total fees that are outstanding is: "
                    + newProject.getFeePaid() + "\n");
                    System.out.println("Enter in the amount to pay: ");
                    double feeUpdate = input.nextDouble();

                    // call method to update Fees paid
                    newProject.updateFeesPaid(feeUpdate);
                    System.out.println("Total fees paid to date is: " + newProject.getFeePaid());

                    // Call the menu method to create project
                    break;
                  }
                  case 4: {
                    // Update all Contractor details
                    Scanner sc = new Scanner(System.in);

                    System.out.println(" Change the contractors details \n");
                    System.out.println(" Please enter in the new Contractor first name \n");
                    String userInput = sc.nextLine();

                    newContractor.setContractorFirstName(userInput);
                    System.out.println(" Please enter in the new Contractor last name \n");
                    userInput = sc.nextLine();

                    newContractor.setContractorLastName(userInput);
                    System.out.println(" Please enter in the new Contractors Phone Number \n");
                    userInput = sc.nextLine();

                    newContractor.setContractorTelephoneNumber(userInput);
                    System.out.println(" Please enter in the new Contractors Email Address \n");
                    userInput = sc.nextLine();

                    newContractor.setContractorEmailAddress(userInput);
                    System.out.println(" Please enter in the new Contractors Work Address \n");
                    userInput = sc.nextLine();

                    newContractor.setContractorPhysicalAddr(userInput);
                    System.out.println(newContractor.toString());
                    System.out.println(newCustomer.toString());
                    break; // This will exit the program

                  }

                  case 5: {
                    newProject.setprojectFinalised();
                    System.out.println("The Project " + newProject.getprojectErf() 
                    + "has been finalised");
                    break;
                  }
                  case 6: {
                	  String errorMessage  = " this operation cannot be completed."
                	  		+ "\nPlease add a Project first";
                    System.out.println("======Project Details======");
                    
    				try {
    					System.out.println(newProject.toString());
    				} catch (NullPointerException e) {
    					System.out.println(e+ "\nThe Project object is empty,"
    							+ errorMessage);
    				}
    				try {
    					System.out.println(newCustomer.toString());
    				} catch (NullPointerException e) {
    					System.out.println(e+ "\nThe Customer object is empty,"
    							+ errorMessage);
    				}
    				try {
    					System.out.println(newContractor.toString());
    				} catch (NullPointerException e) {
    					System.out.println(e+ "\nThe Contractor object is empty,"
    							+ errorMessage);
    				}
    				try {
    					System.out.println(newArchitect.toString());
    				} catch (NullPointerException e) {
    					System.out.println(e+ "\nThe Architect object is empty,"
    							+ errorMessage);
    				}
                    break;
                  }
                  case 7: {
                    System.out.println("Thank you for using the Project Manager \n" + "Goodbye");
                    System.exit(0);
                    break;
                  }
                  default: {
                    System.out.println("Incorrect option selected!");
                    break;
                  }
                  }
                }
              }
            }
          }