import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int []arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }

    // code yhn se h 

    //Step 1-> by default sblo true assign krdenge and hashmap bnarhe hn

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int ele:arr)
        hm.put(ele,true);

        //Step 2 ->Potential starting point dudhna h ab

        for(int ele:arr){
            if(hm.containsKey(ele-1))
            hm.put(ele,false);
        }

        // Step 3 -> check for longest length

        int maxLen = 0;
        int maxStPt = 0;

        for(int ele:arr){
            if(hm.get(ele)==true){
                int tempLen = 1;
                int tempStpt = ele;

                while(hm.containsKey(tempStpt + tempLen)){
                    tempLen++;
                }

                if(tempLen>maxLen){
                    maxLen = tempLen;
                    maxStPt = tempStpt;
                }
            }
        }

        for(int i= maxStPt;i<maxStPt+maxLen ;i++){
            System.out.println(i);
        }
 }

}