package org.example.LinearSearch;

public class LS_Int {
    public static void performLinearSearchOnInt(){
        int[] arr={-5,5,-3,4,0,1,9,3};
        int index=linearSearchInt_V1(arr,4);
        int element=linearSearchInt_V2(arr,10);
        boolean isElementPresent=linearSearchInt_V3(arr,4);
        System.out.println("Linear Search Index: " + index);
        System.out.println("Linear Search Value : " + element);
        System.out.println("Linear Search isElementPresent: " + isElementPresent);
    }



    //search the target and return the index of the element
    private static int linearSearchInt_V1(int[] arr, int target) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    //search the target and return the element
    private static int linearSearchInt_V2(int[] arr, int target) {
        if(arr == null){
            //here wo don't need to check the array length to 0.
            //ideally we should be throwing exception here
            return Integer.MAX_VALUE;
        }
        for (int element:arr) {
            if(element==target){
                return element;
            }
        }
        return Integer.MAX_VALUE;
    }

    //search the target and return the true or false
    private static boolean linearSearchInt_V3(int[] arr, int target) {
        if(arr == null){
            //here wo don't need to check the array length to 0.
            //ideally we should be throwing exception here
            return false;
        }
        for (int element:arr) {
            if(element==target){
                return true;
            }
        }
        return false;
    }

}
