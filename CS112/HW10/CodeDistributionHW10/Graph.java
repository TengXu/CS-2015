/*
 * File: Graph.java
 * Purpose: This class represents the "board" on which the sim game plays.
 * Date: 4/22/16
 * Class: CS 112
 *
 * Author: Mingyang Yan (myyan@bu.edu) and Teng Xu (xt@bu.edu)
 */

public class Graph {
    
    private static int[][] B;
    public static int n;
    
    // constructor
    public Graph(int N) {
        this.B = new int[N][N];
        this.n = N;
    }
    
    // add an edge between u and v with value w
    public void addEdge(int u, int v, int w) {
        if( u != v) {
            B[u][v] = w;
            B[v][u] = w;
        }
    }
    
    // remove an edge between u and v with value w
    public void removeEdge(int u, int v) {
        B[u][v] = 0;
        B[v][u] = 0;
    }
    
    // return {-1, 0 , or 1} of the edge between u and v
    public int getEdge(int u, int v) {
        if( u != v)
            return B[u][v];
        return 0;
    }
    
    // return true if there is an edge between u and v
    public boolean isEdge(int u, int v) {
        if( B[u][v] == 1 || B[u][v] == -1 )
            return true;
        else
            return false;
    }  
    
    // return the degree of v
    public int degree(int v) {
        int count = 0;
        for( int i = 0; i < n; i++) {
            if( B[i][v] != 0)
                count++;
        }
        return count;
    }
    
    // return the degree of v with w
    public int degree(int v, int w) {
        int count = 0;
        for( int i = 0; i < n; i++) {
            if( B[i][v] == w)
                count++;
        }
        return count;
    }
    
    // print out the edge matrix
    public void printEdges() {
        System.out.println("      0   1   2   3   4   5\n");
        for( int i = 0; i < n; i++) {
            String s = "";
            s += (i + ": ");
            for( int j = 0; j < n; j++) {
                if( B[i][j] == -1)
                    s += "  -1";
                else if( B[i][j] == 1)
                    s += "   1";
                else
                    s += "    ";
            }
            
            System.out.println(s);
            System.out.println();
        }
        
    }
    
    // return true iff there is a cycle of x among edges of color w 
    public boolean isCycleOfLength(int x, int w) {
        for( int i = 0; i < n; i++) {
            if( isCycleHelper(i, i, x, w))
                return true;
        }
        return false;
    }
    
    //public static int[] visited = {-2, -2, -2, -2, -2, -2};
    
    // helper function
    public boolean isCycleHelper(int u, int v, int x, int w) {
        //System.err.println(u);
        //System.err.println(v);
        //visited[u] = u;
        if( x == 1 && getEdge(u, v) == w) {
            //for(int i =0;i<n;i++)
            //    visited[i] = -2;
            return true;}
       // else if( x == 0 && visit(u))
         //   return true;
        else if (x != 1){
        for(int i = 0; i < n; i++) {
            if( i != u && getEdge(u, i) == w) {
                //System.err.println(x);
                if( isCycleHelper(i, v, x-1, w))
                    return true;
            }
        }}
        return false;
    }
        
    
    // check if x is visited or not
    /*
    private static boolean visit(int x) {
        for( int i = 0; i < n; i++) { 
            if( x == visited[i])
                return true;
        }
        return false;
    }
    */
    public static boolean isFull() {
        for( int i = 0; i < n; i++) {
            for( int j = i + 1; j < n; i++) {
                if (B[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    
    // Unit tests
    public static void main(String [] args) {
        Graph A = new Graph(6);
        
        System.out.println("\n[1] Testing addEdge... Should print out:\n      0   1   2   3   4   5\n");
        System.out.println("0:       -1  -1\n");
        System.out.println("1:   -1      -1  \n");
        System.out.println("2:   -1  -1\n");
        System.out.println("3: \n\n4: \n\n5: \n");
        
        A.addEdge(0, 1, -1);
        A.addEdge(0, 2, -1);
        A.addEdge(1, 2, -1);
        
        A.printEdges();
        
        System.out.println("\n[2]  Testing isCycleOfLength... Should print out:\ntrue");
        System.out.println(A.isCycleOfLength(3, -1));
        
        System.out.println("\n[3] Testing removeEdge... Should print out:\n      0   1   2   3   4   5\n");
        System.out.println("0:           -1\n");
        System.out.println("1:           -1  \n");
        System.out.println("2:   -1  -1\n");
        System.out.println("3: \n\n4: \n\n5: \n");
        
        A.removeEdge(0, 1);
        A.printEdges();
        
        System.out.println("\n[4] Testing getEdge... Should print out:\n-1");
        System.out.println( A.getEdge(0, 2));
        
        System.out.println("\n[5] Testing isEdge... Should print out:\ntrue false");
        System.out.print( A.isEdge(0, 2));
        System.out.println( " " + A.isEdge(0, 1));
        
        System.out.println("\n[6] Testing degree... Should print out:\n1");
        System.out.println( A.degree(0));
        
        System.out.println("\n[7] Testing degree(int v, int w)... Should print out:\n1");
        System.out.println( A.degree(0, -1));
        
        //A.printEdges();
        //A.addEdge(1, 3, -1);
        //A.addEdge(2, 3, -1);
        //A.addEdge(4, 3, 1);
        //System.out.println(A.isCycleOfLength(3, -1));
        //A.printEdges();
    }
    
    
}