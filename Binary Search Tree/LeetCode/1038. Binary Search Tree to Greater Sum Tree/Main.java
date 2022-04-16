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
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int rightSum = 0;
        while(node !=null || !stack.isEmpty()) {
            while(node !=null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += rightSum; 
            rightSum =node.val;
            node = node.left;           
        }
        return root;       
        
    }    

}

// Approach 2
class Solution {
    
    int sum =0;
    
    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.right);
        sum = sum + root.val;
        root.val = sum;
        traversal(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }
}