/*
Author: Amirreza Pazira 
UCID: 30133500 
Tutorial: 08

Version: 13-April-2021

Program: Simple recursive implementation to error check user's input 


Program Features: Program asks the user for an Age input if it's in range the program will display the age and if it's out of range
it will use recursion to keep asking the user for an input within the valid range.

Program Limitations: The range can't be changed
*/


import java.util.Scanner;

public class RecursiveDriver
{
	// Variables for the Min and Max of the age range
    public static final int MIN_AGE = 1;
    public static final int MAX_AGE = 144;
    public static Scanner in = new Scanner(System.in);
 
    //Features: uses recursion to keep asking for an valid age input and if the value is within the valid range it will
    //return it back to the main method and if it's not in the valid range it will use recursion to call itself again.
    public static int promptForAge()
    {
        int age = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the age (1-144): ");
        age = in.nextInt();
        if ((age < MIN_AGE) || (age > MAX_AGE)) 
        {
            age = promptForAge();
        }
        return(age);
    }
    //Main method that calls the promptForAge() method for an age input then it will print the return value
    public static void main(String [] args)
    {
        int age = 0;
        age = promptForAge();  
        System.out.println("Age: " + age);        
    }
}