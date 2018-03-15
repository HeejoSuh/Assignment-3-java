/****************************************************************************
 *
 * Created by: Heejo Suh
 * Created on: Mar 2018
 * Created for: learning
 * 
 * This program generate a random list of 250 values and present them to the user. 
 * Then the list is sorted and presented to the user again. 
 * Finally you enter a number to be found. 
 * If the number is in the list, the position will be returned. 
 * If it is not in the list, the user will be informed of this.
 * 
 * 
 * 
 * Search a sorted array by repeatedly dividing the search interval in half.
 * Compare values and narrow into halves
 * Repeatedly check until the value is found or the interval is empty.
 *     
 *
 ****************************************************************************/



//have to import the following:
import java.util.Scanner;
import java.util.Random;
import java.math.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


//****************************************************************************
public class BinarySearch{

	//------------------------
	public static int binarySearch(List<Integer> inputArray , int inputNumber){
	//Checks if input is in array and return answer
		
		int startCountingPoint = 0, lastCountingPoint = (inputArray.size() -1), middleValue;
		//** to get length of listArray, you need to use '.size()'
		
		
		while (startCountingPoint <= lastCountingPoint) {
			//while range exists
			//check halves for number 
			
			int middlePoint = (int) Math.round( (lastCountingPoint+startCountingPoint)/2 );
			middleValue = inputArray.get(middlePoint);
			
			
			//if input is at middleValue
			if (inputNumber == middleValue) {
				return middlePoint; //this breaks the 'while' and the 'binarySerach'
				
			} else if (inputNumber > middleValue) {
				//if input is greater than middleValue
				//ignore left half
				//all the values less will be useless
				startCountingPoint = middlePoint + 1; //not including mid
				
			} else if (inputNumber < middleValue) {
				//if input is less than middleValue
				//ignore right half
				//all the values greater will be useless
				lastCountingPoint = middlePoint - 1; //not including mid
			}
		}//closing for while
			
		//if reach here, no values are in the list
		//so return '-1'
		return -1;
    }//closing for binarySearch

		
	
	
	//------------------------
	
	public static void main(String args[]){
	//uses the binarySearch function to search
		
		Scanner scanner = new Scanner(System.in);
		String input = "", choice = "";
		int inputNumber = 0, numberOfIntegersInList = 10;
		
		//create random list
		List<Integer> randomList = new ArrayList<>();
		
		
		System.out.println("List:");
		//add 250 random numbers
		for ( int count=0; count<numberOfIntegersInList; count++ ) {  
    		//add random number from 0 to 500
	    	int randNumber= new Random().nextInt(500);
	    	System.out.print(randNumber+" "); //show to user
	    	randomList.add(randNumber);
    	}
		
		
		while (!choice.equals("E")) {
			//not have exited program
			
			//get choice
			while (!choice.equals("I") && !choice.equals("S")){
				//see if user wants to input a value or search
				System.out.println("\n\n\n-----------------------------------------------"
						+ "\nI : insert value\nS : search for value\nE : exit");

				choice = scanner.nextLine();
				
				if (! choice.equals("I") && !choice.equals("S")){
					//error
					System.out.println("Input a valid answer! Try again!");
				}
			}//closing for get choice
			
			
			//get number
			while (input == ""){
				//see if input is a number
				System.out.println("\nInsert a number:");
				
				try {
					//check if response is an integer
					input = scanner.nextLine();
					inputNumber = Integer.parseInt(input);
				}catch (IllegalArgumentException x) { 
					System.out.println("Insert an integer!");
				}
			}//closing for get number
			
			
			
			//return
			if (choice.equals("I")){
				//insert value
				randomList.add(inputNumber);
			}
			
			//sort
			Collections.sort(randomList); //sorts list from least to greatest
			System.out.print("\nSorted list:\n"+randomList+"\n");
			
			if (choice.equals("S")){
				//search value
				int answer = binarySearch(randomList, inputNumber);
				
				if (answer == -1) {
					//not in the list
		            System.out.println("\nNumber is not in the list!");
				} else {
					//in the list

		            System.out.println("\n"+inputNumber+" is at "+answer+" index!");
				}
			}
			

			//need to reset to default
			choice = ""; 
			input = "";
			inputNumber = 0;
			
		}//closing for while not have exitted the program
		
			
    }//closing for main
}//closing for BinarySearch



