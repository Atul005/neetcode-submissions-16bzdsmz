/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] temp = new int[1];
        diameter(root, temp);
        return temp[0];
    }

    public int diameter(TreeNode root, int[] res){
        if(root == null){
            return 0;
        }

        int lD = diameter(root.left, res);
        int rD = diameter(root.right, res);

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        res[0] = Math.max(res[0], lHeight + rHeight);

        return res[0];
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }



}
