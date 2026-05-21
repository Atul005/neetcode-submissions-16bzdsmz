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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null || root.val == target){
            return null;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode parent = q.poll();
                if(parent.left != null) {
                    if(parent.left.val == target && isLeaf(parent.left)){
                        parent.left = null;
                        removeLeafNodes(root, target);
                    } else{
                        q.offer(parent.left);
                    }
                }

                if(parent.right != null) {
                    if(parent.right.val == target && isLeaf(parent.right)){
                        parent.right = null;
                        removeLeafNodes(root, target);
                    } else{
                        q.offer(parent.right);
                    }
                }
                size--;
            }
        }
        return root;
    }

    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}