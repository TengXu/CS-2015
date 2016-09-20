/* File: BigInt.java
 * Date: 2/11/16
 * Author:  Teng Xu
 * Class: CS 112, Spring 2016
 * Homework: HW 04, Problem B.2
 * Purpose: This is a template for the BigInt class, representing big integers.  
 */

import java.util.Arrays;

public class BigInt {  
    
    private int[] A = new int[BigMath.SIZE]; 
    public static boolean debug = false;  
     
     public static void db(String s){            
          if(debug) 
             System.err.println("\t" + s);     
      }
    
    public BigInt() {        // Default constructor   
    }
    
    public BigInt(String s) {    // These will not work until you implement putValue(..)
        putValue(s);
    }
    
    public BigInt(int[] B) {
        putValue(B);
    }
    
    public BigInt(int n) {
        putValue(n);
    }
    
    public int length() {
      int a = 0;
      //db(Arrays.toString(A));
      for(int i = 0; i < BigMath.SIZE; i++){
        if(A[i] == 0)
            a = 0;
        else{
          //db("i: "+i);
          a = (BigMath.SIZE - i);
          break;
        } 
      }
      if(a == 0)
        a += 1;
      return a;
    }
    
    public void putValue(String s) {
      for(int i = 0; i < s.length(); i++)
        A[BigMath.SIZE - s.length() + i] = (s.charAt(i) - 48);
      //db(Arrays.toString(A));
    }
    
    public void putValue(int[] B) {
      for(int i = 0;i < B.length; i++){
        A[BigMath.SIZE - B.length + i] = B[i];
        db("i: "+i);
      }
      db(Arrays.toString(A));
    }
    
    public void putValue(int n) {
        String a = "";
        a += n;
      for(int i = 0; i < a.length(); i++)
        A[BigMath.SIZE - a.length() + i] = (a.charAt(i) - 48);        
    }
    
    public int digitAt(int i) {
      int b = 0;
      for(int a = 0; a < BigMath.SIZE; a++){
        if(A[a] == 0)
          continue;
        else{
          b = A[a + i];
          break;
        }
      }
        return b;
    }
    
    public void putDigitAt(int i,int n) {
      for(int a = 0; a < BigMath.SIZE; a++){
        if(A[a] == 0)
          continue;
        else{
          A[a + i] = n;
          break;
        }
      }
    }
    
    public String toString() {
        String a = "";
        db(Arrays.toString(A));
        for(int i = 0; i < BigMath.SIZE; i++){
          if(A[i] == 0){
            a += "";
            if(i == BigMath.SIZE - 1)
              a = "0";
          }
          else{
            a += A[i];
            for(int y = i + 1; y < BigMath.SIZE; y++){
              a += A[y];
            }
            break;
          }
        }
        return a;       
    }
    
    public static void main(String [] args) {
        
        System.out.println("\nUnit Test for BigInt Class");
        
        int[] a = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8};
        String b = "314159265358979323846264338327950288";
        int c = 314159265;
        
        BigInt A = new BigInt();
        A.putValue(a);
        
        System.out.println("\nTest 1: Should be:\n27");
        System.out.println( A.length() );
        
        System.out.println("\nTest 2: Should be:\n314159265358979323846264338");
        System.out.println( A );
        
        
        
        BigInt B = new BigInt();
        B.putValue(b);
        
        System.out.println("\nTest 3: Should be:\n36");
        System.out.println( B.length() );
        
        System.out.println("\nTest 4: Should be:\n314159265358979323846264338327950288");
        System.out.println( B );
        
        BigInt C = new BigInt();
        C.putValue(c);  
        
        System.out.println("\nTest 5: Should be:\n9");
        System.out.println( C.length() );
        
        System.out.println("\nTest 6: Should be:\n314159265");
        System.out.println( C );
        
        BigInt Z = new BigInt();       // will be zero
        
        // Special case: 0 will have length 1 and print out as a single digit
        
        System.out.println("\nTest 7: Should be:\n1");
        System.out.println( Z.length() );
        
        System.out.println("\nTest 8: Should be:\n0");
        System.out.println( Z );
        
        BigInt One = new BigInt();
        One.putValue(1);
        
        System.out.println("\nTest 9: Should be:\n1 1");
        System.out.println( One.length() + " " + One);
        
        // Even if string or array has leading zeros, you just put them in, and they get
        // treated like any other leading zeros when you check length and print out. 
        
        System.out.println("\nTest 10: Should be:\n1");
        BigInt D = new BigInt();
        D.putValue("000000004");
        System.out.println( D.length() ); 
        
        System.out.println("\nTest 11: Should be:\n4");
        System.out.println( D ); 
        
        System.out.println("\nTest 12: Should be:\n3 234");
        BigInt E = new BigInt();
        int[] e = {0,0,0,0,2,3,4};
        E.putValue(e);
        System.out.println( E.length() + " " + E ); 
        
        System.out.println("\nTest 13: Should be:\n3 4 5");
        System.out.println( C.digitAt(0) + " " + C.digitAt(2) + " " + C.digitAt( C.length() - 1 ) );
        
        System.out.println("\nTest 14: Should be:\n1000001");
        BigInt F = new BigInt("1000001");
        System.out.println( F ); 
        
        System.out.println("\nTest 15: Should be:\n12345");
        int[] g = {1,2,3,4,5};
        BigInt G = new BigInt(g);
        System.out.println( G ); 
        
        System.out.println("\nTest 16: Should be:\n54321");
        System.out.println( new BigInt(54321) ); 
        
        System.out.println("\nTest 17: Should be:\n984159265");
        C.putDigitAt(0,9);
        C.putDigitAt(1,8);
        System.out.println( C );
        
        System.out.println("\nTest 18: Should be:\n984100005");
        C.putDigitAt(4,0);
        C.putDigitAt(5,0);
        C.putDigitAt(6,0);
        C.putDigitAt(7,0);
        System.out.println( C );
        
        System.out.println("\nTest 19: Should be:\n100005");
        C.putDigitAt(0,0);
        C.putDigitAt(0,0);
        C.putDigitAt(0,0);
        System.out.println( C );
        
        System.out.println("\nTest 20: Should be:\n5");
        C.putDigitAt(0,0);
        System.out.println( C );     
    }      
}

