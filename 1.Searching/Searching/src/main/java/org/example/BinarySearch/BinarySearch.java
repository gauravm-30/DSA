package org.example.BinarySearch;

public class BinarySearch {
    public static void performBinarySearch(){
        /*
        * Why non-duplicate ?
        * it will work on duplicate elements also but you cannot expect the
        * same index if the number of repeated numbers increase.
        * */
        int[] sortedAndNonDuplicateArrAsc={-5,-3,4,9,10,15,18};
        int indexAsc=binarySearchAsc(sortedAndNonDuplicateArrAsc,-3);
        int[] sortedAndNonDuplicateArrDesc={18,15,10,9,4,-3,-5};
        int indexDesc=binarySearchDesc(sortedAndNonDuplicateArrDesc,-2);

        System.out.println("Binary Search Index Asc: " + indexAsc);
        System.out.println("Binary Search Index Desc: " + indexDesc);
    }

    //Every time when we search and didn't get the require element we basically reduce the search space
    //This binary search is for  ascending order.

    private static int binarySearchAsc(int[] arr, int target) {
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

    //34,30,25,20,15,10
    private static int binarySearchDesc(int[] arr, int target) {
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
                endIndex=midIndex-1;
            }
            else {
                startIndex=midIndex+1;
            }
        }
        return -1;
    }

    //what if you only know that array is sorted but don't know in which order
    //for this we use order agnostic search
    private static int binarySearchOrderAgnostic(int[] arr, int target) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        /*
        * to detect whether the array is ascending sorted or descending sorted
        * best possible values to select are first and last
        * for ex {3,3,3,3,3,5,6} here first and last value should be selected to detect the order
        * */
        int startIndex=0;
        int endIndex=arr.length-1;
        boolean isAscending=arr[startIndex]>arr[endIndex];

        while(startIndex<=endIndex){
            int midIndex= startIndex+ (endIndex-startIndex)/2;
            if(arr[midIndex]==target){
                return midIndex;
            } else if (arr[midIndex]<target) {
                if(isAscending){
                    startIndex=midIndex+1;
                }
                else {
                    endIndex=midIndex-1;
                }
            }
            else {
                if(isAscending){
                    endIndex=midIndex-1;
                }
                else {
                    startIndex=midIndex+1;
                }
            }
        }
        return -1;
    }
}
