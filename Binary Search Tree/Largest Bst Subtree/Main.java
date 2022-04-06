import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
    public static class pairBST{
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }
        // pariBST(){}
        // pairBST(boolean isBST,int min,int max){
        //     this.isBST = isBST;
        //     this.min = min;
        //     this.max = max;
        //     this.root = root;
        //     this.size = size;
        // }
  
    
     public static pairBST bst(Node root){
      if(root == null){
        //   return new pairBST(true , Integer.MAX_VALUE,Integer.MIN_VALUE,null,0);
        pairBST base = new pairBST();
        base.min = Integer.MAX_VALUE;
        base.max = Integer.MIN_VALUE;
        base.isBST = true;
        base.root = null;
        base.size =0;
        return base;
      }
      pairBST leftAns  = bst(root.left);
      pairBST rightAns = bst(root.right);
      
      pairBST myP = new pairBST();
      myP.isBST = leftAns.isBST && rightAns.isBST && (leftAns.max < root.data) && (rightAns.min>root.data);
      myP.min = Math.min(root.data,leftAns.min);
      myP.max = Math.max(root.data,rightAns.max);
      
      if(myP.isBST){
        myP.root = root;
        myP.size = leftAns.size + rightAns.size +1;
      }else if(leftAns.size>rightAns.size){
          myP.root = leftAns.root;
          myP.size = leftAns.size;
      }else{
          myP.root = rightAns.root;
          myP.size = rightAns.size;
      }
      
      return myP;
  }
  
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    pairBST  ans = bst(root);
    System.out.println(ans.root.data +  "@" + ans.size);
  }

}