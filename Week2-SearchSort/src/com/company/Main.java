package com.company;

public class Main {

    public static void main(String[] args) {

        //* 1. bin-Search Iterative
        // SampleClass sample = new SampleClass();
        // sample.binSearchIterative()
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binSearchIterative(arr1, 7));
        int[] arr2 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(binSearchIterative(arr2, 7));
        int[] arr3 = {7};
        System.out.println(binSearchIterative(arr3, 7));

        //* 2. bin-Search Recursive
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binSearchRecursive(arr4, 7));
        int[] arr5 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(binSearchRecursive(arr5, 7));
        int[] arr6 = {7};
        System.out.println(binSearchRecursive(arr6, 7));
        // questions
        int[] arr7 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 5, 5, 5, 7, 9, 9, 11};
        System.out.println(findFirstOccurance(arr7, 1));

    }

    /// region Class 2

    // 1. bin-Search Iterative
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


    // 2. bin-Search Recursive
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

    // Some interview questions
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









    /// endregion

}