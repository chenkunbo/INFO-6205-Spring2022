package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code
    }

    /// region Class 2

    private static boolean binSearchIterative(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return false;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
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


    /// endregion

}