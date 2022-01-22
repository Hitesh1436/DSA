import java.io.*;
import java.util.*;

public class Main {
    
       public void display(int [] arr){  // display ke liye likha h
    for(int e : arr)
        System.out.print(e + " ");
    System.out.println();
}
    
    // recursive code
    
    public static int climbStairR(int n){
        if(n==0){
            return 1;  // iska mtlb ek path milgya hoga hume tbhi 0 aya 
        }
        int count=0;
        
        if(n-1>=0){
           count+=climbStairR(n-1); 
        }
        if(n-2>=0){
           count+=climbStairR(n-2); 
        }
        if(n-3>=0){
           count+=climbStairR(n-3); 
        }
        return count;
    }
    
    
    // memoization ka code krenge ab
    
    public static int climbStairM(int n ,int[]dp){
        if(n==0){
            return dp[n]=1;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        int count=0;
        
         if(n-1>=0){
           count+=climbStairR(n-1); 
        }
        if(n-2>=0){
           count+=climbStairR(n-2); 
        }
        if(n-3>=0){
           count+=climbStairR(n-3); 
        }
        return dp[n]=count;   
    }
 
 public static int climbStairT(int N ,int[]dp){
      for(int n=0;n<dp.length;n++){
              if(n==0){
             dp[n]=1;
             continue;
        }
        
      
        int count=0;
        
         if(n-1>=0){
           count+=dp[n-1]; 
        }
        if(n-2>=0){
           count+=dp[n-2]; 
        }
        if(n-3>=0){
           count+=dp[n-3];
        }
        dp[n]=count; 
      }
      return dp[N];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        // int ans=climbStairR(n);
        
        // memoization ke liye
        int []dp = new int[n+1]; 
        Arrays.fill(dp,-1);
        
        // int ans= climbStairM(n,dp);
        // tabulation ke liye 
        int ans= climbStairT(n,dp);
        
        System.out.println(ans);
    }

}