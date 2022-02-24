package HW01_Binary_Tree_Level_Order_Traversal_II_107;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<List<Integer>> st = new Stack<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            int len = qu.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < len; i ++) {
                TreeNode temp = qu.poll();
                level.add(temp.val);

                if (temp.left != null) {
                    qu.add(temp.left);
                }

                if (temp.right != null) {
                    qu.add(temp.right);
                }
            }
            st.push(level);

        }
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;

    }


}
