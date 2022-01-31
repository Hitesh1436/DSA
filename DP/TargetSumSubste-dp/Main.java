import java.io.*;
import java.util.*;

public class Main {

    public static boolean tarSumSS(int [] arr, boolean [][] dp){
        int n = dp.length;
        int m = dp[0].length;
        
        // travel krenge dp mn
        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){
                if(j == 0){  // for 1st column
                    dp[i][j] = true;
                }
                else if( i == 0 ){
                    // for 1st row
                    dp[i][j] = false;
                }
                else{
                     // for remaining elements
                    // agr ni select kia toh kya uske upr vala answer dega yh vo check kia h
                    boolean noCall = dp[i-1][j];
                    
                    boolean yesCall = false;  // mnlia ki false h abi toh
                    
                    if(j - arr[i-1] >= 0){
                        yesCall = dp[i-1][j-arr[i-1]];
                    }
                    dp[i][j] = noCall || yesCall;
                }
                
            }
            
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = scn.nextInt();
        int tar = scn.nextInt();
        
        boolean [][] dp = new boolean[n+1][tar+1];
        
        boolean ans = tarSumSS(arr,dp);
        System.out.println(ans);
    }
}