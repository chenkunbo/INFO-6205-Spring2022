package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //* 1. bin-Search Iterative
        // SampleClass sample = new SampleClass();
        // sample.binSearchIterative()
        System.out.println("1. bin-Search Iterative");
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binSearchIterative(arr1, 7));
        int[] arr2 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(binSearchIterative(arr2, 7));
        int[] arr3 = {7};
        System.out.println(binSearchIterative(arr3, 7));

        //* 2. bin-Search Recursive
        System.out.println("2. bin-Search Recursive");
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binSearchRecursive(arr4, 7));
        int[] arr5 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(binSearchRecursive(arr5, 7));
        int[] arr6 = {7};
        System.out.println(binSearchRecursive(arr6, 7));

        // question-1 find First Occurance
        int[] arr7 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 5, 5, 5, 7, 9, 9, 11};
        System.out.println("question-1 find First Occurance");
        System.out.println(findFirstOccurance(arr7, 1));
        // question-2 find Last Occurance
        System.out.println("question-2 find Last Occurance");
        System.out.println(findLastOccurance(arr7, 1));
        // question-3 find Total Occurance
        System.out.println("question-3 find Total Occurance");
        System.out.println(findTotalOccurance(arr7, 1));
        // question-4 find Total Occurance Recursive
        System.out.println("question-4 find Total Occurance Recursive");
        System.out.println(findTotalOccuranceRecursive(arr7, 1));
        System.out.println(findTotalOccuranceRecursive(arr7, 8));

        //* 3. rotate Array
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr8, 3);
        System.out.println("3. rotate Array");
        System.out.println(Arrays.toString(arr8));

        //* 4. find Rotated Index
        int[] arr9 = {7, 1, 2, 3, 4, 5, 6};
        System.out.println("4. find Rotated Index");
        System.out.println(findRotatedIndex(arr9));

        //* 5. find Index In Sorted Rotated Array
        int[] arr10 = { 5, 6, 7, 1, 2, 3, 4};
        System.out.println("5. find Index In Sorted Rotated Array");
        System.out.println(findIndexInSortedRotatedArray(arr10, 6));

        // question-5 two sum - boolean
        int[] arr11 = {5, 7, -3, 2, 1, 8};
        System.out.println("question-5 twoSum-boolean");
        System.out.println(twoSum1(arr11, 3));
        // question-6 two sum - int
        int[] arr12 = {5, 7, -3, 2, 1, 8};
        System.out.println("question-6 twoSum-int");
        System.out.println( Arrays.toString(twoSum2(arr12, 3)));
        // question-7 three Values Sum Equal To X
        int[] arr13 = {5, 7, -3, 2, 1, 8};
        System.out.println("question-7 three Values Sum Equal To X");
        System.out.println( Arrays.toString(threeValuesSumEqualToX(arr13, 8)));



    }

    /// region Class 2

    //* 1. bin-Search Iterative
    // O(log(n))
    private static boolean binSearchIterative(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return false;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == x){
                return true;
            }
            else if(arr[mid] < x){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }


    //* 2. bin-Search Recursive
    // O(log(n))
    private static boolean binSearchRecursive(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return binSearchRecursive(arr, x, 0, arr.length - 1);
    }
    private static boolean binSearchRecursive(int[] arr, int x, int start, int end){
        if(start > end){
            return false;
        }
        int mid = (start + end)/2;
        if(arr[mid] == x){
            return true;
        }
        else if(arr[mid] < x){
            return binSearchRecursive(arr, x, mid + 1, end);
        }
        else{
            return binSearchRecursive(arr, x, start, mid - 1);
        }
    }

    // question-1 find First Occurance
    // O(log(n))
    private static int findFirstOccurance(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return - 1;
        }
        return findFirstOccurance(arr, x, 0, arr.length - 1);
    }
    private static int findFirstOccurance(int[] arr, int x, int start, int end){
        if(arr[start] > x || arr[end] < x){
            return - 1;
        }
        if(arr[start] == x){
            return start;
        }
        int mid = (start + end)/2;

        if(arr[mid] == x){
            return findFirstOccurance(arr, x, start, mid);
        }
        else if(arr[mid] < x){
            return findFirstOccurance(arr, x, mid + 1, end);
        }
        else{
            return findFirstOccurance(arr, x, start, mid - 1);
        }

    }

    // question-2 find Last Occurance
    // O(log(n))
    private static int findLastOccurance(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return - 1;
        }
        return findLastOccurance(arr, x, 0, arr.length - 1);
    }
    private static int findLastOccurance(int[] arr, int x, int start, int end){
        if(arr[start] > x || arr[end] < x){
            return - 1;
        }
        if(arr[end] == x){
            return end;
        }
        int mid = (start + end)/2;

        if(arr[mid] == x){
            return findLastOccurance(arr, x, mid, end);
        }
        else if(arr[mid] < x){
            return findLastOccurance(arr, x, mid + 1, end);
        }
        else{
            return findLastOccurance(arr, x, start, mid - 1);
        }

    }

    // question-3 find Total Occurance
    private static int findTotalOccurance(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // O(log(n))
        int first = findFirstOccurance(arr, x);
        if(first == -1){
            return 0;
        }
        // O(log(n))
        int last = findLastOccurance(arr, x);

        return (last - first + 1);
    }

    // question-4 find Total Occurance Recursive
    // O(log(n))
    private static int findTotalOccuranceRecursive(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return findTotalOccuranceRecursive(arr, x, 0, arr.length - 1);
    }
    private static int findTotalOccuranceRecursive(int[] arr, int x, int start, int end){
        if(arr[start] > x || arr[end] < x){
            return 0;
        }
        if(arr[start] == x && arr[end] == x){
            return (end - start + 1);
        }
        int mid = (start + end)/2;

        if(arr[mid] == x){
            return 1 + findTotalOccuranceRecursive(arr, x, start, mid - 1)+
                    findTotalOccuranceRecursive(arr, x, mid + 1, end);
        }
        else if(arr[mid] < x){
            return findTotalOccuranceRecursive(arr, x, mid + 1, end);
        }
        else{
            return findTotalOccuranceRecursive(arr, x, start, mid - 1);
        }
    }

    //* 3. rotate Array
    private static void reverse(int[] arr, int start, int end){
        if(arr == null || arr.length == 0 || start >= end || start < 0 || end > arr.length - 1){
            return;
        }
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
    private static void rotateArray(int[] arr, int n){
        if(arr == null || arr.length <= 1){
            return;
        }
        n = n % arr.length;

        // Step 1 : reverse the entire array
        reverse(arr, 0, arr.length - 1);
        // Step 2 : reverse from 0 to n-1
        reverse(arr, 0, n - 1);
        // Step 3 : reverse from n to arr.length -1
        reverse(arr, n, arr.length - 1);

    }

    //* 4. find Rotated Index
    private static int findRotatedIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return 0;
        }
        // Array is already properly sorted and there are no duplicates
        if(arr[0] < arr[arr.length - 1]){
            return -1;
        }
        return findRotatedIndex(arr, 0, arr.length - 1);
    }
    private static int findRotatedIndex(int[] arr, int start, int end){
        // no duplicates
        if(arr[start] == arr[end]){
            return start;
        }

        int mid = (start + end)/2;
        if(arr[mid] > arr[start]){
            // left half is properly sorted
            return findRotatedIndex(arr, mid, end);
        }
        else{
            // right half is properly sorted
            return findRotatedIndex(arr, start, mid);
        }
    }

    //* 5. find Index In Sorted Rotated Array
    private static int binSearch(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return -1;
        }
        return binSearch(arr, x, 0, arr.length -1);

    }
    private static int binSearch(int[] arr, int x, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == x){
            return mid;
        }
        else if(arr[mid] < x){
            return binSearch(arr, x, mid + 1, end);
        }
        else{
            return binSearch(arr, x, start, mid - 1);
        }

    }
    private static int findIndexInSortedRotatedArray(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return arr[0] ==x ? 0 : -1;
        }

        int index = findRotatedIndex(arr);

        // if the array was not rotated
        if(index == -1){
            return binSearch(arr, x);
        }

        // if the array was rotated we will look for edge conditions first
        if(arr[index] < x){
            // largest value is smaller than x
            return -1;
        }
        if(arr[index + 1] > x){
            // smallest value is bigger than x
            return -1;
        }
        // see where should we look for the value
        if(x > arr[0]){
            return binSearch(arr, x, 0, index);
        }
        return binSearch(arr, x, index + 1, arr.length - 1);

    }


    // question-5 two sum - boolean ( leetcode easy question )
    private static boolean twoSum1(int[] arr, int sum){
        if(arr == null || arr.length <= 1){
            return false;
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int total = arr[start] + arr[end];
            if(total == sum){
                return true;
            }
            else if(total < sum){
                start ++;
            }
            else{
                end --;
            }
        }
        return false;
    }
    // question-6 two sum - int
    private static int[] twoSum2(int[] arr, int sum){
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        if(arr == null || arr.length <= 1){
            return result;
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length -1;

        while(start < end){
            int total = arr[start] + arr[end];
            if(total == sum){
                result[0] = arr[start];
                result[1] = arr[end];
                return result;
            }
            else if(total < sum){
                start ++;
            }
            else{
                end --;
            }
        }
        return result;
    }

    // question-7 three Values Sum Equal To X
    // duplicates return the same result
    private static int[] twoSum(int[] arr, int sum, int start, int end){
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        if(arr == null || arr.length <= 1){
            return result;
        }
        while(start < end){
            int total = arr[start] + arr[end];
            if(total == sum){
                result[0] = arr[start];
                result[1] = arr[end];
                return result;
            }
            else if(total < sum){
                start ++;
            }
            else{
                end --;
            }
        }
        return result;
    }
    // circumstance-1 return array
    private static int[] threeValuesSumEqualToX(int[] arr, int x){
        int[] result = new int[3];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length -2; i ++){
            int[] values = twoSum(arr, (x - arr[i]), i + 1, arr.length - 1);
            if(values[0] == Integer.MIN_VALUE){
                continue;
            }
            result[0] = arr[i];
            result[1] = values[0];
            result[2] = values[1];

            return result;
        }
        return result;
    }

    // circumstance-2 return list
    private static ArrayList<int[]> threeValuesSumEqualToXlist(int[] arr, int x){
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 0; i < arr.length -2; i ++){
            int[] values = twoSum(arr, (x - arr[i]), i + 1, arr.length - 1);
            if(values[0] == Integer.MIN_VALUE){
                continue;
            }
            int[] result = new int[3];
            result[0] = arr[i];
            result[1] = values[0];
            result[2] = values[1];
            list.add(result);
        }
        return list;
    }









    /// endregion

}