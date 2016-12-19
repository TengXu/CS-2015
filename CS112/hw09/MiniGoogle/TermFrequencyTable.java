 /*
 * Author: Teng Xu
 * Date: April 16, 2014
 */

public class TermFrequencyTable {
   private class Node{
      String term;
      int[] termFreq = new int[2];       
      Node next;  
      public Node(String a, Node n) {
         this.term = a;
         this.next = n;
      }   
   }
   
   private int SIZE = 101;
   public Node[] hashtable = new Node[SIZE];

   
   private int h(String x, int M) {   // from Hashing Tutorial
   char ch[];
   ch = x.toCharArray();
   int xlength = x.length();
   int i, sum;
   for (sum=0, i=0; i < x.length(); i++)
     sum += ch[i];
   return sum % M;
   }
   
   private boolean member(Node a, String b){
     if(a == null)
       return false;
     else if(a.term.compareTo(b)==0)
       return true;
     else
       return member(a.next, b);
   }
   
   private void add(String t, int doc, Node a){
     if(a != null){
       if(a.term.compareTo(t)==0)
         a.termFreq[doc]++;
       else
         add(t, doc, a.next);
     }
   }
   
   public void insert(String term, int docNum) {
     int num = h(term, 101);
     if(member(hashtable[num], term)){
       add(term,docNum, hashtable[num]);
     }
     else{
       Node p = new Node(term, hashtable[num]);
       hashtable[num] = p;
       p.termFreq[docNum]++;
     }
   }
   
   public double cosineSimilarity(){
     int pro = 0;
     int a2 = 0;
     int b2 = 0;
     for(int i = 0;i<hashtable.length;i++){
       Node a = hashtable[i];
       while(a != null){        
         pro += a.termFreq[0] * a.termFreq[1];
         a2 += a.termFreq[0] * a.termFreq[0];
         b2 += a.termFreq[1] * a.termFreq[1];
         a = a.next;
       }
     }
     double result = pro/(Math.sqrt(a2)*Math.sqrt(b2));
     return result;
   }   
   private static String[] split(String a){
     String[] b = a.split("\\s+");
     return b;
   }
   private static double getCosineSimilarity(String s, String t){
     String[] S = s.split("\\s+");
     String[] T = t.split("\\s+");  
     TermFrequencyTable A = new TermFrequencyTable();
     for(int i = 0; i<S.length;i++){
         A.insert(S[i], 0);
     }
     for(int i = 0; i<T.length;i++){
         A.insert(T[i], 1); 
     }     
     double result = A.cosineSimilarity();
     return result;
   }
   
   public static void main(String[] args){
     TermFrequencyTable A = new TermFrequencyTable();   
     A.insert("A", 0);
     A.insert("A", 1);  
     A.insert("A", 1);     
     A.insert("B", 0); 
     A.insert("B", 1); 
     A.insert("B", 1);     
     double r = A.cosineSimilarity();
     System.out.println("should print out: ");  
     System.out.println("0.9999999999999998");
     System.out.println(r);
   }

}