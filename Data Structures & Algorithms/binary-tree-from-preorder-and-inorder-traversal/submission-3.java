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
        int n = inorder.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return solve(preorder, inorder, map, 0, n-1, 0, n-1);
    }


    public TreeNode solve(int[] preorder, int[] inorder, 
                    Map<Integer, Integer> map, int startP, int endP, 
                    int startI, int endI){

        if(startP > endP || startI > endI){
            return null;
        }                    

        int rootIdx = map.get(preorder[startP]);
        TreeNode root = new TreeNode(preorder[startP]);
        int leftCount = rootIdx - startI;
        root.left = solve(preorder, inorder, map, startP+1, startP + leftCount, startI, rootIdx - 1);
        root.right = solve(preorder, inorder, map, startP + leftCount + 1, endP, rootIdx+1, endI);
        return root;
    }



}
