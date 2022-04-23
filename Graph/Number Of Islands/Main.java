import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      // yhn se h code 
      boolean [][] vis = new boolean[arr.length][arr[0].length];
            int countOfIslands = 0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]==0 && vis[i][j]==false){
                        solve(arr,i,j,vis);
                        countOfIslands++;
                    }
                }
            }
            System.out.println(countOfIslands);
   }
   
    public static void solve(int [][]arr,int i,int j,boolean[][]vis){
        // base case 
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || vis[i][j]==true){
            return;
        }
        vis[i][j]= true;
        solve(arr,i-1,j,vis);
        solve(arr,i,j-1,vis);
        solve(arr,i,j+1,vis);
        solve(arr,i+1,j,vis);
    }
   }
