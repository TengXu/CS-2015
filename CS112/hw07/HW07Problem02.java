/* File: HW07Problem02.java
 * Author: Teng Xu
 * Date: 3/19/16
 * Purpose: This is a template for Problem 2 in HW 07 in CS 112, Spring 2016.  
 */

public class HW07Problem02 {
    
    public static void printList(Node p) {
        if(p == null) 
            System.out.println(".");
        else {
            System.out.print( p.item + " -> " );
            printList(p.next); 
        } 
    }
    
    public static void printList(String head, Node p) {
        System.out.print(head + " -> ");
        printList(p);
    }
    
    
    public static Node reverse(Node p) {
        return reverseHelper(p, null);
    }
    
    public static Node reverseHelper(Node p, Node q) {
        if(p == null)
            return q;
        else {
            Node temp = p.next;
            p.next = q;
            return reverseHelper(temp, p); 
        }
        
    }
    
    // Now add your solutions for each of the methods in Problem 2. BE SURE TO MAKE
    // THEM PUBLIC AND STATIC AND NAME THEM EXACTLY AS IN THE ASSIGNMENT!
    public static int len( Node p ) {                   
       if (p == null) 
          return 0;
       else
          return 1 + len( p.next ); 
     }
    public static Node arrayToLinkedList(int[] A){
      if(A.length < 1)
        return null;
      else{
      Node a = new Node(A[0],null);
      if(A.length>1){
      Node b = new Node(A[1],null);
      a.next = b;
      for(int i = 2; i<A.length; i++){
        b.next = new Node(A[i], null);
        b = b.next; 
      }
      }
      return a;
      }
    }
    
    public static Node deleteNth(Node p,int n){
      Node a = p;
      if(n == 1){
        p = p.next;
      }
      else{
      for(int i = 2;i < n; i++){
        a = a.next;
      }
      a.next = a.next.next;
      }
      return p;
    }

    
    public static boolean equalLists(Node p, Node q){
      if(len(p) != len(q))
        return false;
      else{
        Node a = p;
        Node b = q;
        for(int i = 0; i< len(p);i++){
          if(a.item != b.item)
            return false;
          a = a.next;
          b = b.next;
        }
      }
      return true;
    }
    
    public static boolean equalListsRec(Node p, Node q){
      if(len(p) != len(q))
        return false;
      else if(p == null)
        return true;
      else if(p.item == q.item){
        return equalListsRec(p.next,q.next);
      }
      else
        return false;
    }
    
    public static Node everyOther(Node p){
      if(p == null)
        return p;
      else if(len(p) == 2){
        p.next = null;
        return p;
      }
      else{
        Node a = p;
        int size = len(p);
        for(int i = 0;i <(size/2);i++){
          a.next = a.next.next;
          a = a.next;
        }
        return p;
      }       
    }
    
    public static Node everyOtherRec(Node p){
      if(p == null)
        return p;
      else if(len(p) <= 2){
        p.next = null;
        return p;
      }
      else{
        p.next = everyOtherRec(p.next.next);
        return p;
      }
    }
    
    public static Node append( Node p, Node q ) {
        if ( p == null) 
           return q; 
        else {
          p.next = append( p.next, q );
          return p;
        }
     }
         
    public static Node splice(int n, Node p, Node q){
      if(p == null)
        return q;
      else if(n > len(p)){
        append(p, q);
        return p;
      }
      else if(n == 0){
        append(q, p);
        return q;
      }
      else{
        n--;
        p.next = splice(n, p.next, q);
        return p;
      }
    }
    
    public static boolean member( int k, Node p ) {                   
       if (p == null) 
          return false;
       else if( k == p.item )
          return true; 
       else
          return member( k, p.next ); 
     }
    
    public static Node copy( Node p ) {
       if( p == null )
          return null; 
       else 
          return new Node(p.item, copy( p.next )); 
    }  
    
    public static Node intersection(Node p, Node q){
      Node a = copy(p);
      a = inters(a, q);
      return a;
    }
    
    public static Node inters(Node p, Node q){
      if(p == null)
        return p;
      else if(member(p.item, q) == false){
        return inters(p.next, q);
      }
      else{
        p.next = inters(p.next, q);
        return p;
      }
    }
    
    public static void main(String [] args) {
        Node A = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );
        printList("A", A); 
        
        // Sample unit test for reverse
        
        System.out.println("\n[0] reverse(A):  should print out:\nA -> 12 -> 9 -> 6 -> 3 -> .");
        A = reverse(A);
        printList("A", A); 
        
        // You should write your own unit tests for each of the methods you develop.
        System.out.println("\n[1] arrayToLinkedList(B):  should print out:\np -> 2 -> 5 -> 4 -> .");
        int[] B = { 2, 5, 4 };
        Node p = arrayToLinkedList(B);        
        printList("p", p); 

        System.out.println("\n[2] deleteNth(p,1):  should print out:\np -> 5 -> 4 -> .");
        p = deleteNth(p,1);
        printList("p", p);               

        Node a = arrayToLinkedList(B);
        System.out.println("\n[3] equalLists(a, p):  should print out:\nfalse");
        System.out.println(equalLists(a, p));
        
        System.out.println("\n[4] everyOther(p):  should print out:\np -> 2 -> 4 -> ."); 
        int[] C = { 2, 5, 4, 6};
        p = arrayToLinkedList(C);        
        everyOther(p);
        printList("p", p);
        
        System.out.println("\n[5] equalListsRec(a, p):  should print out:\nfalse");
        System.out.println(equalListsRec(a, p));        
        
        System.out.println("\n[6] everyOtherRec(p):  should print out:\np -> 2 -> 4 -> .");
        p = arrayToLinkedList(C);
        everyOtherRec(p);
        printList("p", p);
        
        System.out.println("\n[7] splice(2, p, a):  should print out:\np -> 2 -> 2 -> 5 -> 4 -> 4 -> . ");     
        p = splice(1, p, a);
        printList("p", p);  

        int[] D = { 2, 3, 4, 6 };
        int[] F = { 1, 4, 6 };   
        Node d = arrayToLinkedList(D);
        Node f = arrayToLinkedList(F);
        System.out.println("\n[8] intersection(d, f):  should print out:\nc -> 4 -> 6 -> . ");
        Node c = intersection(d, f);
        printList("c", c);
    }
    
    
}


class Node {
    int item;
    Node next;
    public Node(int it, Node n) {
        item = it; next = n;
    }
}