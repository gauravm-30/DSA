package org.example;

import java.util.Arrays;

public class InsertionSort {
    public static void performInsertionSort(){
        int[] arr = {6,2,1,7,0,8,10};
        int[] arr2 = {1,2,3,4,5,6,7};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // It considers the first element to be sorted
    //now it pick elements one by one from the rest of the element in array
    //compare with currently sorted array and place it into the correct index
    //best case O(N) if array is already sorted
    //worst case O(N^2)
    //Adaptive in nature i.e. if array is already sorted to some extent then it must take less time .

    //Used for smaller values of N, works  good if array is partially sorted That's why takes part in hybrid sorting algorithms .

    private static void insertionSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) { //each pass
            boolean isSwapped=false;
            for(int j = i; j>0; j--) {
                if(arr[j-1]>arr[j]){
                    isSwapped=true;
                    swapValues(arr,j,j-1);
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    private static void swapValues(int[] arr, int currentIndex, int nextIndex) {
        int temp=arr[currentIndex];
        arr[currentIndex]= arr[nextIndex];
        arr[nextIndex]=temp;
    }
}
