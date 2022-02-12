import java.io.*;
import java.util.*;

public class Main {

    // isse tabulation mn convert krke likha h ab

    public static int waysTab(int N, int[]dp){
       for(int n=0;n<=N;n++){
           if(n<=2){
          dp[n] = n;
          continue;
        }
          dp[n] = dp[n-1] + dp[n-2];
       
        }
        return dp[N];
       }


    //  memoization se ksa hoga
    public static int waysM(int n, int[]dp){
        if(n<=2){
          return dp[n] = n;
        }

        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n] = waysM(n-1,dp) + waysM(n-2,dp);
    }

    // direct tabulation ka sochte toh ksa hota
     public static int waysT(int n){
       int []dp = new int[n+1];
       dp[1]= 1;
       dp[2]= 2;
       for(int i=3;i<=n;i++){
         dp[i] = dp[i-1] + dp[i-2];
     }
      return dp[n];
  }

  public static int waysToptimised(int n){
    int one =1;
    int two =2;
    for(int i=3; i<=n; i++){
       int myAns = one + two;
       one = two;
       two = myAns;
         }
         return two;

  }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int dp[] = new int[n+1];
        // int ans = waysTab(n,dp);
        // int ans = waysM(n,dp);
        // int ans = waysT(n);
        int ans = waysToptimised(n);
        System.out.println(ans);

    }
}