package HW01_Path_Sum_III_437;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int Counter = 0;
    int tar;
    Map<Integer, Integer> hm = new HashMap<>();
    public int pathSum(TreeNode root, int sum){
        tar = sum;
        hm.put(0, 1);
        dfs(root, 0);
        return Counter;
    }
    private void dfs(TreeNode root, int curSum){
        if(root == null) return;

        //update curSum
        curSum += root.val;
        //check curSum - tar exists in the table
        if(hm.containsKey(curSum - tar)){
            Counter += hm.get(curSum - tar);
        }

        //update the table with our curSum
        hm.put(curSum, hm.getOrDefault(curSum, 0) + 1);

        //traverse left side
        dfs(root.left, curSum);
        //traverse right side
        dfs(root.right, curSum);
        //remove the curSum off the table
        if(hm.get(curSum) == 1){
            hm.remove(curSum);
        }else{
            hm.put(curSum, hm.get(curSum) - 1);
        }
    }
}
