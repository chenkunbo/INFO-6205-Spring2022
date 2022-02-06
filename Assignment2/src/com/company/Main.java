package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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

        //* 540. Single Element in a Sorted Array ( HW-2 )
        int[] nums3 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums4 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println("2. Single Element in a Sorted Array");
        System.out.println(singleNonDuplicate(nums3));
        System.out.println(singleNonDuplicate(nums4));

        //* 153. Find Minimum in Rotated Sorted Array ( HW-3 )
        int[] nums5 = {3, 4, 5, 1, 2};
        int[] nums6 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("3. Find Minimum in Rotated Sorted Array");
        System.out.println(findMin(nums5));
        System.out.println(findMin(nums6));

        //* 253. Meeting Rooms II ( HW-4 )
        int[][] intervals1 = {{0,30}, {5,10}, {15,20}};
        int[][] intervals2 = {{7,10}, {2,4}};
        System.out.println("4. Meeting Rooms II");
        System.out.println(minMeetingRooms(intervals1));
        System.out.println(minMeetingRooms(intervals2));


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

    //* 540. Single Element in a Sorted Array ( HW-2 )
    private static int singleNonDuplicate(int[] nums3){

        int start = 0;
        int end = nums3.length - 1;

        while(start <= end){
            /*
               We can also calculate mid = (start + end)/2. To prevent overflow
               we are using start+(end-start)/2
             */
            int mid = start + ( end - start)/2;

            if(start == end){
                return nums3[start];
            }
            else if(mid % 2 == 0){

                if(nums3[mid] == nums3[mid + 1]){
                    start = mid + 2;
                }
                else{
                    end = mid;
                }
            }
            else{
                if(nums3[mid] == nums3[mid - 1]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    //* 153. Find Minimum in Rotated Sorted Array ( HW-3 )
    private static int findMin(int[] nums5){

        int l = 0;
        int r = nums5.length - 1;

        if(nums5[l] < nums5[r]){
            return nums5[l];
        }
        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if(nums5[mid] > nums5[r]){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        return Math.min(nums5[l], nums5[r]);
    }

    //* 253. Meeting Rooms II ( HW-4 )
    private static int minMeetingRooms(int[][] intervals){
        // sort array by the start time
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        // min heap to keep track of the end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // find min rooms
        minHeap.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i ++){
            int[] cur = intervals[i];
            if(minHeap.peek() <- cur[0]){
                minHeap.poll();
            }
            minHeap.add(cur[1]);
        }
        // return min rooms
        return minHeap.size();

    }


    //* 347. Top K Frequent Elements ( HW-5 )









/// endregion

}
