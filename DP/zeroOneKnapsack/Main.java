import java.io.*;
import java.util.*;

public class Main {
    
    // Tabulation se kia h yeh 
    
    public static int ZeroOneKnapsack(int cap , int[]val , int[]wt){
        int [][]dp = new int[val.length+1][cap+1];
        int n= dp.length;
        int m=dp[0].length;
        
        // travel krenge dp mn ab
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j] = 0;
                }else{
                    int noCall = dp[i-1][j];
                    int yesCall = -1;
                    
                    if(j-wt[i-1]>=0){
                        yesCall = dp[i-1][j-wt[i-1]] + val[i-1];
                    }
                    dp[i][j] = Math.max(yesCall,noCall);
                }
            }
        }    
        return dp[n-1][m-1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []value = new int[n];
        for(int i=0;i<n;i++){
            value[i] = scn.nextInt();
        }
        int []wt = new int[n];
        for(int i=0;i<n;i++){
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        int ans = ZeroOneKnapsack(cap,value,wt);
        System.out.println(ans);

    }
}