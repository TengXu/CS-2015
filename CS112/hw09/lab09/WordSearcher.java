import java.util.*;
import java.io.*;

/**
 * A program that loads the English dictionary into memory and allows the user
 * to search the dictionary.
 * Answer:
 * 1. 16 bytes
 * 2. 9 bytes
 * 3. theta(n), same as the worst case in linked list
 * 4. search for the first chararcter in the pattern string, and then check if the rest matches 
 * 
 */
public class WordSearcher {
  public static String processWord(String k){
    if(k.length() > 0){
    if(Character.isLowerCase(k.charAt(0))==false){
      char a = Character.toLowerCase(k.charAt(0));
      if(Character.isLowerCase(a) == true)
        return a + processWord(k.substring(1));
      else
        return processWord(k.substring(1));
    }
    else{
      return k.charAt(0)+ processWord(k.substring(1));
    }
  }
    else{
      return "";
    }
  }
    public static void main(String[] args) {

      File wordsFile = new File("words.txt");
      TrieNode root = new TrieNode();       
      try { 
        BufferedReader reader = new BufferedReader(new FileReader(wordsFile)); 
        String word = "";      
        while((word = reader.readLine()) != null){
          word = processWord(word);            
          try{
            root.add(word);
          }catch(IllegalArgumentException x){
          }
        }
      } catch (IOException x) {
        System.err.println("x");
      }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            root.match(line);
            System.out.print("Enter a string: ");
        }
    }
}
