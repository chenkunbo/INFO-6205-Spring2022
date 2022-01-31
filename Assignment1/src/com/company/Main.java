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

    // 658. Find K Closest Elements ( HW-5 )
    private List<Integer> findClosestElements(int[] arr, int k, int x){
        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int mid = (left +right)/2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = left; i < left + k; i++){
            result.add(arr[i]);
        }
        return result;
    }

    // 767. Reorganize String ( HW-6 )
    private String reorganizeString(String s){
        if(s.length() <= 1){
            return s;
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((x,y)->y.value-x.value);

        int[] record = new int[26];
        for (char ch: s.toCharArray()){
            record[ch - 'a']++;
        }
        int limit = s.length()/2 + s.length() % 2;
        for(int i = 0; i < 26; i++){
            if(record[i] > limit){
                return "";
            }
            if(record[i] >0){
                pq.add(new Item(record[i], (char)(i+'a')));
            }
        }
        return greedyBuild(s.length(),pq);
    }
    private String greedyBuild(int len, PriorityQueue<Item> pq){
        char[] ans = new char[len];
        int t = 0;
        while(pq.size() >0){
            Item cur = pq.poll();
            for(int i = 0; i < cur.value; i++){
                if(t >= len) {
                    t=1;
                    ans[t] = cur.pattern;
                } else {
                    ans[t] = cur.pattern;
                }
                t+=2;
            }
        }
        return new String(ans);
    }

    class Item{
        int value;
        char pattern;
        public Item(){
        }
        public Item(int v, char p){
            this.value = v;
            this.pattern = p;
        }
    }






}