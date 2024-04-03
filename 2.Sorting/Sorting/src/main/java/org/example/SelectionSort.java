package org.example;

import java.util.Arrays;

public class SelectionSort {

    public static void performSelectionSort(){
        int[] arr = {6,2,1,7,0,8,10};
        int[] arr2 = {1,2,3,4,5,6,7};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Selection sort means select the element and put it at its correct index.
    //This can be done in two ways , either select the largest element and swap with the correct index
    //or select the smallest element and swap with the correct index
    //best case when array is sorted TC=O(N^2)
    //when the array  is reversed sorted TC=O(N^2)
    //As the size of array is growing, the number of comparisons is also growing very fast i.e. by n^2.
    //Not a stable algorithm as it may change the relative position of the element with same value
    //find the maximum element at every pass and then place it on the correct index.
    public static void selectionSort(int[] arr){
        for(int pass = 0; pass < arr.length; pass++) {
            int lastIndex=(arr.length-1)-pass;
            int maxIndex=getMaxIndex(arr,0,lastIndex);
                    swapValues(arr,maxIndex,lastIndex);
        }
    }

    private static int getMaxIndex(int[] arr, int startIndex, int lastIndex) {
       int maxIndex=startIndex;
       for(int j = startIndex; j <=lastIndex; j++) {
           if(arr[j]>arr[maxIndex]){
               maxIndex=j;
           }
       }
       return maxIndex;
    }

    private static void swapValues(int[] arr, int current, int next) {
        int temp=arr[current];
        arr[current]=arr[next];
        arr[next]=temp;
    }
}
