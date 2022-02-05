import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();

        int [][]arr = new int[n][c];
        for(int i=0;i<n;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int [][]dp = new int[n][c];

        for(int j=0;j<c;j++){
            dp[0][j] = arr[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<c;j++){
                int min = (int)1e8;

                for(int k=0;k<c;k++){  // isse phle vli row ke sre column  mn sare color ke liye bs dekhenge k!=j ho
                    if(k != j){  // iska mtlb like 2nd row mn 1st column mn red dena h toh dkenge phli row mn red ke alwa baki sabko
                        if(dp[i-1][k]<min){
                            min = dp[i-1][k];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        int min = (int)1e8;
        for(int k=0;k<c;k++){
            if(dp[n-1][k]<min){
                min = dp[n-1][k];
            }
        }
        System.out.println(min);

    }
}