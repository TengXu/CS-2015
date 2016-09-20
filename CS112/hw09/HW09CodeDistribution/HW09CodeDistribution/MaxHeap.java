/* File MaxHeap.java
 * Author: Teng Xu
 * Date: 4/15/16
 */ 

class MaxHeap {
   
   private final int SIZE = 10;       // initial length of array
   private int next = 0;              // limit of elements in array
   private Article[] A = new Article[SIZE];   // implements tree by storing elements in level order
   
   private int h(String x, int M) {   // from Hashing Tutorial
   char ch[];
   ch = x.toCharArray();
   int xlength = x.length();
   int i, sum;
   for (sum=0, i=0; i < x.length(); i++)
     sum += ch[i];
   return sum % M;
   }
   
   private void resize() {
      Article[] B = new Article[A.length*2];
      for(int i = 0; i < A.length; ++i)
         B[i] = A[i];
      A = B; 
   }
   
   // methods to move up and down tree as array
   
   private int parent(int i) { return (i-1) / 2; }
   private int lchild(int i) { return 2 * i + 1; }
   private int rchild(int i) { return 2 * i + 2; }
   
   private boolean isLeaf(int i) { return (lchild(i) >= next); }
   private boolean isRoot(int i) { return i == 0; }
   
   // standard swap, using indices in array
   private void swap(int i, int j) {
      Article temp = A[i];
      A[i] = A[j];
      A[j] = temp;
   }
   
   // basic data structure methods
   
   public boolean isEmpty() {
      return (next == 0);
   }
   
   public int size() {
      return (next);
   }
   
   // insert an integer into array at next available location
   //    and fix any violations of heap property on path up to root
   
   public void insert(Article k) {
      if(size() == A.length) resize(); 
      A[next] = k;       
      int i = next;
      int p = parent(i); 
      while(!isRoot(i) && A[i].cosineSimilarity > A[p].cosineSimilarity) {
         swap(i,p);
         i = p;
         p = parent(i); 
      }    
      ++next;
   }
   
   
   // Remove top (maximum) element, and replace with last element in level
   //    order; fix any violations of heap property on a path downwards
   
   public Article getMax() {
     if(next == 0){
        return null;
     }
      next--;
      swap(0, next);                // swap root with last element
      int i = 0;                   // i is location of new key as it moves down tree
      // while there is a maximum child and element out of order, swap with max child
      int mc = maxChild(i); 
      while(!isLeaf(i) && (A[i].cosineSimilarity < A[mc].cosineSimilarity)) { 
         swap(i,mc);
         i = mc; 
         mc = maxChild(i);
      }      

      return A[next];
   }
   
   // return index of maximum child of i or -1 if i is a leaf node (no children)
   
   int maxChild(int i) {
      if(lchild(i) >= next)
         return -1;
      if(rchild(i) >= next)
         return lchild(i);
      else if(A[lchild(i)].cosineSimilarity > A[rchild(i)].cosineSimilarity)
         return lchild(i);
      else
         return rchild(i); 
   }
   
   // Apply heapsort to the array A. To use, fill A with keys and then call heapsort
   
   public void heapSort() {
      next = 0;
      for(int i = 0; i < A.length; ++i)      // turn A into a heap
         insert(A[i]);
      for(int i = 0; i < A.length; ++i)      // delete root A.length times, which swaps max into
         getMax();                           //  right side of the array
   }
   
   // debug method
   
   private void printHeap() {
      for(int i = 0; i < A.length; ++i)
         System.out.print(A[i] + " ");
      System.out.println("\t next = " + next);
   }
   
   private void printHeapAsTree() {
      printHeapTreeHelper(0, ""); 
      System.out.println(); 
   }
   
   private void printHeapTreeHelper(int i, String indent) {
      if(i < next) {        
         printHeapTreeHelper(rchild(i), indent + "   "); 
         System.out.println(indent + A[i]);
         printHeapTreeHelper(lchild(i), indent + "   "); 
      }
   }
   
   public static  void main(String [] args) {
      
      MaxHeap H = new MaxHeap(); 
      
      // test basic methods
      int[] S = { 4, 3, 5, 8, 4, 1};
      System.out.println("Insert { 4, 3, 5, 8, 4, 1} and print heap after each insertion:"); 
      for(int i = 0; i < S.length; ++i) {
         H.insert(S[i]);
         H.printHeapAsTree(); 
      } 
      

      System.out.println("getMax() and print out, until empty:\n");
    while(!H.isEmpty()) {
         System.out.println("Max: " + H.getMax());
         H.printHeapAsTree(); 
    }
      
      System.out.println("\nheapsort: { 3, 6, 2, 8, 5, 23, -2, 6, 9, 4, 8, 12 }\n");
      int[] B = { 3, 6, 2, 8, 5, 23, -2, 6, 9, 4, 8, 12 };
      H.A = B;
      H.heapSort();
      for(int i = 0; i < H.A.length; ++i)
         System.out.print(H.A[i] + " "); 
      System.out.println(); 
      
   }
}
