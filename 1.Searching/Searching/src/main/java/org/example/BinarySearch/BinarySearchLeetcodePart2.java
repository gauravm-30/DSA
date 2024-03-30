package org.example.BinarySearch;

public class BinarySearchLeetcodePart2 {

//   1. Peak index in mountain array/bitonic array
//    2. Given an integer array nums , find a peak element and return its index.
//      if the array contains multiple peaks , then return the index of any of the peaks.

    public static int peakIndexInMountainArray(int[] mountainArr){
        int startIndex=0;
        int endIndex=mountainArr.length-1;

        //here we haven't used startIndex<=endIndex because if both are equal and
        //the array is ascending order then at last start=mid=endIndex will pont to last
        //element of the  array and at that time we cannot apply the check of midIndex and midIndex+1
        while(startIndex<endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(mountainArr[midIndex]>mountainArr[midIndex+1]){
                //you are in dec part of the array
                //this may be the ans but look at the  left
                //that's why endIndex != midIndex -1;
                endIndex=midIndex;
            }
            else{
                startIndex=midIndex+1;
            }
        }
        return startIndex;
    }

    //Find the target element in mountain array  and return its index
    // if not found then return -1 ;
    public static int findInMountainArray(int[] mountainArr, int target){
    int peakElementIndex=peakIndexInMountainArray(mountainArr);
    int firstTry=binarySearchOrderAgnostic(mountainArr,target,0,peakElementIndex);
    if(firstTry!=-1){
        return firstTry;
    }
    return binarySearchOrderAgnostic(mountainArr, target, peakElementIndex+1,mountainArr.length-1);
    }

    private static int binarySearchOrderAgnostic(int[] arr,int target, int startIndex, int endIndex) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        /*
         * to detect whether the array is ascending sorted or descending sorted
         * best possible values to select are first and last
         * for ex {3,3,3,3,3,5,6} here first and last value should be selected to detect the order
         * */
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
