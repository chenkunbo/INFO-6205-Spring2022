package com.company;

import java.util.*;

import static java.util.Arrays.sort;

public class Main {


    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] a = {3, 2, 3};
        majorityElement(a);
        System.out.println( majorityElement(a));

    }

    private static void swap(int[] nums1, int a, int b) {
        int temp = nums1[a];
        nums1[a] = nums1[b];
        nums1[b] = temp;
    }

    // 75. Sort Colors ( HW-1 )
    private static void sortColors(int[] nums1) {
        int point0 = 0;
        int point2 = nums1.length - 1;
        int i = 0;

        while (i <= point2) {
            if (nums1[i] == 0) {
                swap(nums1, point0, i);
                i++;
                point0++;
            } else if (nums1[i] == 1) {
                i++;
            } else {
                swap(nums1, point2, i);
                point2--;
            }
        }
    }

    // 229. Majority Element II ( HW-2 )

    private static List<Integer> majorityElement(int[] nums2) {
        List<Integer> res = new ArrayList<>();

        if (nums2 == null || nums2.length == 0) {
            return res;
        }
        int count1 = 0;
        int count2 = 0;

        int candidate1 = 1;
        int candidate2 = 1;

        for (int j : nums2) {

            if (j == candidate1) {
                count1++;
            } else if (j == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = j;
                count1++;
            } else if (count2 == 0) {
                candidate2 = j;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }


        for (int n : nums2) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            }
        }
        if (count1 > nums2.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums2.length / 3) {
            res.add(candidate2);
        }
        return res;
    }


    // 274. H-Index ( HW-3 )
    private int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int[] counts = new int[citations.length + 1];
        for (int citation : citations) {
            counts[Math.min(citation, citations.length)]++;
        }
        int citationCount = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            citationCount += counts[i];
            if (i <= citationCount) {
                return i;
            }
        }
        return -1;
    }

    // 349. Intersection of Two Arrays ( HW-4 )
    private int[] intersection(int[] nums3, int[] nums4){
        sort(nums3);
        sort(nums4);
        int i = 0;
        int j = 0;
        Set<Integer> intersect = new HashSet();
        while (i < nums3.length && j < nums4.length){
            if(nums3[i] == nums4[j]){
                intersect.add(nums3[i]);
                i++;
                j++;
            }
            else if(nums3[i] < nums4[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] result = new int[intersect.size()];
        int k = 0;
        for(int num : intersect){
            result[k++] = num;

        }
        return result;
    }




}