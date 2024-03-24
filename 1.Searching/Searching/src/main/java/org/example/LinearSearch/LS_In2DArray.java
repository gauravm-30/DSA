package org.example.LinearSearch;

import java.util.Arrays;

public class LS_In2DArray {

    public static void performLinearSearchOnIntIn2DArr(){
        /*
        * Array of arrays = 2D array
        * total number of arrays in 2D array= arr.length
        * total number of elements in each array of the 2D array = arr[0].length
        * int[][] arr={{},{},{}}; valid 2D array
        * */
        int[][] empty2DArr={{},{},{}};
        int[][] arr={{-5,5},{-3,4,0},{1,9,3}};
        int max=findMaxIn2DArr(empty2DArr);
        int[] position= linearSearchOnIntIn2DArr(arr,4);
        System.out.println("Position of the element in 2D array: "+ Arrays.toString(position));
        System.out.println("Max in 2D array: "+ max);
    }

    private static int[] linearSearchOnIntIn2DArr(int[][] arr, int target) {

        if (arr == null || arr.length == 0) {
            return new int[]{-1,-1};
        }
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (target == arr[row][col]) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static int findMaxIn2DArr(int[][] arr) {
        /*
                int[][] empty2DArr={{},{},{}};
                for such arrays we need to check the arr[0].length==0
        * */
        if (arr == null || arr.length == 0 || arr[0].length==0) {
            return Integer.MAX_VALUE;
        }
        int max=arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col]>max) {
                    max=arr[row][col];
                }
            }
        }
        return max;
    }

    private static int findMaxIn2DArr_V2(int[][] arr) {
        /*
                int[][] empty2DArr={{},{},{}};
                for such arrays we need to check the arr[0].length==0
        * */
        if (arr == null || arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        int max=Integer.MIN_VALUE;

        //we can also use for each method
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col]>max) {
                    max=arr[row][col];
                }
            }
        }
        return max;
    }
}
