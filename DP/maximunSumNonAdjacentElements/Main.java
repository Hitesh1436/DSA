import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int included = arr[0];
        int excluded = 0;
        
        for(int i=1;i<n;i++){
            int newIncluded = excluded + arr[i];
            int newExcluded = Math.max(excluded,included);
            
            included = newIncluded;
            excluded = newExcluded;
        }
        System.out.println(Math.max(included,excluded));

    }
}