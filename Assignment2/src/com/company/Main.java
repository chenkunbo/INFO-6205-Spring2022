package com.company;

import java.util.*;

import static java.lang.Math.*;
import static java.lang.Math.abs;

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

        //* 347. Top K Frequent Elements ( HW-5 )
        int[] nums7 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] nums8 = {1};
        int k2 = 1;
        System.out.println("5. Top K Frequent Elements");
        System.out.println(Arrays.toString(topKFrequent(nums7, k1)));
        System.out.println(Arrays.toString(topKFrequent(nums8, k2)));

        //* 16. 3Sum Closest ( HW-6 )
        int[] nums9 = {-1, 2, 1, -4};
        int target3 = 1;
        System.out.println("6. 3Sum Closest");
        System.out.println(threeSumClosest(nums9, target3));

        //* 57. Insert Interval ( HW-7 )
        int[][] intervals3 = {{1,3}, {6,9}};
        int[] newInterval1 = {2,5};
        int[][] intervals4 = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = {4,8};
        System.out.println("7. Insert Interval");
        System.out.println(Arrays.deepToString(insert(intervals3, newInterval1)));
        System.out.println(Arrays.deepToString(insert(intervals4, newInterval2)));

        //* 435. Non-overlapping Intervals ( HW-8 )
        int[][] intervals5 = {{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals6 = {{1,2}, {1,2}, {1,2}};
        System.out.println("8. Non-overlapping Intervals");
        System.out.println(eraseOverlapIntervals(intervals5));
        System.out.println(eraseOverlapIntervals(intervals6));

        //* 986. Interval List Intersections ( HW-9 )
        int[][] firstList1 = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] secondList1 = {{1,5}, {8,12}, {15,24}, {25,26}};
        int[][] firstList2 = {{1,3}, {5,9}};
        int[][] secondList2 = {};
        System.out.println("9. Interval List Intersections");
        System.out.println(Arrays.deepToString(intervalIntersectin(firstList1, secondList1)));
        System.out.println(Arrays.deepToString(intervalIntersectin(firstList2, secondList2)));

        //* 18. 4Sum ( HW-10 )
        int[] nums10 = {1, 0, -1, 0, -2, 2};
        int target4 = 0;
        int[] nums11 = {2, 2, 2, 2, 2};
        int target5 = 8;
        System.out.println("10. 4Sum");
        System.out.println(fourSum(nums10, target4));
        System.out.println(fourSum(nums11, target5));


    }

/// region code assignment-2

    //* 35. Search Insert Position ( HW-1 )
    private static int searchInsearch(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int midIndex = (l + r)/2;
            if(nums[midIndex] == target){
                return midIndex;
            }
            else if(nums[midIndex] > target){
                r = midIndex - 1;
            }
            else{
                l = midIndex + 1;
            }
        }
        return l;
    }

    //* 540. Single Element in a Sorted Array ( HW-2 )
    private static int singleNonDuplicate(int[] nums){

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            /*
               We can also calculate mid = (start + end)/2. To prevent overflow
               we are using start+(end-start)/2
             */
            int mid = start + ( end - start)/2;

            if(start == end){
                return nums[start];
            }
            else if(mid % 2 == 0){

                if(nums[mid] == nums[mid + 1]){
                    start = mid + 2;
                }
                else{
                    end = mid;
                }
            }
            else{
                if(nums[mid] == nums[mid - 1]){
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
    private static int findMin(int[] nums){

        int l = 0;
        int r = nums.length - 1;

        if(nums[l] < nums[r]){
            return nums[l];
        }
        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        return min(nums[l], nums[r]);
    }

    //* 253. Meeting Rooms II ( HW-4 )
    private static int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                intervals.length, (a, b) -> (a[1] - b[1])
        );

        queue.offer(intervals[0]);

        int res = 1;

        for(int i = 1; i < intervals.length; i ++){
            int[] curr = intervals[i];
            int[] prevMeeting = queue.poll();
            if (curr[0] >= prevMeeting[1]){
                prevMeeting[1] = curr[1];
            }
            else{
                res ++;
                queue.offer(curr);
            }
            queue.offer(prevMeeting);
        }
        return res;
    }


    //* 347. Top K Frequent Elements ( HW-5 )
    private static int[] topKFrequent(int[] nums, int k){
        // save each element's appearance in a table
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        //define min heap with size k
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));

        // top k frequent element
        for(int num : hm.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[minHeap.size()];
        int index = 0;
        while(minHeap.isEmpty() == false){
            res[index++] = minHeap.poll();
        }
        return res;
    }

    //* 16. 3Sum Closest ( HW-6 )
    private static int threeSumClosest(int[] nums, int target){
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i ++){
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;

            while(a_pointer < b_pointer){
                int current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if(current_sum > target){
                    b_pointer -= 1;
                }
                else{
                    a_pointer += 1;
                }
                if(Math.abs(current_sum - target) < Math.abs(res - target)){
                    res = current_sum;
                }
            }
        }
        return res;
    }

    //* 57. Insert Interval ( HW-7 )
    private static int[][] insert(int[][] intervals, int[] newInterval){
        // define list
        List<int[]> list = new LinkedList<>();

        // 1. add all intervals that are non-overlapping to the newInterval
        int i = 0;
        int n = intervals.length;
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i++]);
        }
        // 2. merge newinterval with the overlapping interval
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i ++;
        }
        list.add(newInterval);
        // 3. add the remaining intervals onto the list
        while(i < n){
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);
    }

    //* 435. Non-overlapping Intervals ( HW-8 )
    private static int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length == 0 || intervals[0].length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int counter = 0;
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(pre[1] > intervals[i][0]){
                // there is overlapping
                counter ++;
                if(pre[1] > intervals[i][1]){
                    pre = intervals[i];
                }
            }
            else{
                pre = intervals[i];
            }
        }
        return counter;
    }


    //* 986. Interval List Intersections ( HW-9 )
    private static int[][] intervalIntersectin(int[][] firstList, int[][] secondList){
        // define res list
        List<int[]> res = new LinkedList<>();

        // define n1 and n2
        int n1 = firstList.length;
        int n2 = secondList.length;

        // define pointers
        int i = 0;
        int j = 0;

        // find interval intersection
        while(i < n1 && j < n2){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = firstList[j][0];
            int e2 = firstList[j][1];
            // add intersection
            if(s1 <= s2 && s2 <= e1 || s2 <= s1 && s1 <= e2){
                int s = Math.max(s1, s2);
                int e = Math.min(e1, e2);
                int[] cur = {s, e};
                res.add(cur);
            }
            // move pointers
            if(e2 > e1){
                i ++;
            }
            else{
                j ++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    //* 18. 4Sum ( HW-10 )
    private static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if(nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        // skip duplicates
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int k = j + 1;
                int l = nums.length -1 ;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum < target){
                        k ++;
                        while(nums[k] == nums[k - 1] && k < l){
                            k ++;
                        }
                    }
                    else if(sum > target){
                        l --;
                        while(nums[l] == nums[l + 1] && k < l){
                            l --;
                        }
                    }
                    else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k ++;
                        l --;
                        while(nums[k] == nums[k -1] && k < 1){
                            k ++;
                        }
                        while(nums[l] == nums[l + 1] && k < 1){
                            l --;
                        }
                    }
                }
            }
        }
        return result;
    }


/// endregion

}
