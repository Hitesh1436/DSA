import java.io.*;
import java.util.*;

public class Main{
    
    public static boolean isNumeric(char ch){
        if(ch>='0' && ch<='9'){
            return true;
        }
        return false;
    }
    
    public static boolean isOperator(char optr ){
        if(optr=='+' || optr=='-' || optr=='*' || optr=='/'){
            return true;
        }
        return false;
    }
    
    public static void findValue(Stack<Integer>value,char ch){
        int v2 =value.pop();
        int v1 =value.pop();
        if(ch=='+'){
            value.push(v1+v2);
        }else if(ch=='-'){
            value.push(v1-v2);
        }else if(ch=='*'){
            value.push(v1*v2);
        }else{
            value.push(v1/v2);
        }
    }
    
    public static void findInfix(Stack<String>infix,char ch){
        String v2 = infix.pop();
        String v1 = infix.pop();
        String temp = "(" + v1 + ch + v2 + ")";
        infix.push(temp);
    }
    
    public static void findPrefix(Stack<String> prefix , char ch){
        String v2 = prefix.pop();
        String v1 = prefix.pop();
        String temp = ch + v1 + v2;
        prefix.push(temp);
    }
   
    
   
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value = new Stack<>();
    Stack<String> infix  = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if(isNumeric(ch)){
            value.push(ch-'0');
            infix.push(ch +"");
            prefix.push(ch +"");
            
        }else if(isOperator(ch)){
            findValue(value,ch);
            findInfix(infix,ch);
            findPrefix(prefix , ch);
        }
    }
    System.out.println(value.peek());
        System.out.println(infix.peek());
            System.out.println(prefix.peek());
}

}