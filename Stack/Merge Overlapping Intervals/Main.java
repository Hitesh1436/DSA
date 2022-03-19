import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
           return a[0]-b[0]; 
        });
        
        Stack<int []> st = new Stack<>();
        st.push(arr[0]);
        for(int i=0;i<arr.length;i++){
            int []t= st.pop();  // yhn mila hume (1,8)
            int s1 = t[0];
            int e1 = t[1];
            
            int s2 = arr[i][0];
            int e2 = arr[i][1];
            
            int emax = Math.max(e1,e2);
            
            // merge Condition
            if(e1>=s2){
                int []merge = {s1,emax};
                st.push(merge);
            }else{
                st.push(t);
                st.push(arr[i]);
            }   
        }
        int [][]ans = new int[st.size()][2];
        for(int i=ans.length-1;i>=0;i--){
            int []temp = st.pop();
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
        }
        return ans;
    }

}