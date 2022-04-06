// Approach 1

class Solution {
    
    class pair{
        int h;
        boolean isBal;
    }
    
    public pair isBal(TreeNode node){
        if(node == null){
            pair base = new pair();
            base.h = 0;
            base.isBal = true;
            return base;
        }
        pair left  = isBal(node.left);
        pair right = isBal(node.right);
        
        pair my = new pair();
        my.isBal = left.isBal && right.isBal && Math.abs(left.h-right.h)<=1;
        
        my.h = Math.max(left.h,right.h)+1;
        return my;
    }
    
    public boolean isBalanced(TreeNode root) {
        pair ans = isBal(root);
        return ans.isBal;
    }
}


// Approach 2

class Solution {
    
    boolean isBal = true;
    
    public int isBTBal(TreeNode node){
        if(node == null){
            return 0;
        }
        int lH = isBTBal(node.left);
        int rH = isBTBal(node.right);
        
        isBal = isBal && Math.abs(lH-rH)<=1;
        return Math.max(lH,rH)+1;
        
    }
    public boolean isBalanced(TreeNode root) {
        isBTBal(root);
        return isBal;
    }
}