/*
 * Minipedia.java
 *
 * A client program that uses the DatabaseIterator
 * and Article classes, along with additional data
 * structures, to allow a user to create, modify
 * and interact with a encyclopedia database.
 *
 * Author: Alexander Breen (abreen@bu.edu) and Wayne Snyder (waysnyder@gmail.com)
 * Date: March 24, 2014
 */

import java.util.*;


public class Minipedia {
  
  private static Article[] getArticleList(DatabaseIterator db) {
    
    // count how many articles are in the directory
    int count = db.getNumArticles(); 
    
    // now create array
    Article[] list = new Article[count];
    for(int i = 0; i < count; ++i)
      list[i] = db.next();
    
    return list; 
  }
  
  private static DatabaseIterator setupDatabase(String path) {
    return new DatabaseIterator(path);
  }
  
  private static void addArticle(Scanner s, DumbList D) {
    System.out.println();
    System.out.println("Add an article");
    System.out.println("==============");
    
    System.out.print("Enter article title: ");
    String title = s.nextLine();
    
    System.out.println("You may now enter the body of the article.");
    System.out.println("Press return two times when you are done.");
    
    String body = "";
    String line = "";
    do {
      line = s.nextLine();
      body += line + "\n";
    } while (!line.equals(""));
    
    D.add(new Article(title, body));
  }
  
  
  private static void removeArticle(Scanner s, DumbList D) {
    System.out.println();
    System.out.println("Remove an article");
    System.out.println("=================");
    
    System.out.print("Enter article title: ");
    String title = s.nextLine();
    
    
    D.remove(title);
  }
  
  
  private static void titleSearch(Scanner s, DumbList D) {
    System.out.println();
    System.out.println("Search by article title");
    System.out.println("=======================");
    
    System.out.print("Enter article title: ");
    String title = s.nextLine();
    
    Article a = D.lookup(title);
    if(a != null)
      System.out.println(a);
    else {
      System.out.println("Article not found!"); 
      return; 
    }
    
    System.out.println("Press return when finished reading.");
    s.nextLine();
  }
  
  public static void main(String[] args) {
    Scanner user = new Scanner(System.in);
    
    String dbPath = "articles/";
    
    DatabaseIterator db = setupDatabase(dbPath);
    
    System.out.println("Read " + db.getNumArticles() + 
                       " articles from disk.");
    
    DumbList L = new DumbList(); 
    Article[] A = getArticleList(db);
    L.initialize(A);
    
    int choice = -1;
    do {
      System.out.println();
      System.out.println("Welcome to Minipedia!");
      System.out.println("=====================");
      System.out.println("Make a selection from the " +
                         "following options:");
      System.out.println();
      System.out.println("Manipulating the database");
      System.out.println("-------------------------");
      System.out.println("    1. add a new article");
      System.out.println("    2. remove an article");
      System.out.println();
      System.out.println("Searching the database");
      System.out.println("----------------------");
      System.out.println("    3. search by exact article title");
      System.out.println();
      
      System.out.print("Enter a selection (1-3, or 0 to quit): ");
      
      choice = user.nextInt();
      user.nextLine();
      
      switch (choice) {
        case 0:
          return;
          
        case 1:
          addArticle(user, L);
          break;
          
        case 2:
          removeArticle(user, L);
          break;
          
        case 3:
          titleSearch(user, L);
          break;
          
        default:
          break;
      }
      
      choice = -1;
      
    } while (choice < 0 || choice > 4);
    
  }
  
  
}
