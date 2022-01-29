
//Recursive socha khudse pr answer glt aarha hai 

// import java.io.*;
// import java.util.*;

// public class Main {
    
//     public static int MinCostTraversal(int i,int j,int[][]grid){
//         if(i>=grid.length || j>=grid[0].length){
//             return 0;
//         }
        
//         int op1 = MinCostTraversal(i,j+1,grid);
//         int op2 = MinCostTraversal(i+1,j,grid);
        
//         int min = Math.min(op1 , op2);
        
//         min = min + grid[i][j];
        
//         return min;
//     } 

//     public static void main(String[] args) throws Exception {
//         Scanner scn = new Scanner(System.in);
//         int n=scn.nextInt();
//         int m=scn.nextInt();
//         int[][]grid = new int[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 grid[i][j]=scn.nextInt();
//             }
//         }
//         int ans = MinCostTraversal(0,0,grid);
//         System.out.println(ans);
//     }

// }


//Tabulation easy pdta h for grid questions so vo use krrrhe hain lkin acha trika h memoization bhi sochna 

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int [][]grid = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=scn.nextInt();
            }
        }
        int [][]dp = new int[n][m];
        
        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    // for last single block 
                    dp[i][j]=grid[i][j];
                }
                else if(i==n-1){
                    // for last row
                    dp[i][j]= dp[i][j+1] + grid[i][j];
                }
                else if(j==m-1){
                    // for last column
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else{
                    // for remaining elements
                    int min = Math.min(dp[i][j+1],dp[i+1][j]);
                    dp[i][j] = min + grid[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }

}