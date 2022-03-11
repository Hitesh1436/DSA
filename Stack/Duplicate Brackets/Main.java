import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean duplicateBrackets(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch!=')'){   // jbtk ) ni aya push krte jao
                st.push(ch);
            }else{
                if(st.peek()=='('){  // peek krte hi first (  agya toh true hoga
                    return true;
                }
                while(st.peek()!='('){  // yh khta jbtk peek pr ( yh ni h pop krte jao
                    st.pop();
                }
                st.pop();    // jse hi peek pr ( agya toh pop krdo usse bhi 
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        boolean ans = duplicateBrackets(s);
        System.out.println(ans);
    }

}