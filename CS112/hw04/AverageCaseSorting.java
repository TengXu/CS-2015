/* File: AverageCaseSorting.java
 * Author: Teng Xu
 * Date: 2/11/16
 * Purpose: This is a example of how to graph functions using StdDraw.java
 *    This uses the StdDraw "static container" library, which must be 
 *    in the same directory. This draws simple graphs of different mathematical functions.
 */

import java.util.Random;
import java.awt.Color; 

public class AverageCaseSorting {
    
    private static Random R = new Random();
    
    private static int runSelectionSort(int N) {
    int[] A = new int[N];
    Sorting.counter = 0;
    for (int i = 0; i < N; ++i)
       A[i] = R.nextInt();
    Sorting.selectionSort(A);
    return Sorting.counter;
}
    private static int runQuickSort(int N) {
    int[] A = new int[N];
    Sorting.counter = 0;
    for (int i = 0; i < N; ++i)
       A[i] = R.nextInt();
    Sorting.quickSort(A);
    return Sorting.counter;
}
    private static int runMergeSort(int N) {
    int[] A = new int[N];
    Sorting.counter = 0;
    for (int i = 0; i < N; ++i)
       A[i] = R.nextInt();
    Sorting.mergeSort(A);
    return Sorting.counter;
}
    private static int runInsertSort(int N) {
    int[] A = new int[N];
    Sorting.counter = 0;
    for (int i = 0; i < N; ++i)
       A[i] = R.nextInt();
    Sorting.insertionSort(A);
    return Sorting.counter;
}
    
    public static void main(String[] args) {
        
        int N = 100;
        
        double pointRadius = 0.005;
        double lineRadius = 0.001;
        
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, 10*N);
        StdDraw.setPenRadius(pointRadius);
        StdDraw.setPenColor(Color.black);       // Google "Java Color"; the first link gives all the colors
        StdDraw.line(0,0,0,10*N); 
        StdDraw.text(N,20,"" + N);
        StdDraw.line(0,0,N,0);
        StdDraw.text(5,10*N,"" + 10*N);
        
        double prevX, prevY;
        
        StdDraw.setPenColor(Color.black);
        StdDraw.text(80,300,"N^2");       // draw label String at point (15,500)
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            // here is where you put the function you are graphing
            // for example this graphs i^2 (squared)
            int y = i*i;                         
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        StdDraw.setPenColor(Color.gray);
        StdDraw.text(80,50,"N");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = i;                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        StdDraw.setPenColor(Color.orange);
        StdDraw.text(80,100,"Selection sort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = (int) runSelectionSort(i);      
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        StdDraw.setPenColor(Color.blue);
        StdDraw.text(80,250,"Insertion Sort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = (int) runInsertSort(i);      
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }       
        
        StdDraw.setPenColor(Color.green);
        StdDraw.text(80,200,"Merge Sort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = (int) runMergeSort(i);      
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }     
      
        StdDraw.setPenColor(Color.red);
        StdDraw.text(80,150,"Quick Sort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = (int) runQuickSort(i);      
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }           
    }
    
}