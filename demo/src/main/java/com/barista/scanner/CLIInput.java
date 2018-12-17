package com.barista.scanner;


	import java.util.Scanner;

import org.springframework.stereotype.Service;
	@Service
	public class CLIInput {
		
		public static void main (String[] args){

			
			String userInput;

			Scanner sn = new Scanner(System.in);
			
			//loop the utility in loop until the user makes the choice to exit
			while(true){
				//Print the options for the user to choose from
				System.out.println("*****Available Options*****");
				System.out.println("*. Press 1 for job number 1");
				System.out.println("*. Press 2 for job number 2");
				System.out.println("*. Press 3 to exit");
		
				System.out.println("Enter your choice:");

				userInput = sn.next();
				
				//Check the user input
				switch(userInput){
				case "1":
					//do the job number 1
					System.out.println("done with job number 1");
					break;
				case "2":
					//do the job number 2
					System.out.println("done with job number 2");
					break;	
				case "3":
					//exit from the program
					System.out.println("Exiting...");
					sn.close();
					System.exit(0);
				default:
					//inform user in case of invalid choice.
					System.out.println("Invalid choice. Read the options carefully...");
				}
			}
		}
	}