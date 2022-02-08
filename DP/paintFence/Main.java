import java.io.*;
import java.util.*;

public class Main {


// dp bnakr kia h yeh

    public static int PaintFence(int n,int k){
        int [][]dp = new int[2][n+1];

        for(int i=2; i<=n;i++){
            if(i==2){
                dp[0][i] = k;
                dp[1][i] = k*(k-1);
                continue;
            }
            dp[0][i] = dp[1][i-1];
            dp[1][i] = (k-1)*(dp[0][i-1] + dp[1][i-1]);
        }
        return dp[0][n] + dp[1][n];
    }

// bina dp bas variables use krke kra h yah

    public static int PaintFence_(int n,int k){
        int xx= k;
        int xy= k*(k-1);

        for(int i=3;i<=n;i++){
            int new_xx = xy;
            int new_xy = (k-1)*(xx + xy);

            xx = new_xx;
            xy = new_xy;
        }
        return xx + xy;
    }


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        // int ans = PaintFence(n,k);
        int ans = PaintFence_(n,k);
        System.out.println(ans);   

    }
}