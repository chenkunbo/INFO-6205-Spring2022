package com.company;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 5, 3, 2, 8, 7, 1, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void swap(int[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length || i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 1. bubbleSort
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                }

            }
        }
    }


    // 2. selectionSort
    //O(n^2)
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }

    // 3. mergeSort
    // O( Log n * n ) = O( nLogn )
    private static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }

        // O(log(n))
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, high);

    }
    //O(n)
    private static void merge(int[] arr, int low, int high){
        int mid = (low +high)/2;
        int[] temp = new int[high -low +1];
        int i = low;
        int j = mid +1;
        int index = 0;

        // O(n)
        while( i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[index++] = arr[i];
                i ++;
            }else {
                temp[index++] = arr[j];
                j ++;
            }
        }
        //O(n)
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        //O(n)
        while(j <= high){
            temp[index++] = arr[j++];
        }

        i = low;
        for(int value : temp){
            arr[i++] = value;
        }
    }








    }


