package org.example.BinarySearch;

public class BinarySearchLeetcodePart1 {

 /*   public static void performLeetCodeProblems(){

        int[] sortedAndNonDuplicateArrAsc={-5,-3,4,9,10,15,18};
        int indexAsc=binarySearchAsc(sortedAndNonDuplicateArrAsc,-3);
        int[] sortedAndNonDuplicateArrDesc={18,15,10,9,4,-3,-5};
        int indexDesc=binarySearchDesc(sortedAndNonDuplicateArrDesc,-2);

        System.out.println("Binary Search Index Asc: " + indexAsc);
        System.out.println("Binary Search Index Desc: " + indexDesc);
    }*/


    /*Find the smallest letter greater than target */
/*Given that array letters are in non-decreasing order*/
    private static char nextGreatestChar(char[] letters, char target){
        //In leetcode we need to avoid this condition
        if(letters==null || letters.length==0){
            return Character.MIN_VALUE;
        }
        int startIndex=0;
        int endIndex=letters.length-1;

        while (startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;

            if(target<letters[midIndex]){
                endIndex=midIndex-1;
            }else {
                //when target is greater than or equal to !!
                startIndex=midIndex+1;
            }
        }
        return letters[startIndex% letters.length];

    }

    /*Find the greatest letter smaller than target */
    /*Given that array letters are in non-decreasing order*/
    private static char prevSmallestChar(char[] letters, char target){
        //In leetcode we need to avoid this condition
        if(letters==null || letters.length==0){
            return Character.MIN_VALUE;
        }
        int startIndex=0;
        int endIndex=letters.length-1;

        while (startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
          // when target is smaller than or equal to midValue
            if(target<=letters[midIndex]){
                endIndex=midIndex-1;
            }else {
                //when target is greater than
                startIndex=midIndex+1;
            }
        }
        return letters[startIndex% letters.length];

    }
    /*Find the first and last position of the element in sorted array*/

    /*if target not found return [-1,-1]*/

    /*First find first occurrence of the element
    * if found, find the last occurrence of the element */
    private static int[] searchRange(int[] nums, int target){
        int[] ans = new int[]{-1,-1};
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        ans[0]=searchOccurrence(nums,target,true);
        if(ans[0]!=-1) {
            ans[1]= searchOccurrence(nums, target, false);
        }
        return ans;
    }
    
    public static int searchOccurrence(int[] nums,int target,boolean findStartIndex){
        int ans=-1;
        int startIndex=0;
        int endIndex=nums.length-1;
        while(startIndex<=endIndex){
            int midIndex= startIndex+ (endIndex-startIndex)/2;
            if(nums[midIndex]==target){
                //potential answer found
                ans=midIndex;
                if(findStartIndex){
                    endIndex=midIndex-1;
                }else {
                    startIndex=midIndex+1;
                }

            } else if (nums[midIndex]<target) {
                endIndex=midIndex-1;
            }
            else {
                startIndex=midIndex+1;
            }
        }
        return ans;
    }


    /* Find the position of element in a sorted array of infinite numbers
    * Now imagine the array is infinite means you can't use the arr.length function
    * Since array is infinite there will be no question of arrayIndexOutOfBoundException
    * We don't need to care about the OutOfBoundException
    *
    * Till now, we are reducing the search space every time if we don't  find the target element
    * Now we will increase the search space every time ,if we don't find the element
    * bottom-up approach
     *
     * */
    static int findElementPosInInfiniteArray(int[] infiniteArr, int target){
        //initially we will put start and end as 0 and  1
        // and then we will double the search space if not found
        int startIndex = 0;
        int endIndex = 1;
//if target element is greater than the endIndex then no need to check the in
//        in that range and update the range.
        while (target>infiniteArr[endIndex]){
            int newStart=endIndex+1;
            endIndex= endIndex+ 2*(endIndex-(startIndex-1));
            startIndex=newStart;
        }

        return binarSearchInInfiniteArr(infiniteArr,target,startIndex,endIndex);

    }

    private static int binarSearchInInfiniteArr(int[] infiniteArr,int target, int startIndex, int endIndex) {
        while(startIndex<=endIndex){
            int midIndex=startIndex+(endIndex-startIndex)/2;
            if(target==infiniteArr[midIndex]){
                return midIndex;
            } else if (target<infiniteArr[midIndex]) {
                endIndex=midIndex-1;
            }else {
                startIndex=midIndex+1;
            }
        }
        return -1;
    }

}
