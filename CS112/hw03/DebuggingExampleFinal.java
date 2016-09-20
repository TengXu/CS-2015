/*
 * File: DebuggingExampleFinal.java
 * 
 * Author: Wayne Snyder
 * Boston University CS 112, Spring 2016
 * 
 * Purpose: This is a palindrome checker for Lab 03
 */

import java.util.Scanner;

public class DebuggingExampleFinal {
    
    // Check whether str is a palindrome by reversing a String and then
    // comparing to see if it is the same as before
    
    public static void reverse(char[] C) {
        for(int i = 0, j = C.length-1; i < j; ++i,--j) { 
            char temp = C[i];          // swap C[i] and C[j]
            C[i] = C[j];
            C[j] = temp;
        }
    }
    
    public static boolean palindrome(String str) {
        char[] C = str.toCharArray();
        reverse(C);
        String strReversed = new String(C); 
        return str.equals( strReversed );    
    } 
        
    
    public static void main(String[] args) {
        
        // Print out welcome message
        
        System.out.println("\nWelcome to the Palindrome Test Program!");
        
        // Define a scanner for user input
        
        Scanner userInput = new Scanner(System.in);
        
        while(userInput.hasNextLine()) {
            
            String line = userInput.nextLine();
            
            if(palindrome(line)) 
                System.out.println("Palindrome!");
            else
                System.out.println("Not a palindrome!");
        }
        System.out.println("Bye!");
    }
}