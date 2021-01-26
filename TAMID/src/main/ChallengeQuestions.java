package main;

import java.util.Scanner;

public class ChallengeQuestions {
	/*
	 * returns a sorted array of the first k elements given two sorted arrays (arr1, arr2) and a number, k
	 */
	public static int[] SortArrays(int[] a1,int[] a2, int k) {
		
		int[] result = new int[k]; // will store the result
		int i = 0, j = 0, t = 0; // i and j are the indexes for the arrays t is used to stop the loop 
		
		//if one of the arrays are empty it will return this makes it pass the last text but it wont work if you only want a few 
	    //indexes for example 3. I'm not sure how to make that work in less than 15 lines 
		if(a1.length == 0) {
			return a2;
		}
		if(a2.length == 0) {
			return a1;
		}
		
		//this loop compares the index of both arrays and adds the smaller one to the result array. if the index is added it also gets incremented
		//to the next index. t is incremented at the end so the loop stops at the correct time. 
		while(t<k) {
			if(a1[i] <= a2[j]) {
				result[t] = a1[i];
				i++;
			}
			else {
				result[t] = a2[j];
				j++;
			}
			t++;
		}
		return result;	
	}
	
	/*
	 * prompt the user for two numbers, and a function (+, -, *, /, and %). It should then print out the result. 
	 * Will keep prompting the user to do more calculations until they enter "n"
	 */
	public static void Calculator() {
		// the error handeling does not work and im not sure why when i go the the else statement it gives a input mismatch error instead of 
		//asking for a new number in the console
		
		//num 1 and 2 will store the input and math will store the operator 
		int num1 = 0 , num2 = 0;
		char math;
		String t = "y";
		
		// used to take input and store it into its variable
		Scanner scan = new Scanner(System.in);
		
		while(t.toLowerCase() != "n") {
			
		System.out.println("Enter first number ");
		if(scan.hasNextInt()) {
			num1 = scan.nextInt();
		}
		else {
			System.out.println("please enter a number ");
			num1 = scan.nextInt();
		}
		
		System.out.println("Enter second number ");
		// this is makes sure that the input is a number. When I do this for the first number it gives me an input mismatch error to
		if (scan.hasNextInt()) {
			num2 = scan.nextInt();
		}
		else {
			System.out.println("please enter a number ");
			num2 = scan.nextInt();
		}
		System.out.println("Enter the operator");
		math = scan.next().charAt(0);
		
		// calls helper method to do the calculation
		System.out.println(calculate(num1,num2,math));
		System.out.println("Do you want to continue? (y/n)");
		if (scan.next().toLowerCase().equals("n")) {
			t = "n";
		}
		}
	}
	
	public static double calculate(int a,int b,char c) {
		// figures out what operation was called and returns the result
		double answer = -1;
		if (c == '+') {
			answer = a+b;
		}
		else if(c == '-') {
			answer = a-b;
		}
		else if(c == '*') {
			answer = a*b;
		}
		else if(c == '/') {
			answer = a/b;
		}
		else if(c == '%') {
			answer = a%b;
		}
		
		return answer;		
	}
	
	
	/*
	 * takes a list of strings an prints them, one per line, in a rectangular frame
	 */
	public static void boxedStrings(String[] arr) {
		// i dont know how to format the right line correctly 
		int mLength = 0; // the length of the longest word
		for(String s : arr) {
			if (s.length() > mLength ) {
				mLength = s.length();
			}
		}
		
		System.out.println("*".repeat(mLength+4));
		for(String str : arr) {
			System.out.println("* " + str + " *");
		}
		System.out.println("*".repeat(mLength+4));
	}
	
	/*
	 *  tests whether a string is a palindrome. A palindrome is defined as a word that is the exact same forwards as it is backwards.
	 */
	public static boolean isPalindrome(String text) {
		String str = text.toLowerCase(); // makes everything lower case
	    int length = str.length();
	    int forward = 0;// the front index
	    int backward = length - 1;// the back index
	    
	    // iterates through the word from the front and back and checks to see if the characters are the same until backward and forward are equal
	    // if it gets to that point then it is a palindrome. 
	    while (backward > forward) {
	        char forwardChar = str.charAt(forward++);
	        System.out.println(str.charAt(forward));
	        char backwardChar = str.charAt(backward--);
	        if (forwardChar != backwardChar)
	            return false;
	    }
	    return true;
	}
}
