import java.io.*;
import java.util.*;

public class Main {
    // recursive solution tha yeh
    public static int solveR(int []arr,int src , int dest){
        if(src==dest){
            return 1;
        }
        int count=0;
        for(int jump=1;jump<=arr[src] && jump + src<=dest;jump++){
            count+= solveR(arr,src+jump,dest);
        }
        return count;
    }
    // memoization solution hai yh
    public static int solveM(int []arr,int src , int dest,int[]dp){
        if(src==dest){
            return dp[src]=1;
        }
        if(dp[src]!=0){
            return dp[src];
        }
        
        int count=0;
        for(int jump=1;jump<=arr[src] && jump + src<=dest;jump++){
            count+= solveM(arr,src+jump,dest,dp);
        }
        return dp[src]=count;
    }
    
    // tabulation ka solution h ab
    
        public static int solveT(int []arr,int SRC , int dest,int[]dp){
        for(int src=dp.length-1;src>=SRC;src--){
        if(src==dest){
            dp[src]=1;
            continue;
        }
       
        int count=0;
        
        for(int jump=1;jump<=arr[src] && jump + src<=dest;jump++){
            count+= solveT(arr,src+jump,dest,dp);
        }
            dp[src]=count;
        }
        return dp[SRC];
    }
   
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        // int ans = solveR(arr,0,n);
        
        // memoization ke liye
        int []dp = new int[n+1];
        // int ans = solveM(arr,0,n,dp);
        //tabulation ke liye
        int ans = solveT(arr,0,n,dp);
        System.out.println(ans);
    }

}