import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean balancedBrackets(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='[' || ch=='{' || ch=='('){
                st.push(ch);
            }else{
                if(st.size()==0){
                    return false;
                }
                if(ch==']' && st.peek()!='['){
                    return false;
                }else if(ch==')' && st.peek()!='('){
                    return false;
                }else if (ch=='}' && st.peek()!='{'){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        // return st.size()==0;  // niche vle ko ese likh skte hn
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = balancedBrackets(str);
        System.out.println(ans);
    }

}