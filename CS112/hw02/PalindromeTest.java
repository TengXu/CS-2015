/* File: StringTest.java
 * Author: Teng Xu
 * Date: January 27th, 2016
 * Purpose: This is a template for HW02, Problem B.1 (Lab problem)
 */


import java.util.Scanner;

public class PalindromeTest { 
  
  public static void main(String[] args) {
    
    System.out.println("\nWelcome to the String Test Program!");
    System.out.println("Demonstrate various features of the String Library");
    
    Scanner userInput = new Scanner(System.in);

    char[] charsToRemove = { '.' ,',', ':', ';', '!', '?', '"','\'' , '/', '-', '(', ')', '~'};
    System.out.println("\nType in a sentence or Control-d to end:"); 
    while(userInput.hasNextLine()) {    
       String line = userInput.nextLine();
       line = line.toLowerCase();   
       for(int x = 0; x < line.length(); x++){
         if(Character.isWhitespace(line.charAt(x)))
           line = line.replace(Character.toString(line.charAt(x)), "");
       }
       for(int x = 0; x < charsToRemove.length; x++){
         String y = Character.toString(charsToRemove[x]);
         line = line.replace(y, "");
       }      
       String copyline = line;
       for(int x = 0; x < (line.length()); x++){
         String numone = Character.toString(line.charAt(x)); 
         String numtwo = Character.toString(copyline.charAt(line.length() - 1 - x));   
         if( numone.equals(numtwo)){
           if(x == line.length() - 1 )
              System.out.println("Palindrome!");
         }
         else{
           System.out.println("Not a palindrome!");
           break;
         }
       }
    }
    System.out.println("bye!");
 
    
  }
  
}