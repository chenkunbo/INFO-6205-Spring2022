package HW06_Count_Complete_Tree_Nodes_222;

public class Solution {
    public int leftHeight(TreeNode root){
        if(root == null)
            return 0;
        return leftHeight(root.left) + 1;
    }

    public int rightHeight(TreeNode root){
        if(root == null)
            return 0;
        return rightHeight(root.right) + 1;
    }

    public int countNodes(TreeNode root){
        if(root == null)
            return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh){
            return (int) Math.pow(2, lh) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
