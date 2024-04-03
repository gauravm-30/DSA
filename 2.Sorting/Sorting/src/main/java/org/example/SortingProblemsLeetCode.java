package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingProblemsLeetCode {

    public static void performCyclicSort(){
        int[] arr = {6,2,1,3,5,4,7,0};

        int[] nums = {4,3,2,7,8,2,3,1};

       int missingNum=findMissingNumber(arr);
       List<Integer> missingIntegers=findListOfMissingNumbers(nums);
        System.out.println(Arrays.toString(arr));
        System.out.println(missingNum);
    missingIntegers.forEach(x -> System.out.println(x));
    }

    //Problem 1 Find missing number from array [0,n]
    //if n =3 then ideally it should have  [0,1,2,3]
    //but [3,0,1]
    //when n=5 [5,0,1,2,4]

    private static int findMissingNumber(int[] arr) {
        int i=0;
        while(i<arr.length) {
            int correctIndex= arr[i];
            //check element at index i will be less than the length and
            // then check the whether element is at correct index or not !!
            if(arr[i]<arr.length && arr[i]!=arr[correctIndex]){
                 swapValues(arr,i,correctIndex);    // swap until the  current index  will have the correct element.
            }else {
                i++;
            }
        }
        //now array has been sorted !
        //check the missing number
        for(int index = 0; index < arr.length; index++) {
            if(arr[index]!=index){
                return index;
            }
        }
//case 2 : when the last element is not present
        return arr.length;
    }

    //Find list of number that are missing from [1,n]
    private static List<Integer> findListOfMissingNumbers(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctIndex= nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swapValues(nums,i,correctIndex);
            }else{
                i++;
            }
        }
        List<Integer> missingIntegers=new ArrayList<>();
        for(int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                missingIntegers.add(j+1);
            }
        }
        return missingIntegers;
    }

    //find the only duplicate elements containing n+1 integers where each integer is in range [1,n] inclusive
    public static int findDuplicateNumberV1(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i]!=i+1){  // if not equals then two cases arise ,either the element ins duplicate or is unique
                int correctIndex=nums[i]-1;
                if (nums[i]!=nums[correctIndex]){
                    swapValues(nums,i,correctIndex);
                }else {
                    //means it is duplicate element
                   return  nums[i];
                }
            }else {
                i++;
            }
        }
        return -1;
    }

    //find the only duplicate elements containing n+1 integers where each integer is in range [1,n] inclusive
    public static int findDuplicateNumberV2(int[] nums){
        int i=0;
        while(i<nums.length){
                int correctIndex=nums[i]-1;
                if (nums[i]!=nums[correctIndex]){
                    swapValues(nums,i,correctIndex);
                }else {
                    i++;
                }
            }
        for(int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1 && nums[j]==nums[nums[j]-1]){ //second condition is important because  if not equals ( i.e. nums[j]!=j+1)then two cases arise ,either the element ins duplicate or is unique
                return nums[j];
        }
        }
        return -1;
    }


    //find the all duplicate elements containing n+1 integers where each integer is in range [1,n] inclusive
    public static List<Integer> findAllDuplicateNumber(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctIndex= nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swapValues(nums,i,correctIndex);
            }else{
                i++;
            }
        }
        List<Integer> duplicateIntegers=new ArrayList<>();
        for(int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                duplicateIntegers.add(nums[j]);
            }
        }
        return duplicateIntegers;
    }
    //Set Mismatch leetcode
    public static int[] findErrorNums(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctIndex= nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swapValues(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1 && nums[j]==nums[nums[j]-1]){
                return new int[]{nums[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }

    //Leetcode smallest missing positive number
    private static int findSmallestMissingPositiveNumber(int[] arr) {
        int i=0;
        while(i<arr.length) {
            int correctIndex= arr[i]-1;
            //check element at index i will be less than the length and
            // then check the whether element is at correct index or not !!
            if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[correctIndex]){ //only check for positive number , 0 is not positive not negative
                swapValues(arr,i,correctIndex);    // swap until the  current index  will have the correct element.
            }else {
                i++;
            }
        }
        //now array has been sorted !
        //check the missing number
        for(int index = 0; index < arr.length; index++) {
            if(arr[index]>0 && arr[index]!=index+1){
                return index+1;
            }
        }
//case 2 : when the last element is not present
        return arr.length+1;
    }

    private static void swapValues(int[] arr, int currentIndex, int nextIndex) {
        int temp=arr[currentIndex];
        arr[currentIndex]=arr[nextIndex];
        arr[nextIndex]=temp;
    }




}
