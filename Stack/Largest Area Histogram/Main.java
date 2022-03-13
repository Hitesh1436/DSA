import java.io.*;
import java.util.*;

public class Main{
    
    
    public static int[] nextSmallerOnLeft(int []arr){
        int n = arr.length;
        int [] ans = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()] > arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();  // yh vhi h like jhn kuch ni vhn -1 daldia 
            ans[idx] = -1;
        }
        return ans;
    }
    
     public static int[] nextSmallerOnRight(int []arr){
        int n = arr.length;
        int [] ans = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()] > arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();  // yh vhi h like arr ka size 6 h toh 7 daldia tha 
            ans[idx] = n;
        }
        return ans;
    }
    
    public static  int largestArea(int []height){
        int n = height.length;
        int [] nsol = nextSmallerOnLeft (height);
        int [] nsor = nextSmallerOnRight(height);
        int max = 0;
        for(int i=0;i<n;i++){
            int w = nsor[i]-nsol[i]-1;
            int area = height[i]*w;
            max = Math.max(max,area);
        }
        return max;
        
    }
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    int ans = largestArea(a);
    System.out.println(ans);
 }
}