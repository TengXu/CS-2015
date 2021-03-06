/* File: MyStringArray.java
 * Author: Teng Xu
 * Date: January 30th, 2016
 * Purpose: This is a template for the solution to HW02, Problem B.4; the program
 *      compiles and runs, but fails the correctness tests in the "Unit Test Main" method. You should
 *      develop one method at a time, and verify that each satisfies the test before moving on. 
 * NOTE: You MUST rewrite this header comment to describe your solution.
 *       You MUST follow the Style Guidelines with respect to basic layout (ignore "Naming" for now);
 *       You MUST fill in where indicated in this template, and make any other changes
 *           you wish to satisfy the tests in main, but:
 *       Do NOT change anything in the main method or change the declarations of the error values, or
 *           the basic syntax of the method definitions (i.e., the first line of the method should be the same). 
 *       You MUST test for errors in the appropriate methods by returning the listed error values when appropriate.
 */
import java.lang.*;

public class MyStringArray { 
  
  // Declare various final (i.e., constant) values to be used to indicate errors of various types
  
  public static final char[] errorString  = { 'N', 'a', 'S' };   // These next three are our choices for error outputs
  public static final char errorCharacter = '#';
  public static final int errorInteger    = Integer.MIN_VALUE;
  public static final double errorDouble  = Double.NaN;          // Nan results when dividing by 0, etc.
    
    // This method charAt(char[] s, int i) returns the char in the array at location i; if i is not in the 
    // legal range of s [0 .. (s.length - 1)], it returns the error value errorCharacter
    public static char charAt(char[] s, int i) {
    if(i < 0 || i > s.length)
      return errorCharacter;    
    else
      return s[i];
    }
  
  // This method length(char[] s) returns the length of the array s
  public static int length(char[] s) {
    return s.length;
  }
  
  // This method subString(char[] s, int l, int r) returns the subsequence of chars from location left to (right-1) as a new array of chars;
  // if left or right-1 is outside the legal range of locations,it will return the error value errorString;
  public static char[] subString(char[] s, int l, int r) {
    char[] news = new char[( r - l)];
    if(l < 0 || r > s.length)
      return errorString; 
    else{
      for(int i = l;i < r; i++){
        news[i-l] = s[i];
      }     
    }
    return news;
  }
  
  // This method returns a new array of chars in which any upper-case letters ('A' - 'Z') are replaced by their lower-case and any other char does not change.
  public static char[] toLowerCase(char[] c) {
    char[] newc = new char[c.length];
    for(int x =0;x < c.length; x++){
      int asc = (int)c[x];
      if (65 <= asc && asc <= 90) 
        asc += 32;
      newc [x] = (char)asc;
    }
    return newc;
  }
    
  
  // This method returns a new array of the chars in a followed by the chars in b;
  public static char[] concatenate(char[] a, char[] b) {
    char [] newarray = new char[a.length + b.length];
    for(int x = 0;x < (a.length + b.length); x++){
      if(x < a.length)
        newarray[x] = a[x];
       else 
        newarray[x] = b[x - a.length];
    }
    return newarray;
  }
  
  // This method returns the integer value corresponding to the array of chars; if any non-digit occurs in the array, the error value  errorInteger  is returned; 
  // If the array may start with a negative sign '-', a negative number is returned; 
  // the array may have "leading zeros". If the array starts with "+" you may return an error, or the positive value;
  // but this possibility will not be tested in the test cases.  
  public static int intValueOf(char[] a){ 
    int num = 0;
    if(a[0] == '-'){
      for(int x = 1; x < a.length; x++){
        if(Character.isDigit(a[x]))
          num += ((int)a[x] - 48) * Math.pow( 10, (a.length-1-x));         
      }
      num = num * (-1);
    }
    else if(a[0] == '+'){
      for(int x = 1; x < a.length; x++){
        if(Character.isDigit(a[x]))
          num += ((int)a[x] - 48) * Math.pow( 10, (a.length-1-x));          
      }
    }
    else{
    for(int y = 0; y < a.length; y++){
      if (Character.isDigit(a[y]) == false){
        return errorInteger;
      }
      else{
          if(Character.isDigit(a[y]))
            num += ((int)a[y] - 48) * Math.pow( 10, (a.length-1-y)); 
      }
     }
    }
    return num;
  }
 
  
  // This method is similar to the previous method, but the array is assumed to represent a double, with at most one decimal point '.',  and a possible 
  // negative sign in the first location.
  public static double doubleValueOf(char[] a) {
    double num = 0;
    int point = -1;
    if(a[0] == '-'){
      for(int x = 1; x < a.length; x++){
       if(a[x] == '.'){
          point = x;
          for(x = point + 1; x < a.length; x++){
            num += (((int)a[x] - 48) / Math.pow( 10, (x - point)));
            if(Character.isDigit(a[x]) == false){
              num = errorDouble;
              break;
            }
          }
         for(int b = 1; b < point; b++){
           if(Character.isDigit(a[b]))
             num += ((int)a[b] - 48) * Math.pow( 10, (point - b -1));
      }
       }
      else if(Character.isDigit(a[x]) == false){
          num = errorDouble;
          break;
      }
      }
      num = num * (-1);
    }
    else{
    for(int c = 0; c < a.length; c++){
      if(a[c] == '.'){
          point = c;
          for(c = point + 1; c < a.length; c++){
            num += (((int)a[c] - 48) / Math.pow( 10, (c - point))); 
            if(Character.isDigit(a[c]) == false){
              num = errorDouble;
              break;
            }
          }
         for(int b = 0; b < point; b++){
           if(Character.isDigit(a[b]))
             num += ((int)a[b] - 48) * Math.pow( 10, (point - b - 1));
      }
       }
      else if(Character.isDigit(a[c]) == false){
          num = errorDouble;
          break;
        }
      }
      }  
    return num;
    }

  
  // This method Convert an int into a character array representing it; n may be negative, in which case the first character in the array should be '-'. 
  public static char[] int2MyString(int n) {
    int length = String.valueOf(n).length();
    char[] array = new char[length];
    if (n < 0){
      for(int x = 1; x < length; x++){

      char a = (char)(n % Math.pow( 10,x) + 48);
      n = (int)(n / Math.pow( 10,x));
      array[array.length -1- x] = a;
      n -= (n % Math.pow( 10,x+1));
    }
     array[0] = '-';
    }
    else{      
       for(int x = 0; x < length; x++){
        char a = (char)(n % Math.pow( 10,x+1) + 48);
        n -= (n % Math.pow( 10,x+1));
        array[array.length -1- x] = a;       
      }             
  }
     return array;
  }
  
  // This method provided for debugging
  public static void printCharArray(char[] A) {
    for(int i = 0; i < A.length; ++i) {
      System.out.print(A[i]);
    }
    System.out.println(); 
  }
  
  
   public static void main(String[] args) {
      
      System.out.println("\nGrading program for MyStringArray library\n");
      int testNum = 0; 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n8"); 
      char[] test = "CS112 A1".toCharArray(); 
      System.out.println(length(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\nC"); 
      System.out.println(charAt(test,0)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n1"); 
      System.out.println(charAt(test,7)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\n#"); 
      System.out.println(charAt(test,9)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112"); 
      System.out.println(subString(test,0,5)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n12 A1"); 
      System.out.println(subString(test,3,8)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
      System.out.println(subString(test,-1,4)); 
      System.out.println(); 
                  
      System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
      System.out.println(subString(test,1,9)); 
      System.out.println();  
                        
      System.out.println("Test " + (++testNum) + ": Should be:\ncs112 a1"); 
      System.out.println(toLowerCase(test)); 
      System.out.println();
                              
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1"); 
      System.out.println(test); 
      System.out.println();
                        
      System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1CS112 A1"); 
      System.out.println(concatenate(test,test)); 
      System.out.println();
     
      System.out.println("Test " + (++testNum) + ": Should be:\n234"); 
      test = "234".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-234"); 
      test = "-234".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
      test = "234.4".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
      test = "23a4".toCharArray(); 
      System.out.println(intValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\n3.141592"); 
      test = "3.141592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();   
      
      System.out.println("Test " + (++testNum) + ": Should be:\n-3.141592"); 
      test = "-3.141592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
            
      System.out.println("Test " + (++testNum) + ": Should be:\n10.0"); 
      test = "10.".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\n0.5"); 
      test = ".5".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
            
      System.out.println("Test " + (++testNum) + ": Should be:\n0.0"); 
      test = ".".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\n234.0"); 
      test = "234".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println();
      
      System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
      test = "3.141.592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
      test = "3.141a592".toCharArray(); 
      System.out.println(doubleValueOf(test)); 
      System.out.println(); 
      
      int n = 12345; 
      System.out.println("Test " + (++testNum) + ": Should be:\n12345"); 
      printCharArray( int2MyString(n) ); 
      System.out.println(); 
      
      n = -45; 
      System.out.println("Test " + (++testNum) + ": Should be:\n-45"); 
      printCharArray( int2MyString(n) ); 
      System.out.println(); 
      

   }
  
}
