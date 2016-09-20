/* File: Set.java
 * Date: 2/7/16
 * Author:  Teng Xu (xt@bu.edu)
 * Class: CS 112, Spring 2016
 * Purpose: This is the template for HW 03, Problem B.2, for Sets
 */

import java.util.Arrays;

public class Set  {
    
    public static final int noElement = Integer.MAX_VALUE;
    public static final int SIZE = 20;
    
    // Return a set with no members, i.e., consisting of all Integer.MAX_VALUE values.
    
     public static boolean debug = true;  

     public static void db(String s) {            
          if(debug) 
             System.err.println("\t" + s);      
      }    
    
    public static int[] getEmptySet() {
        int[] S = new int[SIZE];
        for(int i = 0; i < SIZE; ++i)
            S[i] = noElement;
        return S;
    }
    
    
    // Take an arbitrary array of integers, and return a set. The input array S
    // may have duplicate values, so you will have to remove the duplicates (hints below);
    // and you should return the error set if the array S is longer than SIZE.
    // You will, of course, have to sort the values, so use Insertion Sort (from my slides). 
    
    public static int[] intArray2Set(int[] S) {
        S = removeDuplicates(S);
        sort(S);
        if(S.length > SIZE)
          return getEmptySet();
        return S;
    }
    
    // Take a set and return a String representation; you may simply print out
    // the list (in order) but of course do not print out the Integer.MAX_VALUE
    // values, and you should use curly braces and commas. 
    
    public static String setToString(int[] S)  {
      String A = "{" ;
      if(S[0] != noElement)
        A += S[0];
      for(int i = 1; i < S.length; i++){
         if(S[i] != noElement)
           A += "," + S[i];
      }
      A +=  "}";
      return A;
    } 
    
    // Return the number of elements in the set
    
    public static int size(int[] S) {
      int i = 0;
      for(i = 0; i < S.length; i++){      
        if(S[i] == noElement)
          break;
      }
      return i;
    }
    
    // Return true if S is the empty set (has no members)
    public static boolean isEmpty(int[] S) {
        return ( S[0] == noElement );
    }
    
    // Return true if n is in the set and false otherwise
    
    public static boolean member(int n, int[] S) {
      for(int i = 0; i < S.length; i++){
        if(S[i] == n)
          return true;
      }
        return false;
    }    
    
    // Returns true if S is a subset of T, that is, every member of S is a member of T.
    
    public static boolean subset(int[] S, int[] T) {
      if(isEmpty(S))
        return true;
      else{
      for(int i = 0; i < S.length; i++){
        if(member(S[i], T) == false)
          return false;
      }
        }
        return true; 
    }
    
    public static boolean equal(int[] S, int[] T) {
        if(subset(S, T) && subset(T, S))
          return true;
        else
          return false;
    }
    
    
    public static int[] add(int k, int[] S) {
      int[] A = copy(S);
      if(member(k, S)){
          sort(A);        
          return A;
      }
      else{         
          A[S.length - 1] = k;
          sort(A);          
          return A;
        }
    }
    
    public static int[] remove(int k, int[] S) {
      int[] A = copy(S);
      if(member(k, S)){
        for(int i = 0; i < S.length; i++){ 
          if(S[i] == k)
            A[i] = noElement;
        }
        sort(A);
        return A;
      }
      else
          return A;
    }
    
    // Returns the union of S and T.
    
    public static int[] union(int[] S, int[] T) {
        int[] A = copy(S);
        for(int i = 0; i < T.length; i++){
            A = add(T[i], A);
        }
        return A;
    } 
    
    // Returns the intersection of S and T 
    
    public static int[] intersection(int[] S, int[] T) {
      int[] A = copy(S);
      for(int i = 0; i < S.length; i++){
        if(member(S[i], T) == false){
          A[i] = noElement;
        }      
      }
      sort(A);
      return A;
    }
    
    // Returns the set difference S / T, which is all the members of S
    // which are not members of T        
    
    public static int[] setdifference(int[] S, int[] T) {
      int[] A = copy(S);
      for(int i = 0; i < S.length; i++){
        if(member(S[i], T)){
          A[i] = noElement;
        }      
      }
      sort(A);
      return A;     
    }
    
    // Sorting methods, using Insertion Sort
    
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public static void sort(int[] A) {  
        for (int i = 1; i < A.length; i++) { 
            for (int j = i; j > 0 && (A[j]  < A[j-1]); j--) { 
                swap(A, j, j-1); 
            } 
        }
    }
    
    // just make an exact copy of a set array
    
    public static int[] copy(int[] S) {
      int[] A = new int[SIZE];
      for(int a = 0; a < S.length; a++)
        A[a] = S[a];
      for(int i = S.length; i < SIZE; i++)
        A[i] = noElement;
      return A;
    }
    
    // remove duplicates from array of ints
    
    public static int[] removeDuplicates(int[] S) {
      int[] A = new int[S.length];
      for(int a = 0; a < S.length; a++)
        A[a] = S[a];
      for(int i = 0; i < S.length; i++){
        A[i] = noElement;
        db("S[i]: "+S[i]+" A: "+setToString(A));
        if(member(S[i], A)){
          S[i] = noElement;
        }
        
      }
        return S;  
    }
    
    
    public static void main(String [] args) {
        
        System.out.println("\nTests for Set\n");
        
        int[] A = {2,4,6,4,8,6,0,2,4,6,8};
        int[] B = {1,3,5,3,7,9,1};
        int[] C = {2,4,8};
        int[] D = {3,5,4,6};
        
        
        int[] SA = intArray2Set(A); 
        int[] SB = intArray2Set(B);
        int[] SC = intArray2Set(C);
        int[] SD = intArray2Set(D);
        int[] SE = getEmptySet();
        
        
        System.out.println("Test 1: Should be:\n{0,2,4,6,8}"); 
        System.out.println(setToString(SA)); 
        System.out.println(); 
        
        System.out.println("Test 2: Should be:\n{1,3,5,7,9}"); 
        System.out.println(setToString(SB));; 
        System.out.println(); 
        
        System.out.println("Test 3: Should be:\n{2,4,8}"); 
        System.out.println(setToString(SC)); 
        System.out.println(); 
        
        System.out.println("Test 4: Should be:\n{3,4,5,6}"); 
        System.out.println(setToString(SD)); 
        System.out.println(); 
        
        System.out.println("Test 5: Should be:\n{}"); 
        System.out.println(setToString(SE)); 
        System.out.println(); 
        
        System.out.println("Test 6: Should be:\n0"); 
        System.out.println(size(SE)); 
        System.out.println();          
        
        System.out.println("Test 7: Should be:\n5"); 
        System.out.println(size(SA)); 
        System.out.println(); 
        
        System.out.println("Test 8: Should be:\ntrue"); 
        System.out.println(isEmpty(SE)); 
        System.out.println();            
        
        System.out.println("Test 9: Should be:\nfalse"); 
        System.out.println(isEmpty(SB)); 
        System.out.println();          
        
        System.out.println("Test 10: Should be:\nfalse"); 
        System.out.println(member(3, SA)); 
        System.out.println(); 
        
        System.out.println("Test 11: Should be:\ntrue"); 
        System.out.println(member(3, SB)); 
        System.out.println(); 
        
        System.out.println("Test 12: Should be:\nfalse"); 
        System.out.println(member(3, SE)); 
        System.out.println();            
        
        System.out.println("Test 13: Should be:\nfalse"); 
        System.out.println(subset(SB,SA)); 
        System.out.println();          
        
        System.out.println("Test 14: Should be:\ntrue"); 
        System.out.println(subset(SC,SA)); 
        System.out.println(); 
        
        System.out.println("Test 15: Should be:\ntrue"); 
        System.out.println(subset(SE,SA)); 
        System.out.println();
        
        System.out.println("Test 16: Should be:\ntrue"); 
        System.out.println(equal(SC,SC)); 
        System.out.println(); 
        
        System.out.println("Test 17: Should be:\nfalse"); 
        System.out.println(equal(SB,SA)); 
        System.out.println();
        
        System.out.println("Test 18: Should be:\ntrue"); 
        System.out.println(equal(SE,SE)); 
        System.out.println();
        
        System.out.println("Test 19: Should be:\n{0,2,4,6,8}"); 
        System.out.println(setToString(add(4,SA))); 
        System.out.println();       
        
        System.out.println("Test 20: Should be:\n{4}"); 
        System.out.println(setToString(add(4,SE))); 
        System.out.println();
        
        System.out.println("Test 21: Should be:\n{0,2,6,8}"); 
        System.out.println(setToString(remove(4,SA))); 
        System.out.println();       
        
        System.out.println("Test 22: Should be:\n{1,3,5,7,9}"); 
        System.out.println(setToString(remove(4,SB))); 
        System.out.println();
        
        System.out.println("Test 23: Should be:\n{}"); 
        System.out.println(setToString(remove(4,SE))); 
        System.out.println();
        
        System.out.println("Test 24: Should be:\n{0,2,4,6,8}"); 
        System.out.println(setToString(union(SC,SA))); 
        System.out.println();
        
        System.out.println("Test 25: Should be:\n{0,1,2,3,4,5,6,7,8,9}"); 
        System.out.println(setToString(union(SA,SB))); 
        System.out.println();
        
        System.out.println("Test 26: Should be:\n{3,4,5,6}"); 
        System.out.println(setToString(union(SD,SE))); 
        System.out.println();
        
        System.out.println("Test 27: Should be:\n{0,2,4,6,8}"); 
        System.out.println(setToString(union(SC,SA))); 
        System.out.println();
        
        System.out.println("Test 28: Should be:\n{}"); 
        System.out.println(setToString(intersection(SA,SB))); 
        System.out.println();
        
        System.out.println("Test 29: Should be:\n{4}"); 
        System.out.println(setToString(intersection(SC,SD))); 
        System.out.println();  
        
        System.out.println("Test 30: Should be:\n{2,4,8}"); 
        System.out.println(setToString(intersection(SC,SA))); 
        System.out.println(); 
        
        System.out.println("Test 31: Should be:\n{0,6}"); 
        System.out.println(setToString(setdifference(SA,SC))); 
        System.out.println();
        
        System.out.println("Test 32: Should be:\n{2,8}"); 
        System.out.println(setToString(setdifference(SC,SD))); 
        System.out.println();  
        
        System.out.println("Test 33: Should be:\n{1,3,5,7,9}"); 
        System.out.println(setToString(setdifference(SB,SE))); 
        System.out.println(); 
        
        System.out.println("Test 34: Should be:\n{}"); 
        System.out.println(setToString(setdifference(SB,SB))); 
        System.out.println();
    }
    
    
}