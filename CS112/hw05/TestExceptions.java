/* File: TestExceptions.java
 * Author: Wayne Snyder
 * Date: 2/18/16
 * Purpose: Just a simple program to show
 *     how exceptions work, for Lab 05 in CS 112, Spring 2016. 
 */

import java.util.Scanner;


public class TestExceptions {
    
    static Scanner in = new Scanner(System.in);
    
    public static int promptAndInputInteger() throws TooLargeException,TooSmallException {
        
        System.out.println("Input Positive Integer between 5 and 10:");
        int n = inputInteger(); 
        if(n > 10)
            throw new TooLargeException("Integer is too large: " + n);
        else
            return n;
    }
    
    public static int inputInteger() throws TooSmallException {
        int m = in.nextInt(); 
        if(m < 5)
            throw new TooSmallException(m);
        else
            return m;
    }
    
    public static void main(String[] args) {
        
        try { 
            int k = promptAndInputInteger();
            System.out.println("Correct: " + k);
            
        }       
        catch (TooSmallException e) {
            System.out.println("Value too small: " + e.value);
            
        }        
        catch (TooLargeException e) {
            // this uses the built-in messaging feature of exceptions
            System.out.println(e.getMessage());
            
        }
        // the code in a finally clause will be run after the exception is caught
        // and handled
        finally {
            System.out.println("Done");
        }        
    }
    
}

// Exceptions are classes that can live in the same file as the public class,
// they can not be "public" or "private" and they must include the phrase
// "extends Exception" as shown. 


class TooSmallException extends Exception {
    int value;
    // this is a constructor that stores a value in the exception to be thrown. 
    public TooSmallException(int n) {
        value = n;       
    }
    
}

// here is an example of using the built-in messaging system
// don't change the following constructor, which simply constructs
// an exception with a String message given by msg; this can be
// retrieved using the build-in method getMessage(), see catch class above.

class TooLargeException extends Exception {
    
    public TooLargeException(String msg) {
        super(msg);       
    }
}


