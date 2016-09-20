import java.util.Arrays;

public class Sorting {
  
  
    public static int counter = 0; 
    
    
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    
    public static void insertionSort(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(A[j], A[j-1]); j--) {
                swap(A, j, j-1);
            }
        }
    } 

    
    public static void selectionSort( int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(A[j], A[min])) min = j;
            }
            swap(A, i, min);
            
        }
        
    }
    
    
    public static void mergeSort(int[] A) {
        int[] aux = new int[A.length];
        msHelper(A, aux, 0, A.length-1);
        
    }
    
    
    private static void merge(int[] A, int[] aux, int lo, int mid, int hi) {
     
        for (int k = lo; k <= hi; k++) {
            aux[k] = A[k]; 
        }
        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              A[k] = aux[j++];   // this copying is unnecessary
            else if (j > hi)               A[k] = aux[i++];
            else if (less(aux[j], aux[i])) A[k] = aux[j++];
            else                           A[k] = aux[i++];
        }
        
        
    }

    
    private static void msHelper(int[] A, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        msHelper(A, aux, lo, mid);
        msHelper(A, aux, mid + 1, hi);
        merge(A, aux, lo, mid, hi);
    }

    
    public static void quickSort(int[] A) {   
        qsHelper(A, 0, A.length - 1);
    }
    
    
    private static void qsHelper(int[] A, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(A, lo, hi);
        qsHelper(A, lo, j-1);
        qsHelper(A, j+1, hi);
        
    }

    
    private static int partition(int[] A, int lo, int hi) {
        int i = lo+1;
        int j = hi;
        int v = A[lo];
        while (i <= j) { 
            while( i < A.length && less(A[i], v) )
                ++i;
            while( less(v, A[j]) )
                --j;
            if(i > j)
                break;
            else {
                swap(A,i,j);
                ++i;
                --j;
            }
        } 
        swap(A, lo, j);        
        return j;
    }

    
    private static boolean less(int v, int w) {
      ++counter;      
      return v < w; 
    }
  
    public static void main(String[] args){
        int[] A = {10,9,8,7,6,5,4,3,2,1};
        int[] B = {10,9,8,7,6,5,4,3,2,1};
        int[] C = {10,9,8,7,6,5,4,3,2,1};
        int[] D = {10,9,8,7,6,5,4,3,2,1};
        counter = 0;
        System.out.println("\nA before: "+ Arrays.toString(A));
        selectionSort(A);
        System.out.println("A after : "+ Arrays.toString(A));        
        System.out.println("\nselectionSort(A) took " + counter + " comparisons.");

        counter = 0;
        System.out.println("\nB before: "+ Arrays.toString(B));        
        insertionSort(B);
        System.out.println("B after : "+ Arrays.toString(B));         
        System.out.println("\ninsertionSort(B) took " + counter + " comparisons.");   
        
        counter = 0;
        System.out.println("\nC before: "+ Arrays.toString(C));           
        mergeSort(C);
        System.out.println("C after : "+ Arrays.toString(C));            
        System.out.println("\nmergeSort(C) took " + counter + " comparisons.");

        counter = 0;
        System.out.println("\nD before: "+ Arrays.toString(D));         
        quickSort(D);
        System.out.println("D after : "+ Arrays.toString(D));            
        System.out.println("\nquickSort(D) took " + counter + " comparisons.");         
    }
}



