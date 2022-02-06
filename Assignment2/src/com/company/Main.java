package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //* 35. Search Insert Position ( HW-1 )
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int target1 = 6;
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("1. Search Insert Position");
        System.out.println(searchInsearch(nums1, target1));
        System.out.println(searchInsearch(nums2, target2));


    }

/// region code assignment-2

    //* 35. Search Insert Position ( HW-1 )
    private static int searchInsearch(int[] nums1, int target){
        int l = 0;
        int r = nums1.length - 1;

        while(l <= r){
            int midIndex = (l + r)/2;
            if(nums1[midIndex] == target){
                return midIndex;
            }
            else if(nums1[midIndex] > target){
                r = midIndex - 1;
            }
            else{
                l = midIndex + 1;
            }
        }
        return l;
    }









/// endregion

}
