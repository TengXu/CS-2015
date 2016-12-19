/*
 * DumbList.java
 * 
 * This is an unordered list of articles. Dumb, dumb, dumb. You will rewrite this as a hash table. 
 *
 * Author: Teng Xu
 * Date: April 16, 2014
 */

public class ArticleTable {
   
   public static class Node {
      public Article data;
      public Node next;
      public Node next2;
      
      public Node(Article data, Node n) {
         this.data = data;
         this.next = n;
      }
      public Node(Article data, Node n, Node m) {
         this.data = data;
         this.next = n;
         this.next2= m;
      }      
      public Node(Article data) {
         this(data, null);
      }
   }
   
   private int h(String x, int M) {   // from Hashing Tutorial
   char ch[];
   ch = x.toCharArray();
   int xlength = x.length();
   int i, sum;
   for (sum=0, i=0; i < x.length(); i++)
     sum += ch[i];
   return sum % M;
   }
   
   private int SIZE = 2503;
   public Node[] hashtable = new Node[SIZE];
   public Node head = null; 
   public Node root = null;
   private Node pointer = head;
   
   public void initialize(Article[] A) {
      for(int i = 0; i < A.length; ++i) 
         insert(A[i]); 
   }
   
   public void add(Article a) {
      root = new Node(a, root); 
   } 
   
   
   public boolean member(Article a) {
      return (lookup(root,a.getTitle()) != null); 
   }
   
   public boolean member(String title) {
      return (lookup(root,title) != null); 
   }
   
   public Article lookup(String title) {
      int num = h(title, SIZE);
      Node n = lookup(hashtable[num],title); 
      if(n != null)
         return n.data; 
      return null; 
   }
   
   private Node lookup(Node t, String key) {
      if (t == null)
         return null;
      else if (key.compareTo(t.data.getTitle()) == 0) {
         return t;
      } else 
         return lookup(t.next,key); 
   }
   
   public  Node lookup(Node t, Article a) {
      if (t == null)
         return null;
      else if (a.getTitle().compareTo(t.data.getTitle()) == 0) {
         return t;
      } else 
         return lookup(t.next, a);
   }
   
   public void remove(String t) {
      root = delete(t, root); 
   }
  
   public int length() {

         return length(root); 
   }
   
   private int length(Node t) {
      if(t == null)
         return 0;
      else
         return 1 + length(t.next); 
   }
   
   
   public Node delete(String title, Node t) {
      if (t == null)                          
         return t;
      else if (title.compareTo(t.data.getTitle()) == 0)  
         return t.next; 
      else {
         t.next = delete(title, t.next); 
         return t;
      }
   }
   
      public void insert(Article a) {             
         int num = h(a.getTitle(), SIZE);
         Node p = new Node(a, hashtable[num], head);
         hashtable[num] = p;
         p.next2 = head; 
         head = p;
      }  
      
      public void delete(String title) {
         int num = h(title, SIZE);
         hashtable[num] = deletehelper(hashtable[num], title);
         head = deleteML(head, title);
      }
      private Node deletehelper(Node n, String t){
        if(n != null){
          if(t.compareTo(n.data.getTitle()) == 0){
            return n.next;
          }
          else{
            n.next = deletehelper(n.next, t);
            return n;
          }
        }
        else
          return null;
      }
      private Node deleteML(Node n, String t){
        if(n != null){
          if(t.compareTo(n.data.getTitle()) == 0){
            return n.next2;
          }
          else{
            n.next2 = deleteML(n.next2, t);
            return n;
          }
        }
        else
          return null;        
      }
      
      public void reset(){   
        pointer = head;
      }
      
      public boolean hasNext() {
         return(pointer != null); 
      }
      
      public Article next() {
        Article b = pointer.data;
        pointer = pointer.next2;
        return b;
      }
  public static void main(String[] args) {  
    Article a = new Article("title","body");
    ArticleTable A = new ArticleTable();
    A.insert(a);
    System.out.print(A.lookup("title"));   
    A.reset();
    while(A.hasNext()) {
    Article f = A.next(); 
    System.out.println("should print out:");
    System.out.println("body");   
    System.out.println(f.body);
    }
  }
   
   
}
