package org.example.BinarySearch;

import java.util.Arrays;

public class BinarySearch2DArray {

    //Now we need to understand the sorted 2D array
    //Lets say a matrix or 2D array is sorted in row-wise and column wise manner means every row as well as every column is sorted
    // and I need to search the target element
    // when you have to search something in a large search space then try to minimize the search space .
    //Consider n*n  or n*m matrix
    public static void performSearchOn2DArray(){

        //row and column wise sorted
        int[][] arr ={{10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };

        System.out.println(Arrays.toString(searchInRowAndColumnWiseSorted(arr,37)));


        //strictly sorted array
        int[][] strictSortedArray={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(searchInSorted(arr,8)));

    }

//matrix is sorted in row wise and column wise
    public static int[] searchInRowAndColumnWiseSorted(int[][] matrix, int target){
     int row=0;
     int col=matrix.length-1; // it can be n*m matrix also

     while(row<matrix.length && col>=0){
         if(matrix[row][col]==target){
             return new int[]{row,col};
         }
         else if(matrix[row][col]<target){
             row++;
         }else {
             col--;
         }
     }
            return new int[]{-1,-1};
    }

    //so complex not required
    public static int[] searchInSorted(int[][] matrix, int target){
        int rows=matrix.length;
        int cols=matrix[0].length; //it may be empty
        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }

        int rStart=0;
        int rEnd=rows-1;
        int cMid=cols/2;

        //run the loop till 2 row s are remaining !!
        while(rStart<(rEnd-1)) { //while this is executing i.e. this is true  it will have more than two rows
             int mid=rStart+(rEnd-rStart)/2;
             if(matrix[mid][cMid]==target){
                 return new int[]{mid,cMid};
             }
             else if(matrix[mid][cMid]<target){
                 rStart=mid; // not mid+1 otherwise it will remain the one row only !
             }else {
                 rEnd=mid;
             }
        }
        //now we have two rows
        //check whether the target is in the col of 2 rows
        if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        //search in 1 half
        if(target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        //search in 2 half
        if(target>=matrix[rStart][cMid+1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }
        //search in 3 half
        if(target<=matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }
        //search in 4 half
        if(target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        else {
            return binarySearch(matrix,rStart+1,cMid+1,cols-1,target);
        }
    }

    //Since we know that array is sorted ,it can be visualized as the sorted 1-D array
    //for more info watch codeStoryWithMIK
    //also we can use the formula to map to 1D array into the 2D array
    //we consider the matrix of n*m
    public static int[] searchInSorted_V2(int[][] matrix, int target){
            int totalRow=matrix.length;
            int totalCols=0;
            if(matrix[0].length!=0){
                totalCols=matrix[0].length;
            }
            int startIndex=0;
            int endIndex= totalRow*totalCols -1 ;

            while(startIndex<=endIndex){
                int midIndex=startIndex+(endIndex-startIndex)/2;

                int row=midIndex/totalCols; //mapping of row of 2D array
                int col=midIndex%totalCols; //mapping of column of 2D array
                if(matrix[row][col]==target){
                    return new int[]{row,col};
                }else if(target>matrix[row][col]){
                    startIndex=midIndex+1;
                }else {
                    endIndex=midIndex-1;
                }
            }
            return new int[]{-1,-1};
    }

    public static int[] binarySearch(int[][] matrix , int row ,int cStart ,int cEnd, int target){
        while(cStart<=cEnd){
            int mid=cStart+(cEnd-cStart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }else if(matrix[row][mid]>target){
                cEnd=mid-1;
            }else {
                cStart=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
