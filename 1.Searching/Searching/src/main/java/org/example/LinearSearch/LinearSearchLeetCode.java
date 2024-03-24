package org.example.LinearSearch;

public class LinearSearchLeetCode {

    //Problem 1:
    public static void findNumbersWithEvenNumberOfDigits(){
        int[] arr={12,-345,2,6,7896};
        int totalEvenNumbers=totalNumbersWithEvenNumberOfDigits_V1(arr);
        int totalEven=totalNumbersWithEvenNumberOfDigits_V2(arr);
        System.out.println("Total Numbers With EvenNumberOfDigits in array: "+ totalEvenNumbers );
        System.out.println("Total Numbers With EvenNumberOfDigits in array: "+ totalEven );
    }

    public static void richestCustomerWealth(){
        int[][] arr={{12,-345},{2,6},{78},{7,3},{55,6},{81,-90}};
        int totalWealth= getMaxWealthOfCustomer(arr);
        System.out.println("Total wealth "+  totalWealth);
    }

    private static int getMaxWealthOfCustomer(int[][] accounts) {
        if(accounts==null ||accounts.length==0){
            return Integer.MIN_VALUE;
        }
        int maxWealth=0;
        for (int person = 0; person< accounts.length; person++) {
            int currentWealth=0;
            for (int acc = 0; acc < accounts[person].length; acc++) {
                currentWealth=currentWealth+accounts[person][acc];
            }
            if(currentWealth>maxWealth){
                maxWealth=currentWealth;
            }
        }
        return maxWealth;
    }

    private static int totalNumbersWithEvenNumberOfDigits_V1(int[] arr) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        int countEvenNumber=0;

        for (int element: arr){
            String s1=String.valueOf(element);
            if(s1.contains("-")) {
                s1 = s1.replaceFirst("-", "");
            }
            if(s1.length()%2==0){
                countEvenNumber++;
            }
        }
        return countEvenNumber;
    }

    private static int totalNumbersWithEvenNumberOfDigits_V2(int[] arr) {
        if(arr==null || arr.length==0){
            //ideally we should be throwing exception here
            return -1;
        }
        int countEvenNumber=0;

        for (int element: arr){
            int digits=getTotalDigits(element);
            if(digits%2==0){
                countEvenNumber++;
            }
        }
        return countEvenNumber;
    }

    private static int getTotalDigits(int element) {
        int count=0;

        if(element<0){
            //make it positive
            element=Math.abs(element);
            //or
            //  element=element*(-1);
        }
        while (element>0){
            count++;
            element=element/10;
        }
        return count;
    }

}
