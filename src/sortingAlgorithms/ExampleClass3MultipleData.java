package sortingAlgorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExampleClass3MultipleData {
	private static int count;
	   private static int n,input;
	   private static int[] a;
	   private static int[] b;
	   private static String[] names = new String[15];
	   

	   public static void main(String args[]) {
		   /*n=2000;
		   a = new int[n];
		   a[k]=(int)(Math.random()*n);
		   b = new int[n];
		   printArray(n);*/
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("How many data points do you want?");
		   input = sc.nextInt();
		   
		   //for (int i = 0;i<10;i++){
		   int i = 0;
			   //System.out.println(i);
			   n = 2000 * (1 + i/2);
			   for (int j=0;j<input;j++){
				  /* a = new int[n];
				   b = new int[n];
				   for(int k=0;k<n;k++){
					   a[k]=(int)(Math.random()*n);*/
				   try{
			           a = FileReaderWriter.readFile("2000.txt");
			        } catch (FileNotFoundException e) {
			           e.printStackTrace();
			        } catch (IOException e) {
			           e.printStackTrace();
			        }
				   
				   //printArray(n);

			   if (i%2==1){
				   mergeSort(0,n-1);
				   System.out.println("merging");
				   //count += count;
			   }
				   
			   else{
				   quickSort(0,n-1);
				   System.out.println("Quickly");
				   //count += count;
			   }
			   }
			   //printArray(n);
			   System.out.println(i + " average = " + count/input);
			   count = 0;
		   //}
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

	}
