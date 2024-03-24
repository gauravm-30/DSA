package org.example.LinearSearch;

public class LS_InRange {
    public static void performLinearSearchOnIntInRange(){
        int[] arr={-5,5,-3,4,0,1,9,3};
        int index=linearSearchIntInRange_V1(arr,4,1,3);
        System.out.println("Linear Search Index In Range: " + index);
    }
    //search the target in range  and return the index of the element
    private static int linearSearchIntInRange_V1(int[] arr, int target, int start, int end) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        for (int i = start; i <=end; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
