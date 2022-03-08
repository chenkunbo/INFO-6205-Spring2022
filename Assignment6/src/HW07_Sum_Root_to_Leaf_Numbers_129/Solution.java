package HW07_Sum_Root_to_Leaf_Numbers_129;

public class Solution {
    public int sumNumbers(TreeNode root){
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int curSum){

        if(root == null) return 0;
        if(root.left == null && root.right == null) return curSum*10 + root.val;

        return sumNumbers(root.left, curSum*10 + root.val) + sumNumbers(root.right, curSum*10 + root.val);
    }

}
