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
    
    public  int height(TreeNode root){
        if(root == null){
            return -1;
        }
        int lh =height(root.left);
        int rh =height(root.right);
        
        int myH = Math.max(lh,rh) + 1;
        return myH;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        
        int lh = height(root.left);
        int rh = height(root.right);
        int myDia = lh + rh + 2;
        
        return Math.max(myDia,Math.max(ld,rd));
    }
}

// Approach 2 -> pair bnkr kia h ki t=return hum apne according kr ske

class Solution {
    
    public class pair{
        int h;
        int d;
        pair(){};
        pair(int h,int d){
            this.h = h;
            this.d = d;
            
        }
    }
    
    public  pair diameter(TreeNode node){
        if(node == null){
            return new pair(-1,0);
        }
        
        pair lAns = diameter(node.left);
        pair rAns = diameter(node.right);
        
        pair my= new pair();
        
        my.h = Math.max(lAns.h,rAns.h) + 1;
        int acrossNode = lAns.h + rAns.h +2;
        my.d = Math.max(acrossNode,Math.max(lAns.d,rAns.d));
        
        return my;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        pair ans = diameter(root);
        return ans.d;
    }
}

// Approach 3 -> array k use krke bhi krskte hn bcz d and h int type ke hn

class Solution { 
        public  int[] diameter(TreeNode node){
            if(node == null){
                return new int []{-1,0};
            }
            
            int[] lAns = diameter(node.left);
            int[] rAns = diameter(node.right);
            
            int[] my= new int[2];
            // 0 , 1 hoga jisme 0 index pr height nd 1 pr dia hoga
            
            my[0] = Math.max(lAns[0],rAns[0]) +1;
            int acrossNode = lAns[0]+ rAns[0]+2;
            my[1]= Math.max(acrossNode,Math.max(lAns[1],rAns[1]));
            
            return my;
        }
        
        public int diameterOfBinaryTree(TreeNode root) {
            int [] ans = diameter(root);
            return ans[1];
        }
    }

    // Approach 4 -> static/global ka use krke 
    class Solution {
        static int ans =-(int)1e9;
        public int diameter(TreeNode root){
            if(root == null){
                return -1;
            }
            
            int lh = diameter(root.left);
            int rh = diameter(root.right);
            
            ans = Math.max(ans,lh+rh+2);
            
          int myH = Math.max(lh,rh)+1;
            return myH;
        }
        
        public int diameterOfBinaryTree(TreeNode root) {
             ans = -(int)1e9;
            diameter(root);
            return ans;
        }
    }
    