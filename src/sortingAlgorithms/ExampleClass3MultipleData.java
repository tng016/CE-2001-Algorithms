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
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("How many data points do you want?");
		   input = sc.nextInt();
		   
		   loadNames();
		   for (int i = 0;i<30;i++){
			   n = 2000 * (1+ i/6);
			   if((i/2)%3==1)
				   for(int k=0;k<n;k++)
					   a[k]=k;
			   else if ((i/2)%3==2)
				   for(int k=0;k<n;k++)
					   a[k]=n-k;
			   for (int j=0;j<input;j++){
			   if(1%3==0)
				   for(int k=0;k<n;k++)
					   a[k]=(int)Math.random()*n;
			   b = new int[n];

			   if (i%2==1){
				   mergeSort(0,n-1);
				   count += count;
			   }
				   
			   else{
				   quickSort(0,n-1);
				   count += count;
			   }
			   System.out.println(names[i] + " " + count/input);
			   count = 0;
		   }
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
