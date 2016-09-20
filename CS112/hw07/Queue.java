/* File: StringQueue.java
 * Date: 3/17/2016
 * Author:  Teng Xu
 * Class: CS 112, Spring 2016
 * Purpose: This is the solution for HW 06, Problem B.1 (lab problem)
 */

public class Queue<T> {
    
    private Node front = null; 
    private Node rear = null; 
    
    private int size = 0; 
    
    public class Node { 
        public T item; 
        public Node next; 
        
        // constructors 
        public Node() { 
            item = null; 
            next = null; 
        } 
        
        public Node(T n) { 
            item = n; 
            next = null; 
        } 
        
        public Node(T n, Node p) { 
            item = n; 
            next = p;         
        } 
    }
    
    public void enqueue(T s) {
        if(isEmpty())
            front = rear = new Node(s);
        else {
            rear.next = new Node(s);
            rear = rear.next;
        }
        ++size; 
    }
    
    public T dequeue() {
        T temp = front.item;
        front = front.next;
        --size;
        return temp;
    }
    
    
    public boolean isEmpty() {
        return (front == null);
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        return toStringAux(front);
    }
    
    private String toStringAux(Node p) {
        if (p == null)
            return "";
        else
            return toStringAux(p.next) + " " + p.item;
    }
    
    
    public static void main(String[] args) {
        
        Queue<String> S = new Queue<String>(); 
        
        System.out.println("\n[1] First test toString on empty StringQueue... Should print out:"); 
        System.out.println(" "); 
        System.out.println(S); 
        
        System.out.println("\n[2] Test size and isEmpty... Should print out:\n0  true"); 
        System.out.println(S.size() + "  " + S.isEmpty()); 
        
        System.out.println("\n[3] Enqueue 9 strings... Should print out:\n ! President for run to looney be to have You'd"); 
        S.enqueue("You'd");
        S.enqueue("have");
        S.enqueue("to");
        S.enqueue("be");
        S.enqueue("looney");
        S.enqueue("to");
        S.enqueue("run");
        S.enqueue("for");
        S.enqueue("President");
        S.enqueue("!");
        System.out.println(S);
        
        
        System.out.println("\n[4] Test size and isEmpty... Should print out:\n10  false"); 
        System.out.println(S.size() + "  " + S.isEmpty()); 
        
        
        System.out.println("\n[5] Just for fun... Should print out a long String!");
        S.enqueue("So");
        S.enqueue("Trump");
        S.enqueue("is");
        S.enqueue("a");
        S.enqueue("looney!");
        String s = "";
        while(!S.isEmpty())
            s += S.dequeue();
        for(int i = 0; i < 5; ++i)
            S.enqueue(s);
        S.enqueue("\n");
        String t = "";
        while(!S.isEmpty())
            t += S.dequeue();
        for(int i = 0; i < 5; ++i)
            S.enqueue(t);
        while(!S.isEmpty())
            System.out.println(S.dequeue());
        
        
    }
}

