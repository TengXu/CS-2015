import java.util.Scanner;

public class WordPalindromeTest { 
  
  public static void main(String[] args) {
       Scanner userInput = new Scanner(System.in);

    char[] charsToRemove = { '.' ,',', ':', ';', '!', '?', '"','\'' , '/', '-', '(', ')', '~'};
    System.out.println("\nType in a sentence or Control-d to end:"); 
    while(userInput.hasNextLine()) {
      
       String line = userInput.nextLine();
       line = line.toLowerCase();
       
       for(int x = 0; x < charsToRemove.length; x++){
         String y = Character.toString(charsToRemove[x]);
         line = line.replace(y, "");
       }
       String[] words = line.split("\\s+");
       
       System.out.print("\n[ ");
       for( int i = 0; i < words.length - 1; i++ )
         System.out.print(words[i] + ", ");
        System.out.println(words[words.length - 1]+" ]");

       for(int x = 0; x < (words.length/2); x++){
         String numone = words[x]; 
         String numtwo = words[words.length - 1 - x];   
         if( numone.equals(numtwo)){
           if(x == words.length/2 - 1)
              System.out.println("\nWord Palindrome!");
         }
         else{
           System.out.println("\nNot a Word Palindrome!");
           break;
           
         }
       }
    }
  }
}
