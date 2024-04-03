package org.example;

public class Patterns {

    //How to appraoch
    // number of lines=number of rows = number of times outer loop will run .
    // identify for every row number,
    //how many cols are there
    //types of elements in columns
    public static void printStarPatternV1(int n){
        for(int row = 1; row <=n; row++) {
            for(int col = 1; col<=row ; col++) {
                System.out.print("* ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV2(int n){
        for(int row = 1; row <=n; row++) {
            for(int col = 1; col<=n ; col++) {
                System.out.print("* ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV3(int n){
        for(int row = 1; row<=n;row++) {
            for(int col =1; col<=n-row+1; col++) {
                System.out.print("* ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV4(int n){
        for(int row = 1; row<=n;row++) {
            for(int col =1; col<=row; col++) {
                System.out.print(col+ " ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV5(int n){
        for(int row = 1; row <=2*n-1; row++) {
            int totalRows=(row<=n)? row : (2*n-1)-row+1;

                for(int col = 1; col<=totalRows; col++) {
                    System.out.print("* ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
            }


        }


    public static void printStarPatternV6(int n){
        for(int row = 1; row <=2*n-1; row++) {
            int totalRows=(row<=n) ? row : (2*n-1)-row+1;
            int numberOfSpaces=n-totalRows;
            for(int i = 0; i < numberOfSpaces; i++) {
                System.out.print(" ");
            }

            for(int col = 1; col<=totalRows; col++) {
                    System.out.print("* ");
            }

            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    //whenever number needs to be printed then use the index 0 or 1 as per requirement
    public static void printStarPatternV7(int n){
        for(int row = 1; row <=n; row++) {
            int numberOfSpaces=n-row;
            for(int space = 0; space < numberOfSpaces; space++) {
                System.out.print("  ");
            }
            for(int col = row; col>=1; col--) {
                System.out.print(col+" ");
            }
            for(int col = 2; col<=row; col++) {
                System.out.print(col+" ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV8(int n){
        for(int row = 1; row <=2*n-1; row++) {
            int totalRows=(row<=n)?row:(2*n-1)-row+1;
            int numberOfSpaces=n-totalRows;
            for(int space = 0; space < numberOfSpaces; space++) {
                System.out.print("  ");
            }
            for(int col = totalRows; col>=1; col--) {
                System.out.print(col+" ");
            }
            for(int col = 2; col<=totalRows; col++) {
                System.out.print(col+" ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }

    public static void printStarPatternV9(int n){
        for(int row = 1; row <=2*n-1; row++) {;
            for(int col = 1; col <=2*n-1 ; col++) {
                int minDistance=Math.min(Math.min(row,col),Math.min((2*n-1)-row+1,(2*n-1)-col+1));
                int atEveryIndex=(n-minDistance)+1;
                System.out.print(atEveryIndex+" ");
            }
            //when one row is printed ,we need to add the new line
            System.out.println();
        }
    }
}
