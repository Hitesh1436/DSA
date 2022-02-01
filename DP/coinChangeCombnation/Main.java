import java.io.*;
import java.util.*;

public class Main {
    
    public static int coinsChangeCombination(int[]coins,int amt){
        int []dp = new int[amt+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<dp.length;j++){
                if(j-coins[i]>=0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amt];
    }
    

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int []coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = scn.nextInt();
        }
         int amt = scn.nextInt();
        int ans = coinsChangeCombination(coins,amt);
        System.out.println(ans);

    }
}