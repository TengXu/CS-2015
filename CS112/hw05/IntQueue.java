/* File: IntQueue.java
 * Date: 2/22/16
 * Class: Boston University CS 112, Fall 2013
 * Author: Teng Xu
 * Purpose: Example of simple array-based queue for Lab 05
 *          There are two problems to fix, first by implementing reset (which moves
 *          all the members of the queue to the right (towards slot 0), and the
 *          second by using exceptions to report an error. 
 */


public class IntQueue {
    
    private final int SIZE = 10; 
    
    private int [] A = new int[SIZE]; 
    
    private int front = 0;                       // location of front of queue
    
    private int next = 0;                        // location of next available unused slot  
    
    // interface methods
    
    public void enqueue(int key) {               // push the number onto the end of the queue
        if(next >= SIZE)
            reset();                             // this will fix problem of running off end of array
        A[next++] = key; 
    }
    
    public int dequeue() throws UnderFlowException{  
      if((next - front) < 1)
          throw new UnderFlowException("UnderFlow: Queue is empty." );
      else{
        ++front;
        return A[front-1];   
      }
    }
    
    public boolean isEmpty() {
        return (next == front); 
    }
    
    public int size() {           
        return (front - next); 
    }
    

    public void reset() {
      for(int i = 0; i < size(); i++){
        A[i] = A[i + front];
      }
        next = next - front;
        front = 0;
    }
    
    public String toString() {
        String s = "";
        for(int i = SIZE-1; i >= 0; --i)
            s += i + "\t"; 
        s += "\n";
        for(int i = SIZE-1; i >= 0; --i)
            s += A[i] + "\t";
        s += "\nnext = " + next + "   front = " + front + "\n";

        return s; 
    }
    
    
    
    // unit test
    
    public static void main(String [] args) {
     try { 
        
        IntQueue Q = new IntQueue();        
        
        
        System.out.println("Enqueueing 5, 9, 3, -3, 31 then printing out the queue:\n"); 
        Q.enqueue(5); 
        Q.enqueue(9); 
        Q.enqueue(3); 
        Q.enqueue(-3); 
        Q.enqueue(31);
        System.out.println(Q);
  
        System.out.println("Dequeueing 3 times then printing out the queue:\n");
        System.out.println("dequeue: " + Q.dequeue()); 
        System.out.println("\ndequeue: " + Q.dequeue()); 
        System.out.println("\ndequeue: " + Q.dequeue()); 
        System.out.println(Q);
        
        System.out.println("\nEnqueueing 8, -1, 2, 6, 5 then printing out the queue:\n"); 
        Q.enqueue(8); 
        Q.enqueue(-1); 
        Q.enqueue(2); 
        Q.enqueue(6); 
        Q.enqueue(5);
        System.out.println(Q);
        
        
        // First issue:  this one will cause an error! You must fix this by shifting everything
        // to the right (towards the low indices, so that front is at 0 as it was at the beginning)
        
        System.out.println("First issue to fix: the queue has moved all the way to the left!");
        System.out.println("Must write code in reset() to shift all valid elements to right.");

        
        Q.enqueue(666);
        
        System.out.println("\nEmptying out the queue:\n"); 
        while(!Q.isEmpty()) {
            Q.dequeue();
        }
        System.out.println("\n"+Q);
        
        
        // Second issue: after fixing the first problem, you must report an error for this one,
        // which can not be handled normally -- there is no programming solution because
        // there is no element in an empty queue to dequeue! 
        // You must create an exception to report this to the user by printing out an error message.
        
        System.out.println("Second issue to fix: report an error using exceptions for trying to dequeue empty queue.");

        System.out.println("\nQ is empty:  " + Q.isEmpty());
        System.out.println("\ndequeue: " + Q.dequeue());
        
        int k = Q.dequeue();     
        System.out.println("dequeue: "+k);
         }       
     
        catch (UnderFlowException e) {
            System.err.println(e.getMessage());
        }       
    
    }
    
}       

class UnderFlowException extends Exception {
    int value;
    public UnderFlowException(String msg) {
        super(msg);       
    }
    
}


