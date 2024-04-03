package org.example;

import java.util.Arrays;

public class CyclicSort {
    //When given numbers are from range 1,N => apply cyclic sort


    public static void performCyclicSort(){
        //Numbers are in between 1 to N, so we can use the cyclic sort
        int[] arr = {6,2,1,3,5,4,7};
        int[] arr2 = {1,2,3,4,5,6,7};

        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //it is index based sorting ,uses index of the element
    private static void cyclicSort(int[] arr) {
        int i=0;
        while(i < arr.length) {
            int correctIndex=arr[i]-1;       //Note : numbers must be between 1 to N otherwise it fails
            if(arr[i]!=arr[correctIndex]){    // swap until the  current index  will have the correct element.
                swapValues(arr,i,correctIndex);
            }else {
                i++;
            }

        }
    }

    private static void swapValues(int[] arr, int currentIndex, int nextIndex) {
        int temp=arr[currentIndex];
        arr[currentIndex]=arr[nextIndex];
        arr[nextIndex]=temp;
    }
}
