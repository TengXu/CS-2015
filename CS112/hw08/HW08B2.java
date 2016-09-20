/* File: HW08B2.java
 * Author: Teng Xu
 * Date: 3/26/16
 * Purpose: This is the template for HW 08 B2
 */


public class HW08B2 { 
  
  private static class Node {
    int item;
    Node left;
    Node right;
    
    public Node(int k) {
      left = null;
      right = null;
      item = k;
      
    }
    
    public Node(int k, Node l, Node r) {
      item = k;
      left = l;
      right = r;
      
    }
  }
  
  
  private static int height(Node t) {
    if (t == null)
      return -1;
    else 
      return 1 + Math.max( height(t.left), height(t.right) ); 
  }
 
  
  private static Node insert(Node t, int item) {
    if (t == null)
      return new Node(item);
    else if (item < t.item) {
      t.left = insert(t.left, item);
      
      return t;
    } else if (item > t.item) {
      t.right = insert(t.right, item);
      
      return t;
    } else              
      return t;
  }
  
  private static Node insertArray(int[] A, Node r) {
    Node t = null;
    for(int i = 0; i < A.length; ++i)
      t = insert(t,A[i]);
    return t;  
  }
  
  private static void printIndentedTree(Node t) {
    System.out.println();
    printIndentedTreeAux(t, "");
    System.out.println();
  }
  
  private static void printIndentedTreeAux(Node t, String indent) {
    if (t != null) {
      printIndentedTreeAux(t.right, indent + "     "); // add five spaces to indent
      //     System.out.println(indent + t.item + "(" + t.N + ")");
      System.out.println(indent + t.item );
      printIndentedTreeAux(t.left, indent + "     "); // add five spaces to indent
    }
  }
  
  
  private static int size(Node t) {
    if (t == null)
     return 0;
    else
     return 1 + size(t.left) + size(t.right);
  }
   
  private static String treeToString(Node r) {
    if(r == null)
      return "";
    else{
      return "("+treeToString(r.left) +" "+ r.item +" "+ treeToString(r.right)+")";
    }
}

  private static String treeToString2(Node r) {
    if(r == null)
      return ".";
    else{
      return r.item +"("+treeToString2(r.left)+","+treeToString2(r.right)+")";
    }
  }

  private static int numLeaves(Node r) {
    if(r == null)
      return 0;
    else if(r.left == null){
      return 1+numLeaves(r.right);
    }
    else if(r.right == null){
      return 1+numLeaves(r.left);
    }    
    else{
      return numLeaves(r.left)+numLeaves(r.right);
    }
  }

  public static Node reverse(Node r) {
    if(r == null)
      return null;
    if(r.left == null){
      r.left = r.right;
      r.right = null;
      return r;
    }
    if(r.right == null){
      r.right = r.left;
      r.left = null;
      return r;
    }    
    else{
      Node le = r.left;
      Node ri = r.right;
      r.left = reverse(ri);
      r.right = reverse(le);
      return r;
    }
  }  
 
  private static Node copy(Node r) {
    if(r == null)
      return null;
    else{
    Node a = new Node(r.item);
    return copyHelper(a, r);
    }
  }
  
  private static Node copyHelper(Node a, Node r){
    if(r == null)
      return null;
    a.item = r.item;
    if(r.left != null){
      a.left = new Node(r.left.item);
      a.left = copyHelper(a.left, r.left);
    }
    if(r.right != null){
      a.right = new Node(r.right.item);      
      a.right = copyHelper(a.right, r.right);
    }
    return a;
  }
  
  public static boolean isFull(Node r) {
    if(r == null)
      return true;
    else if(r.left != null && r.right == null)
      return false;
    else if(r.left == null && r.right != null)
      return false;    
    else{
      return (isFull(r.left) && isFull(r.right));
    }
  }
  
  public static boolean isBST(Node r) {
    return(isBSTHelper(r, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
  
  private static boolean isBSTHelper(Node r, int lo, int hi){
    if(r == null)
      return true;
    else if(r.item > lo && r.item < hi)
      return isBSTHelper(r.left, lo, r.item) && isBSTHelper(r.right, r.item, hi);    
    else
      return false;  
  }
 
 
  public static boolean isDegenerate(Node r) {
    if(r == null)
      return false;
    else if(r.left != null && r.right != null)
      return false;   
    else{
      return (isDegenerate(r.left) && isDegenerate(r.right));
    }    
}
  
  public static boolean isPerfect(Node r) {
    if(r == null)
      return true;
    else if(size(r.left) != size(r.right))
      return false;
    else
      return isPerfect(r.left)&&isPerfect(r.right);
  }

 public static boolean equals(Node r, Node s) {
   if(r == null && s == null)
     return true;
   else if(r == null && s != null)
     return false;
   else if(s == null && r != null)
     return false;   
   else if(r.item != s.item)
     return false;   
   else{
     return equals(r.left, s.left)&&equals(r.right, s.right);
   }
 }

   
  
  // Unit Test for HW08B2
  
  public static void main(String[] args) {
      
     

    System.out.println("Sample trees for testing tree methods for HW08B2:"); 
    
    System.out.println("\nTree 0 is null.\n"); 
    Node root0 = null; 
    
    Node root1=null;
    
    int[] A = { 5, 2, 9, 4,1, 7, 12 };
    root1 = insertArray(A,root1);
    System.out.println("Tree 1:"); 
    printIndentedTree(root1);
    
    Node root2=null;
    
    int[] B = { 1, 2, 3, 6, 5, 4 };
    root2 = insertArray(B,root2);
    System.out.println("Tree 2:"); 
    printIndentedTree(root2);   
    
    Node root3=null;
    
    int[]C = { 1, 6, 2, 4, 3, 5 };
    root3 = insertArray(C,root3);
    System.out.println("Tree 3:"); 
    printIndentedTree(root3);     
    
    Node root4=null;
    
    int[] D = { 6, 2, 15, 9, 4, 1, 18, 3, 12, 7,5,10,13 };
    root4 = insertArray(D,root4);
    System.out.println("Tree 4:"); 
    printIndentedTree(root4);     
   
    System.out.println("\nPerformance Tests...."); 
    
    System.out.println("\nTesting size....");
    System.out.println("\n[0] Should print out:\n" + D.length); 
    System.err.println(size(root4)); 

    System.out.println("\nTesting treeToString....");
    System.out.println("\n[1] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))"); 
    System.err.println(treeToString(root1)); 
    
    System.out.println("\n[2] Should print out:\n( 1 ( 2 ( 3 ((( 4 ) 5 ) 6 ))))"); 
    System.err.println(treeToString(root2)); 
    
    System.out.println("\nTesting treeToString2....");
    System.out.println("\n[3] Should print out:\n5(2(1(.,.),4(.,.)),9(7(.,.),12(.,.)))"); 
    System.err.println(treeToString2(root1)); 
    
    System.out.println("\n[4] Should print out:\n1(.,6(2(.,4(3(.,.),5(.,.))),.))"); 
    System.err.println(treeToString2(root3)); 
    
    System.out.println("\nTesting numLeaves ....");
    System.out.println("\n[5] Should print out:\n0"); 
    System.err.println(numLeaves(root0)); 
    
    System.out.println("\n[6] Should print out:\n7"); 
    System.err.println(numLeaves(root4)); 
    
    System.out.println("\nTesting isFull ....");
    System.out.println("\n[7] Should print out:\ntrue"); 
    System.err.println(isFull(root0)); 
    
    System.out.println("\n[8] Should print out:\ntrue"); 
    System.err.println(isFull(root1)); 
    
    System.out.println("\n[9] Should print out:\nfalse"); 
    System.err.println(isFull(root3)); 
    
    System.out.println("\n[10] Should print out:\ntrue"); 
    System.err.println(isFull(root4)); 
    
    System.out.println("\nTesting isDegenerate ....");
    System.out.println("\n[11] Should print out:\nfalse"); 
    System.err.println(isDegenerate(root0)); 
    
    System.out.println("\n[12] Should print out:\ntrue"); 
    System.err.println(isDegenerate(root2)); 
    
    System.out.println("\n[13] Should print out:\nfalse"); 
    System.err.println(isDegenerate(root3));  
    
    System.out.println("\n[14] Should print out:\nfalse"); 
    System.err.println(isDegenerate(root4)); 
    
    System.out.println("\nTesting isPerfect ....");
    System.out.println("\n[15] Should print out:\nfalse"); 
    System.err.println(isPerfect(root3));  
    
    System.out.println("\n[16] Should print out:\ntrue"); 
    System.err.println(isPerfect(root1));        
    
    
    System.out.println("\nTesting isBST ....");
    
    // not BSTs 
    Node temp = new Node(4, new Node(5), null);
    Node temp2 = new Node(4, new Node(2, new Node(1), new Node(5)), new Node(10));
    
    System.out.println("\n[17] Should print out:\ntrue"); 
    System.err.println(isBST(root0)); 
    
    System.out.println("\n[18] Should print out:\ntrue"); 
    System.err.println(isBST(root4)); 
    
    System.out.println("\n[19] Should print out:\nfalse"); 
    System.err.println(isBST(temp)); 
    
    System.out.println("\n[20] Should print out:\nfalse"); 
    System.err.println(isBST(temp2)); 
    
    System.out.println("\n[21] Should print out:\nfalse"); 
    System.err.println(isBST(temp2)); 
    
    
    int[] A1 = { 9, 4,1, 7, 5, 2,  12 };
    System.out.println("\nTesting copy ....");
    root1 = insertArray(A,root1);
    
    temp = copy(root1);
    System.out.println("\n[22] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
    System.err.println(treeToString(root1)); 
    
    System.out.println("\n[23] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
    System.err.println(treeToString(temp)); 
    
    temp = insert(temp, 1000); 
    
    System.out.println("\n[24] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 ( 1000 ))))");  
    System.err.println(treeToString(temp)); 
    
    System.out.println("\n[25] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
    System.err.println(treeToString(root1)); 
    
    System.out.println("\nTesting reverse ....");
    
    System.out.println("\n[26] Should print out:\n((( 12 ) 9 ( 7 )) 5 (( 4 ) 2 ( 1 )))");  
    System.err.println(treeToString(reverse(copy(root1)))); 
    
    System.out.println("\n[27] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
    System.err.println(treeToString(reverse(reverse(root1)))); 
    
    System.out.println("\nTesting equals ....");
    
    System.out.println("\n[28] Should print out:\nfalse"); 
    System.err.println(equals(root1, root2)); 
    
    System.out.println("\n[29] Should print out:\nfalse"); 
    System.err.println(equals(root1, temp)); 
    
    int[] A2 = { 5, 2, 9, 1, 4, 12, 7 };
    temp = null; 
    temp = insertArray(A2,temp);
    
    System.out.println("\n[30] Should print out:\ntrue"); 
    System.err.println(equals(root1, temp)); 
    
    
    
    System.out.println("\n :-) "); 
    
    boolean IamDone = true; 
    System.out.println("\n[31] Should print out:\nHigh Five!"); 
    if(IamDone)
      System.err.println("High Five!");
    else
      System.err.println("Nope!"); 
    

  }
  
}