package Question_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static TreeNode buildTree (int[] preorder, int[] inorder){
        int preorderIndex = 0;

        Map<Integer, Integer> inorderIndexMap;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private static TreeNode arrayToTree ( int[] preorder, int left, int right){
        int preorderIndex = 0;
        Map<Integer, Integer> inorderIndexMap;
        inorderIndexMap = new HashMap<>();

        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
