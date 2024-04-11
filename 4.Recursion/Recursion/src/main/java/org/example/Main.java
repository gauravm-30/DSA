package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr ={4,2,3,2,8,4,3};
        int[] sortedArr ={2,2,3,3,4,4,8};
        int unique =findUnique(sortedArr);
        System.out.println(unique);

        int num1 = 7;
        int num2 = -4;

        String binary1 = Integer.toBinaryString(num1);
        String binary2 = Integer.toBinaryString(num2);

        System.out.println("Binary representation of " + num1 + ": " + binary1);
        System.out.println("Binary representation of " + num2 + ": " + binary2);

        System.out.println(gcd(10,9));

        System.out.println(isPalin("abbb",0,3));

    }

    //visualize it as sorted array so that xor operation is applied
    //between the all elements of the array.
    private static int findUnique(int[] arr) {
        int unique=0;
        for (int n : arr) {
            unique=unique^n;
        }
        return unique;
    }

    private static int gcd(int a,int b){
        if(a==0) {
            return b;
        }
         return gcd(b%a,a);

        }

    private static boolean isPalin(String s1,int start,int end){
        if(start<=end && s1.charAt(start)!=s1.charAt(end)) {
            return false;
        } else if (start>end) {
            return true;
        }
        return isPalin(s1, ++start,--end);
    }
    }

