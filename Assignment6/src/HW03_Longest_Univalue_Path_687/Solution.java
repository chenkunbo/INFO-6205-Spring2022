package HW03_Longest_Univalue_Path_687;

public class Solution {

    private int res = 0;
    public int longestUnivaluePath(TreeNode root){
        calculate(root);
        return res;
    }

    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftCount = calculate(root.left);
        int rightCount = calculate(root.right);
        int left = 0;
        int right = 0;
        if(root.left != null && root.left.val == root.val){
            left = leftCount + 1;
        }
        if(root.right != null && root.right.val == root.val){
            right = rightCount + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }


}
