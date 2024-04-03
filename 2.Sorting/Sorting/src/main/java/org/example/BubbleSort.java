package org.example;

import java.util.Arrays;

public class BubbleSort {

    public static void performBubbleSort(){
        int[] arr = {6,2,1,7,0,8,10};
        int[] arr2 = {1,2,3,4,5,6,7};

        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    //1.If no swapped is performed , it means array is already sorted.
    //2.We can make it to sort in asc or desc order
    //3.After every pass, largest/smallest element will be at the end/start based on the type of sort we are performing
    //4.Used for small datasets.
    //best case when array is sorted TC=O(N)
    //when the array  is reversed soted TC=O(N^2)
    //As the size of array is growing, the number of comparisons is also growing very fast i.e. by n^2.
    //stable algorithm as it don't change the relative position of the element with same value
    //Adaptive in nature i.e. if array is already sorted to some extent then it must take less time .

    public static void bubbleSort(int[] arr){
        for(int pass = 0; pass < arr.length-1; pass++) {
            boolean isSwapped=false;
      for (int i = 0; i < arr.length-1-pass; i++) {
          if(arr[i]>arr[i+1]){
              isSwapped=true;
              swapValues(arr,i,i+1);
          }
      }
      if(!isSwapped){
          break;
      }
        }
    }

    private static void swapValues(int[] arr, int current, int next) {
        int temp=arr[current];
        arr[current]=arr[next];
        arr[next]=temp;
    }
}
