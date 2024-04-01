package org.example.BinarySearch;

public class BinarySearchLeetcodePart3 {

    //Search the target element index in rotated sorted array without the duplicate keys
    //this will not work in case of duplicate values
    public static int searchInRotatedArray(int[] arr, int target){
        int pivotIndex=findPivotWithoutDuplicatesIn(arr);
        //if pivot is not found then it means array is not rotated.
        if(pivotIndex==-1){
            //just do a normal binary search
          return binarySearchOrderAgnostic(arr,target,0,arr.length-1);
        }
        if(arr[pivotIndex]==target){
            return pivotIndex;
        }
        if(target>=arr[0]){
          return binarySearchOrderAgnostic(arr,target,0,pivotIndex-1);
        }

        return binarySearchOrderAgnostic(arr,target,pivotIndex+1,arr.length-1);
    }

    //we know that the array is sorted and rotated and with distinct numbers
    public static int findPivotWithoutDuplicatesIn(int[] arr){
        int startIndex=0;
        int endIndex=arr.length-1;

        while (startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            //4 cases
            if(midIndex<endIndex && arr[midIndex]>arr[midIndex+1] ){
                return midIndex;
            }
            if(midIndex>startIndex && arr[midIndex]<arr[midIndex-1]){
                return midIndex-1;
            }
            if(arr[midIndex]<=arr[startIndex]){
                endIndex=midIndex-1;
            }else {
                startIndex=midIndex+1;
            }
        }
        return -1;
    }

    public static int findPivotWithDuplicatesIn(int[] arr){
        int startIndex=0;
        int endIndex=arr.length-1;

        while (startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            //4 cases
            if(midIndex<endIndex && arr[midIndex]>arr[midIndex+1] ){
                return midIndex;
            }
            if(midIndex>startIndex && arr[midIndex]<arr[midIndex-1]){
                return midIndex-1;
            }
            //if the elements at the middle, start and end are equal then just skip the duplicates

          if(arr[midIndex]==arr[startIndex] && arr[midIndex]==arr[endIndex]){
              //skip the duplicates
              //What if these elements at start and end were the pivot ??
              //check if start is pivot
              if(arr[startIndex]>arr[startIndex+1]){
                  return startIndex;
              }
              startIndex++;
              //check whether end is pivot or not ?
              if(arr[endIndex]<arr[endIndex-1]){
                  return endIndex-1;
              }
              endIndex--;
          }
          //if left is sorted , then pivot should be in right
          else if(arr[startIndex]<arr[midIndex] || (arr[startIndex]==arr[midIndex] && arr[endIndex]<arr[midIndex]) ){
                startIndex=midIndex+1;
          }else {
              endIndex=midIndex-1;
          }
        }
        return -1;
    }

    //Find number of rotation count in rotated sorted array !!
    //find pivot element index
    //add +1 into that index
    //here is the answer
    public  static int findRotationCounts(int[] arr){
//        int pivotIndex=findPivotWithDuplicatesIn(arr);
//        if(pivotIndex==-1){
//            return 0;
//        }
//        return pivotIndex+1;
//        OR

        return findPivotWithDuplicatesIn(arr)+1;
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

//To do: split array largest sum

}
