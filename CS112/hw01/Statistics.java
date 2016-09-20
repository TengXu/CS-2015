/*
 * File: Statistics.java
 * Author: Teng Xu
 * Date: January 23rd, 2015
 * Purpose: This is a template for HW01, Problem B.2
 */

// The following is a library which provides functionality for
// reading input from the user in the Interactions Pane. Some
// libraries (such as Math) are already inported, but most (such
// as Scanner) you need to explicitly import. The import statement
// must occur before your class definition. 

import java.util.Scanner;


public class Statistics { 
  
  public static void main(String[] args) {
    
    System.out.println("\nWelcome to the Statistics!\nThis program will print out the sum, max, mean, variance, and\natandard deviation for three integers input by the user.");

    Scanner userInput = new Scanner(System.in);

    System.out.println("\nType in the first number and then hit return:"); 
    int numOne = userInput.nextInt(); 
    System.out.println("\nType in the first number and then hit return:"); 
    int numTwo = userInput.nextInt(); 
    System.out.println("\nType in the first number and then hit return:"); 
    int numThree = userInput.nextInt(); 
    System.out.println("\nYour have input the numbers " + numOne +", "+ numTwo +", and "+ numThree + ".");
    
    int sumnum = numOne + numTwo + numThree;
    System.out.println("\nThe sum is " + sumnum);
    
    int maxn = Math.max(numOne, numTwo);
    int maxnum = Math.max(maxn, numThree);
    System.out.println("The max is " + maxnum);
    
    int minn = Math.min(numOne, numTwo);
    int minnum = Math.min(minn, numThree);
    System.out.println("The min is " + minnum);
    
    int range = maxnum - minnum;
    System.out.println("The range is " + range);
    
    double mean = sumnum / (double)3;
    System.out.printf("The mean is %.2f\n", mean);
    
    double variance = ((numOne-mean)*(numOne-mean)  + (numTwo-mean) * (numTwo-mean) + (numThree-mean) * (numThree-mean))/3;
    System.out.printf("The variance is %.2f\n", variance);    
    
    double stand = Math.sqrt(variance); 
    System.out.printf("The standard derivation is %.2f\n", stand);    

    int median = sumnum - maxnum - minnum;
    System.out.println("The median is " + median);
  }
  
}