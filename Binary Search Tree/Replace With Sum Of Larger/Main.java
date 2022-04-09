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

    // approach 1 inorder kia normmally
    static int sum = 0;

    public static int total(Node node) {
        if (node == null) {
            return 0;
        }
        int lt = total(node.left);
        int rt = total(node.right);

        return lt + rt + node.data;
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        sum = sum - node.data;
        node.data = sum;
        inOrder(node.right);
    }

    public static void rwsol(Node node) {
        sum = total(node);
        inOrder(node);
    }

    // Approach 2-> As our problem deals with replacing with the sum of all larger
    // numbers so while
    // traversing in reverse order we can make sure that we already have the sum of
    // all numbers greater
    // than the current node then we can simply replace the nodes data with the sum
    // and continue our
    // traversal.

    // static int sum = 0;
    // public static void rwsol(Node node){
    // if(node == null){
    // return;
    // }
    // rwsol(node.right);
    // int order = node.data;
    // node.data = sum;
    // sum+=order;
    // rwsol(node.left);
    // }

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
        rwsol(root);

        display(root);
    }

}