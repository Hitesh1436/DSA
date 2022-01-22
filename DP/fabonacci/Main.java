import java.io.*;
import java.util.*;

public class Main {
    
    public void display(int [] arr){  // display ke liye likha h
    for(int e : arr)
        System.out.print(e + " ");
    System.out.println();
}
    
    // recursive solution kia h yeh line(6 to 16)
    public static int fiboR(int n){
        if(n<=1){
            return n;
        }
        int nm1 = fiboR(n-1);
        int nm2 = fiboR(n-2);
        
        return nm1+nm2;
        
    }
    
    // ab memoization krenge ()
    
    public static int fiboM(int n,int dp[]){
        if(n<=1){
            return dp[n]=n;
        }
           if(dp[n] != -1){
        return dp[n];
    }
        int nm1=fiboM(n-1,dp);
        int nm2=fiboM(n-2,dp);
        
        return dp[n]=nm1+nm2;
    }
    
    // ab tabulation mn convert krenge isse hum
    
    public static int fiboT(int N,int []dp){
        // bas ek loop chlado usme memoization ka code daldo 
        for(int n=0;n<dp.length;n++){
             if(n<=1){
           dp[n]=n;
           continue;  // tki agr yh conditions true hn toh agey na chle.
        }
        int nm1=dp[n-1];  // array ko call lgegi isme naki function ko.
        int nm2=dp[n-2];
        
        dp[n]=nm1+nm2;  // return htadenge yhn se
        }
        return dp[N];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        
        // int ans = fiboR(n);
        
        // memoization ke liye krrhe hn 
     int []dp = new int[n+1];  // n+1 lia bcz 0 and 10 bhi include kia h humne
  // for(int i=0;i<dp.length;i++): // isse hum dp ki hr jgh -1 rkh rhe hain
        // dp[i]=-1;
        // Arrays.fill(dp,-1);  // hr jgh -1 rkhne ka trika h yh bhi
        // int ans= fiboM(n,dp);
        
        int ans= fiboT(n,dp);
        System.out.println(ans);
        
    }

}