/* File: Stack.java
 * Date: 2/11/16
 * Author:  Wayne Snyder (waysnyder@gmail.com)
 * Class: CS 112, Spring 2016
 * Purpose: This is part of the code distribution for HW 04, Problem B.2; this class is an Abstract Data
 *      Type for a stack, a data structure in which you can push integers on one end, pop them
 *      of the same end, and check if the stack is empty. You may not touch anything that is 
 *      not at the top of the stack. Think of a pile of plates, and you can't do anything but 
 *      touch the top plate!
 * 
 * Warning: No error checking is done for overflow or underflow!
 */

public class IntStack  { 
    
    // default size, can be changed by the constructor
    private int SIZE = 10;            
    
    private int[] A = new int[SIZE];
    
    private int next = 0;             // index of next available slot in the array
    
    // default constructor, nothing to do!
    // call it like this:
    //       IntStack S = new IntStack();
    //       S.push(3); 
    //       etc.
    
    public IntStack() {
    }
    
    // constructor to change size of the array
    // call it like this:
    //       IntStack S = new IntStack(50);         // now you have an array of size 50
    //       S.push(3); 
    //       etc.
    public IntStack(int n) {
        SIZE = n;
        A = new int[SIZE];
    }
    
    // return the number of integers in the stack
    
    public int size() {
        return next; 
    }
    
    // put a new integer on the top of the stack
    // don't worry about overflow!
    
    public void push(int n) {
        A[next] = n;
        ++next;
    }
    
    // remove and return the top element on the stack
    // don't worry about error from underflow!
    
    public int pop() {
        --next;
        return A[next];
    }
    
    // return top element of stack WITHOUT removing it
    // don't worry about error from underflow!
    
    public int top() {
        return A[next-1];
    }
    
    // just check if stack is empty
    
    public boolean isEmpty() {
        return (next == 0);
    }
    
    // This will return a String representation of the stack
    // Call it like this:
    //       IntStack S = new IntStack(); 
    //       System.out.println( S.toString() )
    // or--the preferred way--just use the name of the stack and Java will know to use toString():
    //       System.out.println( S );
    
    public String toString() {
        String s = "| ";
        for(int i = 0; i < next; ++i) {
            s += (A[i] + " ");
        }
        return s;    
    }
    
    // Unit Tests
    
    public static void main(String [] args) {
        
        System.out.println("\nUnit Test for IntStack Class");
        
        IntStack S = new IntStack();
        
        S.push(5);
        S.push(6);
        S.push(2);
        S.push(9);
        S.push(5);
        
        System.out.println("\nTest 1: Should be (printed twice):\n| 5 6 2 9 5");
        System.out.println( S.toString() ); 
        System.out.println( S ); 
        
        int n = S.pop();
        int m = S.pop();
        
        System.out.println("\nTest 2: Should be:\n2");
        System.out.println( S.top()); 
        
        System.out.println("\nTest 3: Should be:\n| 5 6 2  n = 5  m = 9");
        System.out.println( S + " n = " + n + "  m = " + m);
        
        S.push(9);
        S.push(5);
        
        IntStack T = new IntStack(20); 
        
        System.out.println("\nTest 4: Should be:\ntrue");
        System.out.println( T.isEmpty() );
        
        T.push(3);
        T.push(1);
        T.push(4);
        T.push(1);
        
        System.out.println("\nTest 5: Should be:\nfalse");
        System.out.println( T.isEmpty() );
        
        while(!T.isEmpty()) {
            S.push( T.pop() );
        }
        
        System.out.println("\nTest 6: Should be:\n| 5 6 2 9 5 1 4 1 3");
        System.out.println( S ); 
        
        while(!S.isEmpty()) {
            T.push( S.pop() );
        }
        
        System.out.println("\nTest 7: Should be:\n| 3 1 4 1 5 9 2 6 5");
        System.out.println( T ); 
        
    }    
    
}

