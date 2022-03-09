import java.io.*;
import java.util.*;

public class Main {
    
    // public static int solveR(int []arr, int src,int dest){
    //     if(src==dest){
    //         return 0;
    //     }
    //     int moves = Integer.MAX_VALUE - 1;
    //     for(int jump=1;jump<=arr[src] && jump+src<=dest;jump++){
    //         moves = Math.min(moves,solveR(arr,src+jump,dest));
    //     }
    //     return moves+1 ;
    // }
    
    public static int solveM(int []arr,int src,int dest,int []dp){
        if(src==dest){
            return dp[src]=0;
        }
        
        if(dp[src]!=-1){
            return dp[src];
        }
        int moves = Integer.MAX_VALUE - 1;
        for(int jump=1;jump<=arr[src] && jump+src<=dest;jump++){
            moves = Math.min(moves,solveM(arr,src+jump,dest,dp));
        }
        return dp[src] = moves +1 ;
        
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }
        int []dp = new int[n+1];
        // int ans = solveR(arr,0,n);
        int ans = solveM(arr,0,n,dp);
        System.out.println(ans);
    }

}