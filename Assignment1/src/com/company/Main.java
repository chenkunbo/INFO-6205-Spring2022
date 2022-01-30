package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void sortColors(int[] nums){
        int point0 = 0;
        int point2 = nums.length - 1;
        int i = 0;

        while(i <= point2){
            if(nums[i] == 0){
                swap(nums, point0, i);
                i++;
                point0++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else{
                swap(nums, point2, i);
                point2--;
            }
        }
    }


}
