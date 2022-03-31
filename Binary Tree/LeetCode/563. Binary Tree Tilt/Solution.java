// Approach 1

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
    public int ans=0;
    public int solve(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = solve(node.left);
        int right =solve(node.right);
        
        ans = ans + Math.abs(left-right);
        return left+right + node.val;
    }
    
    public int findTilt(TreeNode root) {
        ans = 0;
        solve(root);
        return ans;
    }
}



// Approach 2
class Solution {
    
    class pair{
       int s;
        int t;
        pair(){}
        pair(int s,int t){
            this.t = t;
            this.s = s;
        }
   }
   
   public pair total(TreeNode root){
       if(root == null){
           return new pair(0,0);
       }
        pair left = total(root.left);
       pair right = total(root.right);
       
     int currSum = left.s + right.s + root.val;
       int tilt = left.t + right.t + Math.abs(left.s-right.s);
       pair my = new pair(currSum,tilt);
       return my;
   }
   public int findTilt(TreeNode root) {
      return total(root).t;
   }
}