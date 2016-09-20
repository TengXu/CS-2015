/* File: HW07Problem02.java
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Date: 3/18/16
 * Purpose: This is a template for Problem 2 in HW 07 in CS 112, Spring 2016.  
 */

public class HW07Problem02Grading {
    
    public static void printList(Node p) {
        if(p == null) 
            System.out.println(".");
        else {
            System.err.print( p.item + " -> " );
            printList(p.next); 
        } 
    }
    
    public static void printList(String head, Node p) {
        System.err.print(head + " -> ");
        printList(p);
    }
    
    public static void main(String [] args) {
        // Since the definition of the Node is in the other file, must
        // access it the same as a normal member, with the dot notation.
        
        Node A = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );
        
        // Sample grading unit test for reverse
        
        System.out.println("\n[0] reverse(A):  should print out:\nA -> 12 -> 9 -> 6 -> 3 -> .");
        A = HW07Problem02.reverse(A);
        printList("A", A); 
       
        // No need to add any tests here, we will develop our own tests of your code. 
        
        
    }
    
    
}