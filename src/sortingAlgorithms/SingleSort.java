package sortingAlgorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SingleSort {
			private static int count;
		   private static int n = 10000;
		   private static int[] a = new int[n];
		   private static int[] b = new int[n];
		   private static String[] names = new String[15];
		   
		   public static void main(String args[]) {
			   
			   long start = System.nanoTime();
			     
			  
			   int i = 10000;
			   
			   for (int j=0;j<i;j++){
					   
				   for (int k=0;k<n;k++){
				   		a[k] = (int)(Math.random()*n);
				   }
					   //printArray(n);


					   mergeSort(0,n-1);
					   //System.out.println("merging");
					   
					   //printArray(n);
					   
					   //quickSort(0,n-1);
			   }

				   System.out.println(count/i);
				   long time = System.nanoTime() - start;
				   System.out.printf("Each run took an average of %,d ns%n", time/i);

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

