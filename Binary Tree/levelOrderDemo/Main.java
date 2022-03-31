import java.util.*;
public class Main{

    public static class pair{        // pair class bnai h aur fir uske constructor bhi bnye hn
        Node node;
        int state;
        pair(){

        }

        pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    
    public static class Node{
        int val;
        Node left;
        Node right;
        // ab iss Node class ke constructor bnlete hn 

        Node(){

        }
        Node(int val){
            this.val =val;
        }
        Node(int val,Node left,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void levelOrder(Node root){
        Queue<Node> qu = new LinkedList<>();
        // 1. seeding root
        qu.add(root);

        while(qu.size()>0){
            //1. Remove
            Node rem = qu.remove();

            // 2. Work kro ab
            System.out.print(rem.val + " ");

            //3. Add all children if possible mtlb agr dono h toh dono vrna jo h usse add krdenge
            if(rem.left!=null){
                qu.add(rem.left);
            }
            if(rem.right!=null){
                qu.add(rem.right);
            }
        }
    }
    // next line mn print krya h null use krke
    public static void levelOrder_null(Node root){
        Queue<Node> qu = new LinkedList<>();
        // 1. seeding root
        qu.add(root);

        while(qu.size()>0){
            //1. Remove
            Node rem = qu.remove();

            // 2. Work kro ab
            System.out.print(rem.val + " ");

            //3. Add all children if possible mtlb agr dono h toh dono vrna jo h usse add krdenge
            if(rem.left!=null){
                qu.add(rem.left);
            }
            if(rem.right!=null){
                qu.add(rem.right);
            }
        }
    }

    public static void levelOrder3(Node root){
        Queue<Node> qu = new LinkedList<>();
        //seeding
        qu.add(root);

        while(qu.size() > 0 ){
            int size = qu.size();
            while(size-- > 0){
                //1. remove
                Node rem = qu.remove();
            
                //2. Work
                System.out.print(rem.val + " ");

                //3. Add all child If possible
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            System.out.println();
            
        }
    }

    public static void display(Node root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            System.out.print(root.left.val);
        }else{
            System.out.print(".");
        }
        System.out.print("<-" + root.val + "->");
        if(root.right!=null){
            System.out.print(root.right.val);
        }else{
            System.out.print(".");
        }
        System.out.println();

        display(root.left);
        display(root.right);
    }
    public static void main(String []args){
        Integer [] arr = {50,25,12,null,null,37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null };  // yeh hmra input hota h iss trike se
            Node root = new Node(arr[0]);   // root bnya h jhn se tree bnega agey jo h (50,0)
            Stack<pair> st = new Stack<>();   // stack bnya h jisme abihr jgh null h
            pair rootPair = new pair(root,1);  // pair bnya h (50,1)
            st.push(rootPair);   // push kia h (50,1) ko stack mn

            int idx = 1;
            while(st.size()!=0){
                pair peekPair = st.peek();   // yh hume top vla pair dega

                if(peekPair.state==1){   // state 1 h toh
                    peekPair.state++;   // peekPAir.state ko 1 se 2 krdo 
                    if(arr[idx]!=null){       // check krrhe hn ki null toh ni pda bcz null h toh push ni krenge stack mn
                        Node leftChild = new Node(arr[idx]);            // leftChild node bnya 
                        peekPair.node.left = leftChild;   // peekPair ke left mn leftChild attach krya null ko htakr 
 
                        st.push(new pair(leftChild,1));  // aur uss leftChild ke sth state 1 krke push krdia
                    }
                    idx++;   //agr arr[idx]==null toh bas idx ko ++ krdo 
                }
                else if(peekPair.state==2){
                    peekPair.state++;
                    if(arr[idx] != null){
                        
                        Node rightChild = new Node(arr[idx]);
                        peekPair.node.right = rightChild;
    
                        st.push(new pair(rightChild, 1));
                    }
                    idx++;
                }
                else{
                    // peekPair.state == 3 ke liye hoga yh vala
                    st.pop();
                }
            }
            
            
            // display(root);
            // levelOrder(root);
            // levelOrder_null(root);
            levelOrder3(root);
            

    }
}