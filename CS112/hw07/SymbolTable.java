/* File: SymbolTable.java
 * Author: Teng Xu
 * Date: 3/19/16
 * Purpose: This is the template for HW 07, containing only the unit test and Node definition 
 */

public class SymbolTable<Value> {
    
  
  private class Node {               
    String variable;
    Value value;
    Node next;
    
    public Node() {}
    
    public Node(String k, Value v) {
      variable = k; value = v; next = null;
    }
    
    public Node(String k, Value v, Node p) {
      variable = k; value = v; next = p;
    }
  }
  
  private Node head = null; 
  private int size = 0;
  // Your code here!!
  
  public void put(String var, Value val) {
      head = putHelper(var, val, head);
 }
 
  private Node putHelper( String var, Value val, Node p ) {
    if(contains(var) == false){
      if(p == null){ 
        size++;
        return new Node(var, val);
      }
      else if(var.compareTo(p.variable) < 0){
        size++;        
        return new Node(var, val, p);
      }
      else {
       p.next = putHelper( var, val, p.next ); 
       return p;
      }
    }
    else{
      if(p == null) {
       size++;        
       return new Node(var, val);       
      }
    else if(p.variable == var){
      p.value = val;
      return p;
    }
    else {
       p.next = putHelper( var, val, p.next ); 
       return p;
    }
  }
  }

  
  public Value get(String var) throws KeyNotFoundException { 
    if(contains(var) == false)
      throw new KeyNotFoundException();
    else{
      return gethelper(var, head);
    }
  } 
  private Value gethelper(String var, Node p){
    if(p.variable == var)
      return p.value;
    else
      return gethelper(var, p.next);
  }
    
    
  public boolean contains(String var) {
    return containshelper(var, head);
  }
    
  private boolean containshelper(String var, Node p) {
    if(p == null)
      return false;
    else if(p.variable == var)
      return true;    
    else{
      return containshelper(var, p.next);
    }
  }
  
  private int length( Node p ) {                   
       if (p == null) 
          return 0;
       else
          return 1 + length( p.next ); 
     }
  
  public int size() { 
    return size;
  }
  
  public String toString(){
    return toStringhelper(head, "");
  }  
  
  private String toStringhelper(Node p, String a){
     if (p != null && p.next != null) {
         a += "("+p.variable+","+p.value+") : "; 
         a += toStringhelper(p.next, ""); 
     }    
     else if(p.next == null){
         a += "("+p.variable+","+p.value+")";       
     }
     return a;
  }
  
  public boolean isEmpty() { 
    return(size == 0);
  }
  
  public void delete(String var) {
    deletehelper(var, head);
  }
  private Node deletehelper( String k, Node p ) {
       if( p == null )                 
          return p; 
       else if ( p.variable == k ){
         size--;
         return p.next;        
       }
       else {
          p.next = deletehelper( k, p.next );
          return p; 
       }
    }   
  
  public String min() throws KeyNotFoundException { 
    if(size == 0)
      throw new KeyNotFoundException();
    else{
      return head.variable;
    }
  }
  
  public String max() throws KeyNotFoundException { 
    if(size == 0)
      throw new KeyNotFoundException();
    else{
      return maxhelper(head);
    }
  }  
  private String maxhelper(Node p){
       if( p == null || p.next == null ) 
          return p.variable;      
       else {
          return maxhelper( p.next );  
       }
  }
  
  public String floor(String var) throws KeyNotFoundException {
    if(size == 0 || (var.compareTo(head.variable) < 0))
      throw new KeyNotFoundException();
    else if(contains(var))
      return var;
    else{
      return floorhelper(var, head);
    }
  }
  private String floorhelper(String var, Node p){
    if(p.next.variable.compareTo(var) > 0)
      return p.variable;
    else
      return floorhelper(var, p.next);
  }
  
 
  public String ceiling(String var) throws KeyNotFoundException {
    if(size == 0 || (var.compareTo(max()) > 0))
      throw new KeyNotFoundException();
    else if(contains(var))
      return var;
    else{
      return ceilinghelper(var, head);
    }    
  }
  private String ceilinghelper(String var, Node p){
    if(p.next.variable.compareTo(var) > 0)
      return p.next.variable;
    else
      return ceilinghelper(var, p.next);
  }       

  public int rank(String var){
    return rankhelper(var, head);
  }
  private int rankhelper(String var, Node p){
       if (p == null) 
          return 0;
       else if(p.variable.compareTo(var) >= 0)
         return 0;
       else
          return 1 + rankhelper(var, p.next ); 
  }
       
  public String select(int r) throws KeyNotFoundException {
    if(r < 0 || r >= size)
      throw new KeyNotFoundException();
    else{
      return selecthelper(r, head);
    }
  }
  private String selecthelper(int r, Node p){
    if(r == 0)
      return p.variable;
    else if(p == null)
      return "";
    else
      return selecthelper(r-1, p.next);
  }
  
  public void deleteMin() {
    if(size > 0){
      head = head.next;
      size--;
    }
  }
  
  public void deleteMax() {
    deleteLast( head );
  }
  private Node deleteLast( Node p ){
    if( p == null || p.next == null ) {
          size--;
          return null;      
    }
       else {
          p.next = deleteLast( p.next );
          return p;
       }
    }  
  
  public int size(String lo, String hi) {
    int a = rank(lo);
    int b = rank(hi);
    int c = b - a ;
    if(contains(hi))
      c++;
    return c;
  }
  
  public static void main(String[] args) {
    
    
    SymbolTable<Integer> S = new SymbolTable<Integer>(); 
  
    
    S.put("a",3); 
    S.put("c",1);
    S.put("b",1);
    
    System.out.println("\n[1] Should print out:\n(a,3) : (b,1) : (c,1) "); 
    System.out.println(S); 
    
    System.out.println("\n[2] Should print out:\n3"); 
    System.out.println(S.size()); 
    
    System.out.println("\n[3] Should print out:\nfalse"); 
    System.out.println(S.isEmpty()); 
    
    System.out.println("\n[4] Should print out:\n1");  
    String testKey = "c"; 
    try {
      System.out.println(S.get(testKey)); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key " + testKey + " does not exist!"); 
    }
    
    System.out.println("\n[5] Should print out:\nKey d does not exist!");  
    testKey = "d"; 
    try {
      System.out.println(S.get(testKey)); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key " + testKey + " does not exist!"); 
    }
    
    System.out.println("\n[6] Should print out:\n(a,3) : (b,1) : (c,4) "); 
    S.put("c",4);
    System.out.println(S);    
    
    System.out.println("\n[7] Should print out:\ntrue"); 
    System.out.println(S.contains("c"));  
    
    System.out.println("\n[8] Should print out:\ntrue"); 
    System.out.println(S.contains("a")); 
    
    System.out.println("\n[9] Should print out:\nfalse"); 
    System.out.println(S.contains("e"));  
    
    S.delete("a"); 
    S.delete("d"); 
    S.delete("c"); 
    System.out.println("\n[10] Should print out:\n(b,1)");     
    System.out.println(S); 
    
    System.out.println("\n[11] Should print out:\n0");  
    S.delete("b"); 
    System.out.println(S.size()); 
    
    System.out.println("\n[12] Should print out:\nnope! nope! nope! nope! nope!");  
    try{
      System.out.println(S.min()); 
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! "); 
    }
    
    try{
      System.out.println(S.max()); 
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! "); 
    }
    try{
      System.out.println(S.floor("a")); 
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! "); 
    }
    try{
      System.out.println(S.ceiling("a")); 
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! "); 
    }
    
    
    try{
      System.out.println(S.select(0)); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("nope! "); 
    }
    
    
    
    SymbolTable<String> T = new SymbolTable<String>(); 
    
    T.put("09:00:00","Chicago");
    T.put("09:00:03","Phoenix");
    T.put("09:00:13","Houston");
    T.put("09:00:59","Chicago"); 
    T.put("09:36:14","Seattle");
    T.put("09:37:44","Phoenix");
    T.put("09:10:25","Seattle");
    T.put("09:14:25","Phoenix");
    T.put("09:19:32","Chicago");
    T.put("09:19:46","Chicago");
    T.put("09:21:05","Chicago");
    T.put("09:22:43","Seattle");
    T.put("09:01:10","Houston");
    T.put("09:03:13","Chicago");
    T.put("09:10:11","Seattle");
    T.put("09:25:52","Chicago");
    T.put("09:22:54","Seattle");  
    T.put("09:35:21","Chicago");
    
    System.out.println("\n[13] Should print out:\n(09:00:00,Chicago) : (09:00:03,Phoenix) : (09:00:13,Houston) : (09:00:59,Chicago) : (09:01:10,Houston) : (09:03:13,Chicago) : (09:10:11,Seattle) : (09:10:25,Seattle) : (09:14:25,Phoenix) : (09:19:32,Chicago) : (09:19:46,Chicago) : (09:21:05,Chicago) : (09:22:43,Seattle) : (09:22:54,Seattle) : (09:25:52,Chicago) : (09:35:21,Chicago) : (09:36:14,Seattle) : (09:37:44,Phoenix)");      
    System.out.println("\n" + T);    
      
    try{
      System.out.println("\n[14] Should print out:\n09:00:00");
      System.out.println(T.min()); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:00:00 does not exist!"); 
    } 
    try{
      System.out.println("\n[15] Should print out:\n09:37:44");
      System.out.println(T.max()); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:37:44 does not exist!"); 
    } 
    
    try{
      System.out.println("\n[16] Should print out:\n09:03:13");
      System.out.println(T.floor("09:05:00")); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:05:00 does not exist!"); 
    } 
    
    try{
      System.out.println("\n[17] Should print out:\n09:35:21");
      System.out.println(T.floor("09:35:21")); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:35:21 does not exist!"); 
    }
    
    try{
      System.out.println("\n[18] Should print out:\n09:35:21");
      System.out.println(T.ceiling("09:30:00")); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:35:21 does not exist!"); 
    } 
    
    try{
      System.out.println("\n[19] Should print out:\n09:00:00");
      System.out.println(T.ceiling("09:00:00")); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:00:00 does not exist!"); 
    }

    try{
      System.out.println("\n[20] Should print out:\n09:10:25");
      System.out.println(T.select(7)); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:10:25 does not exist!"); 
    } 
    
    System.out.println("\n[21] Should print out:\n7");
    System.out.println(T.rank("09:10:25")); 
    
    System.out.println("\n[22] Should print out:\n15");
    System.out.println(T.rank("09:30:00"));     
    
    System.out.println("\n[23] Should print out:\n5");
    System.out.println(T.size("09:15:00", "09:25:00")); 
    
    try {
      System.out.println("\n[24] Should print out:\n18 18");
      System.out.println(T.size() + " " + T.size(T.min(), T.max())); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!"); 
    }
    
    try {   
      System.out.println("\n[25] Should print out:\n09:00:03");
      T.deleteMin(); 
      System.out.println(T.min()); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!");
    }
    
    try {   
      System.out.println("\n[26] Should print out:\n09:36:14");
      T.deleteMax(); 
      System.out.println(T.max()); 
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!");
    }
    
    
    System.out.println("\n[27] Should print out:\n16");
    System.out.println(T.size()); 
    
    
    
    
  }
}


class KeyNotFoundException extends Exception {}


