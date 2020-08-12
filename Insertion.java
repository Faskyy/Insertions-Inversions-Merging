/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

// Insertion class provides static methods for sorting an
// array of integers using insertion sort.
public class Insertion {

   // This class should not be instantiated.
   private Insertion() {
   }

   // Rearranges the array in ascending order.
   public static void sort(int[] a) {
      
   // YOUR CODE HERE
   // Big O runtime is O(n^2)
	   
   int n = a.length;
   for (int i = 1; i < n; i++) {
	   int current = a[i];
	   int j = i - 1;
		   
		  while (j>=0 && a[j] > current){
			  a[j + 1] = a[j];
			  j--;
		  }	
		  
		  a[j + 1] = current;
	  }	   
  }

   // exchange a[i] and a[j] -- a helper method
   private static void exch(int[] a, int i, int j) {
      int swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }


   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.println(a[i]);
      }
   }

   //insertion sorts merges the array step by step so even halfway through the sort the array is sorted, 
   //but merge sort has to be completed
   
   // Reads in a sequence of integers from a file; insertion sorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      In in = new In("100Kints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      
      final long startTime = System.currentTimeMillis();
      Insertion.sort(a);
      final long endTime = System.currentTimeMillis();
      show(a);
      System.out.println("\nInsertion sort time: " + (endTime - startTime) + " ms");
      
   }
}
