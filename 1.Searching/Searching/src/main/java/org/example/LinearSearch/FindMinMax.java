package org.example.LinearSearch;

public class FindMinMax {

    public static void findMinMaxOnInt(){
        int[] arr={-5,5,-3,4,0,1,9,3};
        System.out.println("Min element in array: "+ findMin(arr));
        System.out.println("Max element in array: "+ findMax(arr));
    }
// find maximum element in array
    private static int findMax(int[] arr) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return Integer.MAX_VALUE;
        }

        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //find minimum element in array
    private static int findMin(int[] arr) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return Integer.MIN_VALUE;
        }

        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
               min=arr[i];
            }
        }
        return min;
    }


}
