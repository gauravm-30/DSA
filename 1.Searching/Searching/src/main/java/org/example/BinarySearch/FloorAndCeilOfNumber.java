package org.example.BinarySearch;

public class FloorAndCeilOfNumber {
    public static void performFloorAndCeilOperation(){

        int[] sortedAndNonDuplicateArrAsc={-5,-3,4,9,10,15,18};
        int ceilOfNumber=getCeilOfNumberForAscArray(sortedAndNonDuplicateArrAsc,20);
        int[] sortedAndNonDuplicateArrDesc={18,15,10,9,4,-3,-5};
//        int indexDesc=binarySearchDesc(sortedAndNonDuplicateArrDesc,-2);

        System.out.println("CeilOfNumber: " + ceilOfNumber);
//        System.out.println("Binary Search Index Desc: " + indexDesc);
    }

    /*Ceil of the number :
    * Find the index of  smallest number that is greater than or equal to target element
    * Can work on asc duplicate elements*/
    private static int getCeilOfNumberForAscArray(int[] arr, int target){
        if(arr==null ||  arr.length==0){
            //ideally exception should be thrown here
            return -1;
        }
        int startIndex=0;
        int endIndex= arr.length-1;
        //what if the target element is greater than  greatest element of the asc sorted array.
        if(target>arr[endIndex]){
            return -1;
        }

        while(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(target==arr[midIndex]){
                return midIndex;
            }
            else if(target>arr[midIndex]){
                startIndex=midIndex+1;
            }else {
                endIndex=midIndex-1;
            }
        }
        return startIndex;
    }

    private static int getCeilOfNumberForDescArray(int[] arr, int target){
        if(arr==null ||  arr.length==0){
            //ideally exception should be thrown here
            return -1;
        }
        int startIndex=0;
        int endIndex= arr.length-1;
        //what if the target element is greater than  greatest element of the asc sorted array.
        if(target>arr[startIndex]){
            return -1;
        }

        while(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(target==arr[midIndex]){
                return midIndex;
            }
            else if(target>arr[midIndex]){
                endIndex=midIndex-1;
            }else {
               startIndex=midIndex+1;
            }
        }
        return endIndex;
    }
    /*Floor  of the number :
     * Find the index of  greatest number that is smaller than or equal to target element
     * Can work on asc duplicate elements*/

    private static int getFloorOfNumberForAscArray(int[] arr, int target){
        if(arr==null ||  arr.length==0){
            //ideally exception should be thrown here
            return Integer.MIN_VALUE;
        }
        int startIndex=0;
        int endIndex= arr.length-1;
//        what if the target element is smaller than the smallest element of the asc sorted array
        if(target<arr[0]){
            return -1;
        }
        while(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(target==arr[midIndex]){
                return midIndex;
            }
            else if(target>arr[midIndex]){
                startIndex=midIndex+1;
            }else {
                endIndex=midIndex-1;
            }
        }
        return endIndex;
    }

    private static int getFloorOfNumberForDescArray(int[] arr, int target){
        if(arr==null ||  arr.length==0){
            //ideally exception should be thrown here
            return Integer.MIN_VALUE;
        }
        int startIndex=0;
        int endIndex= arr.length-1;
// what if the target element is smaller than the smallest element of the asc sorted array
        if(target<arr[arr.length-1]){
            return -1;
        }
        while(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(target==arr[midIndex]){
                return midIndex;
            }
            else if(target>arr[midIndex]){
                endIndex=midIndex-1;
            }else {
                startIndex=midIndex+1;
            }
        }
        return startIndex;
    }
}
