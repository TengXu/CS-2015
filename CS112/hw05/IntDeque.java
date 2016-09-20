/* File: IntDeque.java
 * Date: 2/22/2016
 * Author:  Teng Xu
 * Class: CS 112, Spring 2016
 * Purpose: This is the template for HW 05, Problem B.2.
 */

public class IntDeque {
  
    private int SIZE = 10; 
    private int [] A = new int[SIZE];    
    private int size = 0;    
    private int front = 0;
    private int next = 0; 
    
    private void resize(){
      int [] B = new int[SIZE * 2]; 
      B[0] = A[front];
      for(int i = 1; i < A.length; i++)
        B[i] = A[nextSlot(front)];     
      SIZE *= 2;  
      A = B;
    }
    
    public void enqueueFront(int k){
      if(size == SIZE)
         resize();
      front = previousSlot(front);
      A[front] = k; 
      ++size;       
    }

    public int dequeueFront() throws UnderFlowException{
      if(size < 1)
          throw new UnderFlowException("UnderFlow: Queue is empty." );
      else{
      int temp = A[front];  
      front = nextSlot(front);  
      --size;   
      return temp;
      }
    }

    public int nextSlot(int k) {       
      return ((k + 1) % A.length);      
    }
    
    public void enqueueRear(int k){
      if(size == SIZE)
         resize();      
      A[next] = k; 
      next = nextSlot(next);
      ++size;    
    }

    public int dequeueRear() throws UnderFlowException {
      if(size < 1)
          throw new UnderFlowException("UnderFlow: Queue is empty." );
      {
      int temp = A[previousSlot(next)];  
      next = previousSlot(next);  
      --size;   
      return temp;
      }
    }
      
    public int previousSlot(int k){  
      if (k - 1 < 0)
        return 9;
      return (k - 1); 
    }
    
    
    public int size() {  
      return size; 
    } 
    
    
    public boolean isEmpty() { 
      return (size == 0); 
    }
    
    public String toString() {
        String s = "";
        s += "[" + A[SIZE - 1];
        for(int i = SIZE - 2; i > -1; --i)
            s += ", "+A[i]; 
        s += "]";
        s += "  length: " + SIZE +"  size: " + size + "  front: " + front +"  next: " + next ;
        return s; 
    }
    
    // Unit Test (you must complete this with additonal tests as indicated)
    
    public static void main(String[] args) {

      try { 
        IntDeque D = new IntDeque(); 
        
        System.out.println("\n[1] First test toString on empty dequeue... Should print out:"); 
        System.out.println("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]  length: 10  size: 0  front: 0  next: 0"); 
        System.out.println(D); 
        
        System.out.println("\n[2] Test size and isEmpty... Should print out:\n0  true"); 
        System.out.println(D.size() + "  " + D.isEmpty()); 
        
        System.out.println("\n[3] Test enqueueRear.... Should print out:"
                               + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 4  front: 0  next: 4");
        D.enqueueRear(1); 
        D.enqueueRear(2);
        D.enqueueRear(3); 
        D.enqueueRear(4);
        
        System.out.println(D); 
        
        System.out.println("\n[4] Test size and isEmpty again... Should print out:\n4  false"); 
        System.out.println(D.size() + "  " + D.isEmpty()); 
        
        System.out.println("\n[5] Test dequeueFront.... Should print out:"
                               + "\nn = 1  m = 3");
        int n = D.dequeueFront(); 
        D.dequeueFront();  
        int m = D.dequeueFront(); 
        System.out.println("n = " + n + "  m = " + m); 
        
        System.out.println("\n[6] And should print out:"
                               + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 1  front: 3  next: 4");
        System.out.println(D); 
        
        
        System.out.println("\n[7] Test wrap-around of enqueueRear .... Should print out:"
                               + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 10  front: 3  next: 3");
        
        for(int i = 5; i < 14; ++i)
            D.enqueueRear(i);
        
        System.out.println(D); 
        
        System.out.println("\n[8] Test wrap-around of dequeueFront .... Should print out:"
                               + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 0  front: 3  next: 3  m = 13");
        
        for(int i = 0; i < 9; ++i)
            D.dequeueFront();
        m = D.dequeueFront(); 
        
        System.out.println(D + "  m = " + m); 
        
        System.out.println("\n[9] Test enqueueFront and should print out:\n[10, 9, 8, 7, 6, 5, 4, 1, 7, 11]  length: 10  size: 2  front: 1  next: 3");
        D.enqueueFront(1);
        D.enqueueFront(7);        
        System.out.println(D);
        
        System.out.println("\n[10] Test size and isEmpty again. Should print out:\n2  false"); 
        System.out.println(D.size() + "  " + D.isEmpty()); 
        
        System.out.println("\n[11]: Test dequeueRear, and should print out:\n[10, 9, 8, 7, 6, 5, 4, 1, 7, 11]  length: 10  size: 1  front: 1  next: 2");
        D.dequeueRear();     
        System.out.println(D);
        
        System.out.println("\n[12]: test wrap-around of enqueue rear and dequeue front"
                             + "and should print out:\n[2, 3, 4, 5, 6, 7, 8, 9, 7, 1]  length: 10  size: 7  front: 4  next: 1");
        D.enqueueRear(9);        
        D.enqueueRear(8);        
        D.enqueueRear(7);        
        D.enqueueRear(6);  
        D.enqueueRear(5);        
        D.enqueueRear(4);        
        D.enqueueRear(3);        
        D.enqueueRear(2);  
        D.enqueueRear(1);  
        D.dequeueFront();    
        D.dequeueFront();
        D.dequeueFront();       
        System.out.println(D);   
        
        System.out.println("\n[13]: Test all four methods together by alternately removing and adding from both ends"+
                  "and should print out:\n[2, 3, 4, 5, 6, 7, 8, 7, 6, 1]  length: 10  size: 8  front: 4  next: 2");        
        D.enqueueFront(8); 
        D.enqueueRear(6);        
        D.enqueueRear(7); 
        D.dequeueRear();               
        D.dequeueFront(); 
        System.out.println(D);  
        
        System.out.println("\n[14]: Test size and should print out:\n8");
        System.out.println(D.size);
        
        System.out.println("\n[15]: test resizing and should print out:"+
                           "\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 7, 6, 6, 6, 7]  length: 20  size: 11  front: 4  next: 5 ");
        D.enqueueRear(7);   
        D.enqueueRear(7);  
        D.enqueueRear(7);          
        System.out.println(D);        
        
        System.out.println("\n[16]: test that enqueue and dequeue (all four) work after resize and should print out:"+
                           "\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 7, 6, 7, 8, 6, 6, 7]  length: 20  size: 12  front: 4  next: 6 ");
        D.enqueueFront(8); 
        D.enqueueRear(6);        
        D.enqueueRear(7); 
        D.dequeueRear();               
        D.dequeueFront(); 
        System.out.println(D);         
        
        System.out.println("\n[17]: Test size to make sure it works after the resize and should print out:\n12");
        System.out.println(D.size);

        System.out.println("\n[18]: Test exceptions by dequeueRear and should print out: \nUnderFlow: Queue is empty.");
        D.dequeueRear(); 
        D.dequeueRear();    
        D.dequeueRear(); 
        D.dequeueRear(); 
        D.dequeueRear(); 
        D.dequeueRear();    
        D.dequeueRear(); 
        D.dequeueRear();      
        D.dequeueRear(); 
        D.dequeueRear();    
        D.dequeueRear(); 
        D.dequeueRear();  
        D.dequeueRear();        
        System.out.println(D);        
      }
     
      try{
        System.out.println("\n[19]: Test exceptions by dequeueFront and should print out: \nUnderFlow: Queue is empty.");
        D.dequeueFront(); 
        D.dequeueFront();    
        D.dequeueFront(); 
        D.dequeueFront(); 
        D.dequeueFront(); 
        D.dequeueFront();    
        D.dequeueFront(); 
        D.dequeueFront();      
        D.dequeueFront(); 
        D.dequeueFront();    
        D.dequeueFront(); 
        D.dequeueFront();  
        D.dequeueFront();        
        System.out.println(D);  
      }
      }
      catch (UnderFlowException e) {
            System.err.println(e.getMessage()); 
      }
    }
}


class UnderFlowException extends Exception {
    public UnderFlowException(String msg) {
        super(msg);       
    }   
}

                