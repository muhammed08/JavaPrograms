/*
  program to find average of N numbers and
  throw an exception if N is negative.
  It will also throws exception if
  an illegal input is given
*/



//importing header files for input operations
import java.io.*;
import java.util.*;

//Class calculator
public class Example
{
	//stores the value of N
	int N;

	//arrlist stores the input values from user
	ArrayList<Integer> arrlist = new ArrayList<Integer>();

	public void getN()
	{
		//new scanner object to take input from user
		Scanner reader = new Scanner(System.in);

		//try to input N
		try
		{

			//taking input value from user for N
			System.out.print("Enter the value for N  :");
			N = reader.nextInt();

			//check if N is negative (N is less than 0)
			if ( N < 0) 
			{
				//throws an exception if N<0
	     		// this gets caught in the catch block
	     		throw new IllegalArgumentException("N must be positive."); 
			} 
		}   
		//catch if the exception happens  
		catch (IllegalArgumentException e) 
		{
			//print the exception message
	    	System.out.println(e.getMessage());
		}

	}

	//input the list of integers
	public void getlist()
	{
		//check if N is greater than zero
		if( N <= 0)
			return;

		//new scanner object to take input from user
		Scanner reader = new Scanner(System.in);

		//count stores the number of inputs
		int count = N;

		System.out.println("Enter the " + N + " values :");
		//loop till the user enters count number of inputs
		while( count > 0)
		{
			try 
			{
				//take input from user
        		int input = reader.nextInt();
        		arrlist.add(input);

        		//decrement the value of count
        		count = count - 1;
   			} 
	   		//catch if there is any error in input
	   		catch (java.util.InputMismatchException e) 
	   		{
	   			 // if the user enters something that is not an integer
		        System.out.println("Please enter a integer value. Trying again...");
		        reader.next(); // consume the non-int so we don't get caught in an endless loop
	    	}
		}
	}

	public void computeAverage()
	{

		//check if N is valid, return if N is invalid
		if ( N < 0 )
			return;
		
		//sumList stores the sum of all integers. It is initialized to zero
		int sumList = 0;

		//average stores the average of all integers (it is a float value)
		double average;

		//loop though all integers to get the sum
		for( int i=0 ; i < N ; i++ )
		{
			//add new input value to sum
			//get(i) return the ith value in list
			sumList = sumList + arrlist.get(i);
		}

		//compute average as average = (Sum of all inputs ) / ( Number of inputs )

		average = (double)sumList / N; //type csting used to convert it into float values

		//print the average value
		System.out.println("The average value is : " + average);


	}

	//main function for the program
	public static void main(String[] args) {

		//create an object of example
		Example E1 = new Example();

		//take the value of N
		E1.getN();

		//take list the integers
		E1.getlist();

		//function to compute and print average
		E1.computeAverage();

	}
}
