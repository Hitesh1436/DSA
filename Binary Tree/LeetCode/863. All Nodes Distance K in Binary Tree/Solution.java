/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ArrayList<TreeNode> node2root(TreeNode node,TreeNode data){
        if(node == null){
            return new ArrayList<TreeNode>();
        }
        if(node == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<TreeNode>left = node2root(node.left,data);
        if(left.size()>0){
            left.add(node);
            return left;
        }
        ArrayList<TreeNode>right = node2root(node.right,data);
        if(right.size()>0){
            right.add(node);
            return right;
        }
        return new ArrayList<TreeNode>();
    }
    
    public static void kLevelDown(TreeNode node,int k,TreeNode blocker,List<Integer>ans){
        if(node == null || k<0 || node==blocker){
            return;
        }
        if(k==0){
            ans.add(node.val);
        }
        kLevelDown(node.left,k-1,blocker,ans);
         kLevelDown(node.right,k-1,blocker,ans);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> n2r = node2root(root,target);
        TreeNode blocker = null;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n2r.size();i++){
            TreeNode n = n2r.get(i);
            kLevelDown(n,k-i,blocker,ans);
            blocker = n;
        }
        return ans;
    }
}