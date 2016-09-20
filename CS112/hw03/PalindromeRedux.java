/*
 * Palindrome.java
 * 
 * Author: Teng Xu
 * Boston University CS 112, Spring 2016
 * 
 * Purpose: This is an exercise in debugging by implementing a
 * palindrome-checker using an auxiliary array. 
 */

import java.util.Arrays;

public class PalindromeRedux {
    
    public static final int SIZE = 10; 
    
    // Check whether str is a palindrome by moving first half of the string
    // to an array, and then go backward through array and forward
    // through str and compare. 
    
     public static boolean debug = true;           // set this to true if you want to trace your execution

     public static void db(String s) {            
          if(debug) 
             System.err.println("\t" + s);      // notice how the tab moves the tracing to the right,
      }                                         // so you don't confuse it with your normal test cases
                                                // Printing to System.err will print in red. 
    
    public static boolean palindrome(String str) {
        
        char[] A = new char[SIZE];        // array to hold first half of string
        int next = 0;                     // next location to put a character                  
        
        // Move first half of str into the array.
        db("Put the first half of the string into the array");
        for (int i = 0; i < Math.round((double)str.length() / 2); i++) {
            db("The first half length " + Math.round((double)str.length() / 2));
            db("Get no."+ i +" string " + Character.toString(str.charAt(i)));
            A[next] = str.charAt(i);
            db("The array: " + Arrays.toString( A ));
            ++next;
        }
        
        
        // Compare array backwards with rest of str. 
        db("Compare array backwards with rest of string");        
        for (int i = str.length() / 2; i < str.length(); i++) {      
            --next; 
            char c = A[next];
            db("Compare the string " + Character.toString(c)+" with " + str.charAt(i));           
            if (c != str.charAt(i))            
                return false;
        }     
        return true;
    }     
    
    public static void main(String[] args) {
        
        System.out.println("\nIs redder a palindrome? Should be true:");
        System.out.println(palindrome("redder"));
        
        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome("reddet"));
        
        // Additional test cases should follow the same pattern.....
        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome("redader"));
        
        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome("x"));

        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome(""));        
    }
    
}