/*
 * File: DebuggingExample.java
 * 
 * Author: Wayne Snyder
 * Boston University CS 112, Spring 2016
 * 
 * Purpose: This is an exercise in debugging by implementing a
 * palindrome-checker using an array of chars to store the string
 */

import java.util.Arrays;

public class DebuggingExample {
    
    public static boolean debug = true; 
    
    // Check whether str is a palindrome by reversing a String and then
    // comparing to see if it is the same as before
    
    public static void reverse(char[] C) {
        db("Calling reverse( " + Arrays.toString(C) + " )");
        for(int i = 0, j = C.length-1; i < j; ++i,--j) {
            db("Swapping " + C[i] + " and " + C[j]); 
            char temp = C[i];          // swap C[i] and C[j]
            C[i] = C[j];
            C[j] = temp;
        }
    }
    
    public static boolean palindrome(String str) {
        db("Calling palindrome( " + str + " )");                // Ok, this is a bit of overkill! You don't have to trace very single statement!
        char[] C = str.toCharArray();                           // Just do a couple in various places to check on the computation, and "zero in" on the bugs!
        db("C = " + Arrays.toString(C));
        reverse(C);
        db("C reversed = " + Arrays.toString(C));
        String strReversed = new String(C); 
        db("strReversed = " + strReversed);
        return str.equals( strReversed );    
    } 
    
    
    // just for debugging
    
    public static void db(String s) { 
        if(debug)
            System.err.println("\t" + s);
    }    
    
    // Unit test of palindrome method
    
    public static void main(String[] args) {
        
        // Test of method reverse; test even and odd length, and single-element arrays   
        char[] A = { 'h', 'i', 't', 'h', 'e', 'r', 'e' };
        char[] B = { 'h', 'i' };
        char[] C = { 'h' };      
        
        System.out.println("Testing reverse:");
        System.out.println( Arrays.toString(A) );
        reverse(A);
        System.out.println( Arrays.toString(A) );
        System.out.println();
        
        System.out.println( Arrays.toString(B) );
        reverse(B);
        System.out.println( Arrays.toString(B) );
        System.out.println();
        
        System.out.println( Arrays.toString(C) );
        reverse(C);
        System.out.println( Arrays.toString(C) );        
        System.out.println();
        
        
        // Test of method palindrome: test all possible cases, even and odd length,
        // palindrome and not, strings of length 1 and even empty string
        
        System.out.println("\nTesting palindrome:");
        System.out.println("\nIs redder a palindrome? Should be true:");
        System.out.println(palindrome("redder"));
        
        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome("reddet"));
        
        System.out.println("\nIs abcba a palindrome? Should be true:");
        System.out.println(palindrome("abcba"));
        
        System.out.println("\nIs abcda a palindrome? Should be false:");
        System.out.println(palindrome("abcda"));
        
        System.out.println("\nIs string with one symbol a palindrome? Should be true:");
        System.out.println(palindrome("a"));
        
        System.out.println("\nIs empty string a palindrome? Should be true:");
        System.out.println(palindrome(""));
      

        
    }
    
}