/*
 * File: Player.java
 * Purpose: This implements the minMax strategy. Input is a graph, and the player
 *      chooses the next edge to draw. Player is the machine playing as the max player,
 *      the weight of the its edges are -1, shown as blue. 
 * Date: 4/26/16
 * Class: CS 112
 *
 * Author: Mingyang Yan (myyan@bu.edu) and Teng Xu (xt@bu.edu)
 */



public class Player {
    
    public static int D = 6;
    
    public static int eval(Graph G) {
        int A = 0;
        int B = 0;
        
        if( G.isCycleOfLength(3, 1))
            return Inf;
        if( G.isCycleOfLength(3, -1))
            return -Inf;
        else {
            for( int i = 0; i < Graph.n; i++) {
                for( int j = 0; j < Graph.n; j++) {
                    for( int k = 0; k < Graph.n; k++) {
                        // check if the two connected edges of a triangle have the same color
                        if(i != j && j != k && i != k) {
                            
                            if( G.getEdge(i, j) == -1 && G.getEdge(i, k) == -1 && G.getEdge(j, k) == 1)
                                A++;
                            else if( G.getEdge(i, j) == -1 && G.getEdge(j, k) == -1 && G.getEdge(i, k) == 1)
                                A++;
                            else if( G.getEdge(i, k) == -1 && G.getEdge(j, k) == -1 && G.getEdge(i, j) == 1)
                                A++;
               
                            else if( G.getEdge(i, k) == 1 && G.getEdge(j, k) == 1 && G.getEdge(i, j) == -1)
                                B++;
                            else if( G.getEdge(j, k) == 1 && G.getEdge(i, k) == 1 && G.getEdge(i, j) == -1)
                                B++;
                            else if( G.getEdge(j, k) == 1 && G.getEdge(j, i) == 1 && G.getEdge(i, k) == -1)
                                B++;
                        }
                    }
                }
            }
            
            return A - B;
        }
    }
    
    public static final int Inf = 100000;
    
    public static Move chooseMove(Graph t) { 
        int max = -Inf;
        Move best = new Move(0, 1);      
        for (int row = 0; row < t.n; ++row) {
            for (int col = 0; col < t.n; ++col) {
                Move m = new Move(row, col); 
                if (col != row && !t.isEdge(row, col)) {
                    //System.err.println(row + " " + col);
                   
                    t.addEdge(row, col, -1);
                    int val = minMax( t, 1, -Inf, Inf );  
                    //System.err.println( "This" + val);
                    if(val >= max) { 
                        //System.err.println("Changed Best");
                        best = m; 
                        max = val; 
                    }   
                    t.removeEdge( row, col);
                }
            }
            
        }
        //System.err.println(best.source);
        //System.err.println(best.target);
        return best;   
    } 
    
    public static int minMax(Graph t, int depth, int alpha, int beta ) {   
        if( t.isCycleOfLength(3,1) || t.isCycleOfLength(3,-1) || depth == D || t.isFull())     
            return eval(t); 
       // else if(eval(t) == Inf || eval(t) == -Inf)
         //   return eval(t);
        else if( depth % 2 == 0) {    
            int val = -Inf;    
            for (int row = 0; row < t.n; ++row) {
                for (int col = row + 1; col < t.n; ++col) {
                    if ( row != col && !t.isEdge(row, col)) {   
                        alpha = Math.max(alpha, val); 
                        if(beta < alpha) 
                            break;
                        t.addEdge(row, col, -1);
                        val = Math.max(val, minMax( t, depth+1, alpha, beta )); 
                        t.removeEdge( row, col);
                    }
                }
            }
            return val; 
        } else {    
            int val = Inf;    
            for (int row = 0; row < t.n; ++row) {
                for (int col = row + 1; col < t.n; ++col) {
                    if( row != col && !t.isEdge(row, col)) {  
                        beta = Math.min(beta, val); 
                        if(beta < alpha) 
                            break;
                        t.addEdge(row, col, 1);
                        val = Math.min(val, minMax( t, depth+1, alpha, beta ) ); 
                        t.removeEdge( row, col);
                    }
                }
            } 
            return val; 
        }
    }
    
    
    
    public static void main(String [] args) {
    }
    
    
}