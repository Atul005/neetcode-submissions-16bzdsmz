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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, inorder.length-1, map);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, 
                        int end, Map<Integer, Integer> map){

        if(start > end){
            return null;
        }

        int nodeValue = preorder[preIdx];
        int idx = map.get(nodeValue);

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = solve(preorder, inorder, start, idx-1,  map);
        root.right = solve(preorder, inorder, idx+1 , end, map);                    
        return root;
    }
}
