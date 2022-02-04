package com.company;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;


public class Main {

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println("1. Sort Colors");
        System.out.println(Arrays.toString(nums1));

        int[] a = new int[]{3, 2, 3};
        System.out.println("2. Majority Element II");
        System.out.println( new Solution2().majorityElement(a));

        int[] b = new int[]{3, 0, 6, 1, 5};
        System.out.println("3. H-Index");
        System.out.println( new Solution3().hIndex(b));

        int[] c = {4, 9, 5};
        int[] d = {9, 4, 9, 8, 4};
        System.out.println("4. Intersection of Two Arrays");
        System.out.println(Arrays.toString(new Solution4().intersection(c, d)));

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println("5. Find K Closest Elements");
        System.out.println(new Solution5().findClosestElements(arr, k, x));

        String s = "aab";
        System.out.println("6. Reorganize String");
        System.out.println(new Solution6().reorganizeString(s));

        String order = "cbafg";
        String ss = "abcd";
        System.out.println("7. Custom Sort String");
        System.out.println(new Solution7().customSortString(order, ss));

        int[] arr2 = {3, 2, 4, 1};
        System.out.println("8. Pancake Sorting");
        System.out.println(new Solution8().pancakeSort(arr2));

        int[] e = {1, 1, 2, 2, 2, 3};
        System.out.println("9. Sort Array by Increasing Frequency");
        System.out.println(Arrays.toString(new Solution9().frequencySort(e)));

        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int f = 2;
        System.out.println("10. Top K Frequent Words");
        System.out.println(new Solution10().topKFrequent(words, f));


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
    public static class Solution2 {
        public List<Integer> majorityElement(int[] nums) {

            int count1 = 0;
            int count2 = 0;

            Integer candidate1 = null;
            Integer candidate2 = null;

            for (int n : nums) {

                if (candidate1 != null && candidate1 == n) {
                    count1++;
                } else if (candidate2 != null && candidate2 == n) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = n;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = n;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
            List<Integer> result = new ArrayList<>();
            count1 = 0;
            count2 = 0;
            for (int n : nums) {
                if (candidate1 != null && candidate1 == n) {
                    count1++;
                }
                if (candidate2 != null && candidate2 == n) {
                    count2++;
                }
            }
            int p = nums.length;
            if (count1 > p / 3) result.add(candidate1);
            if (count2 > p / 3) result.add(candidate2);

            return result;
        }
    }

    // 274. H-Index ( HW-3 )
    public static class Solution3 {
        public int hIndex(int[] citations) {
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
    }

    // 349. Intersection of Two Arrays ( HW-4 )
    public static class Solution4 {
        public int[] intersection(int[] nums3, int[] nums4) {
            Arrays.sort(nums3);
            Arrays.sort(nums4);
            int i = 0;
            int j = 0;
            Set<Integer> intersect = new HashSet();
            while (i < nums3.length && j < nums4.length) {
                if (nums3[i] == nums4[j]) {
                    intersect.add(nums3[i]);
                    i++;
                    j++;
                } else if (nums3[i] < nums4[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            int[] result = new int[intersect.size()];
            int k = 0;
            for (int num : intersect) {
                result[k++] = num;

            }
            return result;
        }
    }

    // 658. Find K Closest Elements ( HW-5 )
    public static class Solution5 {
        private List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - k;

            while (left < right) {
                int mid = (left + right) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            List<Integer> result = new ArrayList<Integer>();
            for (int i = left; i < left + k; i++) {
                result.add(arr[i]);
            }
            return result;
        }
    }

    // 767. Reorganize String ( HW-6 )
    public static class Solution6 {
        private String reorganizeString(String s) {
            if (s.length() <= 1) {
                return s;
            }
            PriorityQueue<Item> pq = new PriorityQueue<>((x, y) -> y.value - x.value);

            int[] record = new int[26];
            for (char ch : s.toCharArray()) {
                record[ch - 'a']++;
            }
            int limit = s.length() / 2 + s.length() % 2;
            for (int i = 0; i < 26; i++) {
                if (record[i] > limit) {
                    return "";
                }
                if (record[i] > 0) {
                    pq.add(new Item(record[i], (char) (i + 'a')));
                }
            }
            return greedyBuild(s.length(), pq);
        }

        private String greedyBuild(int len, PriorityQueue<Item> pq) {
            char[] ans = new char[len];
            int t = 0;
            while (pq.size() > 0) {
                Item cur = pq.poll();
                for (int i = 0; i < cur.value; i++) {
                    if (t >= len) {
                        t = 1;
                        ans[t] = cur.pattern;
                    } else {
                        ans[t] = cur.pattern;
                    }
                    t += 2;
                }
            }
            return new String(ans);
        }

        static class Item {
            int value;
            char pattern;

            public Item() {
            }

            public Item(int v, char p) {
                this.value = v;
                this.pattern = p;
            }
        }
    }

    // 791. Custom Sort String ( HW-7 )
    public static class Solution7 {
        public String customSortString(String S, String T) {
            Map<Character, Integer> charFreMap = new HashMap<>();
            for (char c : T.toCharArray()) {
                charFreMap.put(c, charFreMap.getOrDefault(c, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (char c : S.toCharArray()) {
                if (!charFreMap.containsKey(c)) {
                    continue;
                }
                int i = 0;
                while (i < charFreMap.get(c)) {
                    sb.append(c);
                    i++;
                }
                charFreMap.remove(c);
            }
            for (char c : charFreMap.keySet()) {
                int i = 0;
                while (i < charFreMap.get(c)) {
                    sb.append(c);
                    i++;
                }
            }
            return sb.toString();
        }
    }

    // 969. Pancake Sorting ( HW-8 )
    public static class Solution8 {
        public ArrayList pancakeSort(int[] A) {
            ArrayList list = new ArrayList();
            for (int n = A.length; n > 0; n--) {
                int index = find(A, n);
                flip(A, index);
                flip(A, n - 1);
                list.add(index + 1);
                list.add(n);

            }
            return list;
        }

        private int find(int[] A, int target) {
            for (int i = 0; i < A.length; i++)
                if (A[i] == target)
                    return i;
            return -1;
        }

        private void flip(int[] A, int j) {
            int i = 0;
            while (i < j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
    }

    // 1636. Sort Array by Increasing Frequency ( HW-9 )
    public static class Solution9 {
        public int[] frequencySort(int[] nums5) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            {
                int i = 0;
                while (i < nums5.length) {
                    if (map.containsKey(nums5[i])) {
                        map.put(nums5[i], map.get(nums5[i]) + 1);
                    } else {
                        map.put(nums5[i], 1);
                    }
                    i++;
                }
            }
            List<Integer> list = new ArrayList<Integer>(map.keySet());
            list.sort((a, b) -> {
                if (Objects.equals(map.get(b), map.get(a))) {
                    return b - a;
                } else {
                    return map.get(a) - map.get(b);
                }
            });
            int[] result = new int[nums5.length];
            int index = 0;
            for (int num : list) {
                for (int i = 0; i < map.get(num); i++) result[index++] = num;
            }
            return result;
        }
    }

    // 692. Top K Frequent Words ( HW-10 )
    public static class Solution10 {
        public List<String> topKFrequent(String[] words, int f) {
            Map<String, Integer> map = new HashMap();
            for (int i = 0; i < words.length; i++) {
                if(map.containsKey(words[i])){
                    map.put(words[i], map.get(words[i]) + 1);
                }
                else{
                    map.put(words[i], 1);
                }
            }
            PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));

            for (String s : map.keySet()){
                pq.add(s);
                if(pq.size() > f){
                    pq.remove();
                }
            }
            List<String> list = new ArrayList<>();
            while (!pq.isEmpty()){
                list.add(0, pq.poll());
            }

            return list;
        }
    }




}