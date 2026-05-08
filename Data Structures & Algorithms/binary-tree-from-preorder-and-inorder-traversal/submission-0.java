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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return createTree(0, 0, n-1, preorder, inorder, map);
    }

    public TreeNode createTree(int preIndex, int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if(start > end){
            return null;
        }

        if(start == end){
            return new TreeNode(preorder[preIndex]);
        }

        int k = map.get(preorder[preIndex]);
        int leftSize = k - start;
        TreeNode root = new TreeNode(preorder[preIndex]);
        root.left = createTree(preIndex+1, start, k-1, preorder, inorder, map);
        root.right = createTree(preIndex+ leftSize +1, k + 1, end, preorder, inorder, map);
        return root;
    }
}
