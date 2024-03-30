package org.example;

import org.example.BinarySearch.BinarySearch;
import org.example.BinarySearch.FloorAndCeilOfNumber;
import org.example.LinearSearch.LS_In2DArray;
import org.example.LinearSearch.LS_Int;
import org.example.LinearSearch.LinearSearchLeetCode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linear Search");
     LS_Int.performLinearSearchOnInt();
     LS_In2DArray.performLinearSearchOnIntIn2DArr();
     LinearSearchLeetCode.findNumbersWithEvenNumberOfDigits();
     LinearSearchLeetCode.richestCustomerWealth();

        System.out.println("Binary Search");
     BinarySearch.performBinarySearch();
        FloorAndCeilOfNumber.performFloorAndCeilOperation();

    }
}