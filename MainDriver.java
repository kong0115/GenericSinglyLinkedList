/*
Name of the Student: Siang Swee Kong
	Class: SE 3345
	Section: 003
	Semester: Fall 2018
	Project: 2
	Description: A program that implements a generic singly linked list to store a list of Magazine objects.
	The Magazine class implements IDedObject interface and hold the information of the magazine ID, magazine name, and publisher name.
	User is asked to chose from a list of operations such as making the list empty, find the magazine ID and print out the details of the magazine,
	insert a magazine at the beginning of the list, delete a magazine from the front of the list, delete a magazine with given magazine ID, and print all the magazines in the list. 
*/

import java.util.Scanner; //for reading from the keyboard

public class MainDriver {
	private static Scanner scan;
	public static void main(String[] args)  
	{
		GenericSinglyLinkedList<Magazine> magazineList = new GenericSinglyLinkedList<>(); //create a singly linked list to hold Magazine type objects
		Magazine temp = new Magazine();  //temporary variable for a Magazine object
		int choice; //to store user choice
		int magazineID; //to store magazine ID
		String magazineName; //to store magazine name
		String publisherName; //to store publisher name
		String input; //used to test the input validation
		boolean flag; 
		boolean moreOperation = true; 
		boolean validInput; //used to indicate if the input is a valid input
		scan = new Scanner(System.in); //reading from System.in
		
		while(moreOperation)
		{
			//Display menu
			System.out.println("\nOperations on a Singly Linked List");
			System.out.println("Please enter a number that match your desired operation.");
			System.out.println("\t1. Make Empty");
			System.out.println("\t2. Find ID");
			System.out.println("\t3. Insert At Front");
			System.out.println("\t4. Delete From Front");
			System.out.println("\t5. Delete ID");
			System.out.println("\t6. Print All Records");
			System.out.println("\t7. Done");
			System.out.print("Your choice: ");

			input = scan.nextLine(); //take the user input as a string 
			validInput = InputValidation.isPositiveNumber(input); //check if the string contains only positive numbers
			while(!validInput) //if the choice is not a positive number, ask the user for another choice until a user enters a valid input
			{
				System.out.println("Invalid input data type. \nPlease enter a valid operation."); 
				input = scan.nextLine();
				validInput = InputValidation.isPositiveNumber(input);
			}
			choice = Integer.parseInt(input); //convert the string to an int

			switch(choice) {
			case 1:	magazineList.makeEmpty(); //make the list empty
					System.out.println("The list is now empty.");
					break;

			case 2:	System.out.print("Please enter the magazine ID that you are looking for: "); //ask user for the magazine ID
					input = scan.nextLine(); //take the user input as a string 
					validInput = InputValidation.isPositiveNumber(input); //check if the string contains only positive numbers
					while (!validInput)//if the input is not a positive number, ask the user for another input until a user enters a valid input
					{
						System.out.print("Invalid input data type. \nPlease enter a valid magazine ID: ");
						input = scan.nextLine();
						validInput = InputValidation.isPositiveNumber(input);
					}
		
					magazineID = Integer.parseInt(input); //convert the string to an int
					temp = magazineList.findID(magazineID); //find the magazine ID in the list
					if (temp == null) //magazine ID does not exist
					{
						System.out.println("The requested Magazine ID is not in the list.");
					}
					else //magazine with the given ID is found in the list
					{
						temp.printID(); //print all the details of the magazine
					}
					break;

			case 3:	System.out.print("Enter Magazine ID: "); //ask user for the magazine ID
					input = scan.nextLine();//take the user input as a string
					validInput = InputValidation.isPositiveNumber(input); //check if the string contains only positive numbers
					while (!validInput)//if the input is not a positive number, ask the user for another input until a user enters a valid input
					{
						System.out.print("Invalid input data type. \nPlease enter a valid magazine ID: ");
						input = scan.nextLine();
						validInput = InputValidation.isPositiveNumber(input);
					}
					magazineID = Integer.parseInt(input); //convert the string to an int
					System.out.print("Enter Magazine Name: "); //ask user for the magazine name
					magazineName = scan.nextLine();
					System.out.print("Enter Publisher Name: ");//ask user for the publisher name
					publisherName = scan.nextLine();
					Magazine newMagazine = new Magazine(magazineID,magazineName,publisherName); //create a new magazine object and initializes the attributes with given data.
					flag = magazineList.insertAtFront(newMagazine); //insert the magazine object at the beginning of the list
					if(flag)	//the magazine has not yet been existed in the list
					{
						System.out.println("Magazine is successfully added.");
					}
					else	//magazine is already existed
					{
						System.out.println("The magazine is already existed in the list. \nInsertion failed. ");
					}
					break;

			case 4: temp = magazineList.deleteFromFront(); //delete a magazine from the front of the list
					if (temp == null) //the list is empty
					{
						System.out.println("The list is empty. \nNothing can be deleted.");
					}
					else //deletion successful
					{
						System.out.println("The details of the first item on the list: ");
						temp.printID(); //print the first item on the list 
						System.out.println("This magazine is now deleted.");
					}
					break;

			case 5:	System.out.print("Please enter the magazine ID that you wish to delete: "); //ask user for the magazine ID
					input = scan.nextLine();//take the user input as a string
					validInput = InputValidation.isPositiveNumber(input); //check if the string contains only positive numbers
					while (!validInput)//if the input is not a positive number, ask the user for another input until a user enters a valid input
					{
						System.out.print("Invalid input data type. \nPlease enter a valid magazine ID: ");
						input = scan.nextLine();
						validInput = InputValidation.isPositiveNumber(input);
					}
					magazineID = Integer.parseInt(input); //convert the string to an int
					temp = magazineList.delete(magazineID);
					if (temp == null)	//deletion fail
					{
						System.out.println("The magazine ID is not found. \nNo deletion occurs.");
					}
					else	//deletion successful
					{
						System.out.println("The requested magazine ID is found.");
						temp.printID(); //print particular IDed item
						System.out.println("This magazine is now deleted.");
					}
					break;

			case 6:	magazineList.printAllRecords();//print all the magazine records in the list
					break;

			case 7: System.out.println("Done.");	
					System.out.println("End of the program.");
					moreOperation = false; //quit the program, stop the loop
					break;

			default: System.out.println("The number entered was not part of the operations listed. \nPlease enter a valid operation number."); //when choice is not from 1 - 7
			}
		}
		
		System.exit(0); //terminate the program
	}
}
