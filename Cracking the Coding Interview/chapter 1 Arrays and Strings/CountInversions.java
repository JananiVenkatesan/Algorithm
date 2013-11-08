/*
  give a list of integers, count the number of the total inversions

  E.g.
   0 4 2 7 1 3

   4 > 2
   4 > 1
   4 > 3 
   2 > 1
   7 > 1
   7 > 3

   So total number of inversions is 6
*/

import java.util.*;
import java.io.*;

public class CountInversions{
  public static void main(String[] args) throws IOException{
      int[] arr = new int[100000];
      
      BufferedReader br = new BufferedReader(new FileReader("IntegerArray.txt"));

      int i=0;
      String line = null;
      while((line=br.readLine())!=null){
        arr[i] = Integer.parseInt(line);
        i++;
      }

      for(int j=0; j<100000;j++)
        System.out.println(arr[j]);

      DArray da = new DArray(arr);

      da.mergeSort();
  }
}

class DArray{
  private int[] a;
  private int nElems;

  public DArray(int[] array){
      nElems = array.length;
      a = new int[nElems];

      for(int i=0; i<nElems; i++)
          a[i] = array[i];
  }

  public void display(){
      for(int i=0; i<nElems; i++)
          System.out.print(a[i]+" ");

      System.out.println("");
  }

  public void mergeSort(){
      int[] temp = new int[nElems];

      long inv_count = recMergeSort(temp,0,nElems-1);
      System.out.println(inv_count);
  }

  private long recMergeSort(int[] temp, int lowerBound, int upperBound){
      long inv_count = 0;

      if(lowerBound == upperBound)
          return 0;
      else{
          int mid = (lowerBound + upperBound)/2;

          inv_count+=recMergeSort(temp, lowerBound, mid);
          inv_count+=recMergeSort(temp, mid+1, upperBound);

          inv_count+=merge(temp, lowerBound, mid+1, upperBound);
      }

      return inv_count;
  }

  private long merge(int[] temp, int lowPtr, int highPtr, int upperBound){
      int mid = highPtr - 1;
      int lowerBound = lowPtr;

      int n = upperBound - lowerBound + 1;
      long inv_count = 0;

      int j=0;
      while(lowPtr<=mid && highPtr<=upperBound){
          if(a[lowPtr]<=a[highPtr]){
              temp[j++] = a[lowPtr++];
          }
          else{
              temp[j++] = a[highPtr++];
              inv_count+=mid - lowPtr + 1;
              /*
             if a[lowPtr]>a[highPtr], then a[lowPtr] is larger than 
             all the rest elements in a[highPtr] because the two arrays 
             are already sorted
             */
          }
      }

      while(lowPtr<=mid)
          temp[j++] = a[lowPtr++];

      while(highPtr<=upperBound)
          temp[j++] = a[highPtr++];

      for(j=0; j<n; j++)
          a[lowerBound+j] = temp[j];

      return inv_count;
  }
}