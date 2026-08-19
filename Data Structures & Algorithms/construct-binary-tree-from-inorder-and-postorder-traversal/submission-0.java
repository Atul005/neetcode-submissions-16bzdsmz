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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return build(inorder, 0, n-1, map, postorder, 0, n-1);
    }

    public TreeNode build(int[] inorder, int sI, int eI,
                            Map<Integer, Integer> map, 
                            int[] postorder, int sP, int eP){

        if(sI > eI || sP > eP){
            return null;
        }               

        TreeNode root = new TreeNode(postorder[eP]);

        int rootIdx = map.get(postorder[eP]);

        root.right = build(inorder, rootIdx+1, eI, map, 
                            postorder, eP - (eI - rootIdx)  ,eP-1);    
        
        root.left =  build(inorder, sI, rootIdx - 1, map, 
                            postorder,   sP, eP - (eI - rootIdx) - 1);                        
        
        return root;
    }



}