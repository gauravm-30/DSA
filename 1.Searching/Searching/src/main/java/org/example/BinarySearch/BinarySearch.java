package org.example.BinarySearch;

public class BinarySearch {
    public static void performBinarySearch(){
        int[] sortedAndNonDuplicateArr={-5,-3,4,9,10,15,18};
        int index=binarySearch(sortedAndNonDuplicateArr,-3);
        System.out.println("Binary Search Index: " + index);
    }

    private static int binarySearch(int[] arr, int target) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }

        int startIndex=0;
        int endIndex=arr.length-1;
        while(startIndex<=endIndex){
            int midIndex= startIndex+ (endIndex-startIndex)/2;
            if(arr[midIndex]==target){
                return midIndex;
            } else if (arr[midIndex]<target) {
                startIndex=midIndex+1;
            }
            else {
                endIndex=midIndex-1;
            }
        }
        return -1;
    }
}
