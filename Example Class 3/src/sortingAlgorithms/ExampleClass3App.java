package sortingAlgorithms;
import java.io.*;
import java.util.Scanner;
public class ExampleClass3App {
   private static int count;
   private static long time, totaltime;
   private static int n;
   private static int rep;
   private static int[] a;
   private static int[] b;
   private static String[] names = new String[15];

   public static void main(String args[]) {
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.println("How many repetitions do you want?");
	   rep = sc.nextInt();
	   sc.close();
	   
	   //load the file names into an array
	   loadNames();
	   
	   //i refers to the number sorting tests we are doing 
	   //(2 types of sort * 3 types of data * 5 data sizes)
	   for (int i = 0;i<30;i++){
		   n = 2000 * (1+ i/6);//obtain data size from i
		   a = new int[n];
		   b = new int[n];
		   
		   //perform sort (rep) number of times
		   for (int j=0;j<rep;j++){
			   //load data set into array a
			   try{
		           a = FileReaderWriter.readFile(names[i/2]);
		        } catch (FileNotFoundException e) {
		           e.printStackTrace();
		        } catch (IOException e) {
		           e.printStackTrace();
		        }
			   
			   //star stopwatch
			   long start = System.nanoTime();
			   
			   //odd i perform mergesort, even perform quicksort
			   if (i%2==1){
				   mergeSort(0,n-1);
			   }
				   
			   else{
				   quickSort(0,n-1);
			   }
			   
			   //stop stopwatch
			   time = System.nanoTime() - start;
			   
			   //add up timings
			   totaltime += time;
		   }
		   
		   if (i%2==1)
			   System.out.println("# of Comparisions for Mergesort of " + names[i/2] + " = "+ count/rep);
		   else 
			   System.out.println("# of Comparisions for Quicksort of " + names[i/2] + " = "+ count/rep);
		   System.out.printf("Each run took an average of %,d ns%n", totaltime/rep);
		   //reset count & time
		   totaltime = 0;
		   count = 0;
	   }
   }
   
   public static void printArray(int n){
		for (int k=0;k<n;k++){
			System.out.println(a[k]);
		}
	}
   public static void mergeSort(int low, int high){
      if (low<high){
         int mid = (high+low)/2;
         mergeSort(low,mid);
         mergeSort(mid+1,high);
         merge(low,mid,high);
      }
   }

   private static void merge(int low, int mid, int high){
      int l1,l2,i;
      for(l1 = low, l2 = mid + 1, i = low; l1<=mid && l2<=high; i++){
    	  count++;
    	  if(a[l1]<= a[l2]){
            b[i]=a[l1++];
    	  }
         else{
            b[i]=a[l2++];
         }
      }

      while(l1<=mid)
         b[i++] = a[l1++];

      while(l2<=high)
         b[i++] = a[l2++];

      for(i=low;i<=high;i++)
         a[i] = b[i];
   }

   public static void quickSort(int low, int high){
      if (low<high){
         int pivot_pos = partition(low,high);
         quickSort(low,pivot_pos-1);
         quickSort(pivot_pos+1,high);
      }
   }

   private static int partition(int low, int high){
      int last_small, pivot, i;
      int mid = (high+low)/2;
      swap(low,mid);
      pivot = a[low];
      last_small=low;
      for(i=low+1; i<=high; i++){
    	  count++;
    	  if (a[i]<pivot){
            swap(++last_small,i);
         }
      }
      swap(low,last_small);
      return last_small;
   }

   public static void swap(int b, int c){
      int temp = a[b];
      a[b] = a[c];
      a[c] = temp;
   }

   public static void loadNames(){
	      names[0] = "2000.txt";
	      names[1] = "2000Ordered.txt";
	      names[2] = "2000Reverse.txt";
	      names[3] = "4000.txt";
	      names[4] = "4000Ordered.txt";
	      names[5] = "4000Reverse.txt";
	      names[6] = "6000.txt";
	      names[7] = "6000Ordered.txt";
	      names[8] = "6000Reverse.txt";
	      names[9] = "8000.txt";
	      names[10] = "8000Ordered.txt";
	      names[11] = "8000Reverse.txt";
	      names[12] = "10000.txt";
	      names[13] = "10000Ordered.txt";
	      names[14] = "10000Reverse.txt";
	   }

}
